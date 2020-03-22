package Main.Schedule;

import Main.ApiClasses.Forecast;
import Main.ApiClasses.ForecastData;
import Main.Kafka.KafkaSender;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Stack;

@Component
public class ScheduledTasks {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
    public static Stack<Forecast> listComplete = new Stack<>();
    private String date = "";
    private boolean first_time = true;

    @Autowired
    KafkaSender kafkaSender;

    @Async
    @Scheduled(fixedRate = 60000)
    public void getWeatherInfo() throws SQLException {

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/weather","afonso","1234");

        RestTemplate restTemplate = new RestTemplate();
        Forecast response1 = restTemplate.getForObject("http://api.ipma.pt/open-data/forecast/meteorology/cities/daily/hp-daily-forecast-day0.json", Forecast.class);

        if (!(date.equalsIgnoreCase(response1.getDataUpdate())) || first_time)
        {
            // Updates the value of date so it can get checked later
            date = response1.getDataUpdate();

            // Changes value of __first_time if it is indeed the first time
            if (first_time)
                first_time = false;

            // Gets the arrayList with all the info for the Cities
            ArrayList<ForecastData> infoCities = response1.getData();

            // Interate through the list of cities to update the DB
            for (int i = 0; i < infoCities.size(); i++)
            {
                String query = "UPDATE weather " +
                               "SET weather.prec = ?, weather.temp_min=?, weather.temp_max=?, weather.pred_wind_dir=? " +
                               "WHERE weather.globalIdLocal = ?";

                PreparedStatement st = con.prepareStatement(query);
                st.setString(1, infoCities.get(i).getPrecipitaProb());
                st.setInt(2, infoCities.get(i).getTMin());
                st.setInt(3, infoCities.get(i).getTMax());
                st.setString(4, infoCities.get(i).getPredWindDir());
                st.setInt(5, infoCities.get(i).getGlobalIdLocal());

                int rs = st.executeUpdate();
            } // end of FOR LOOP that iterates list cities

            con.close();
            kafkaSender.send("Information was retrieved from the REST API - IPMA -- " + response1.getDataUpdate());

            //log.info("Information was retrieved from the REST API - IPMA -- " + response1.getDataUpdate());
            listComplete.add(response1);

        }
        else
        {
            kafkaSender.send("Information was NOT retrieved from the REST API because it was not updated -- " + response1.getDataUpdate());
            //log.info("Information was NOT retrieved from the REST API because it was not updated -- " + response1.getDataUpdate());
        }

    }

    public static Stack<Forecast> getInfo()
    {
        return listComplete;
    }
}
