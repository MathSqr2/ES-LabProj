package Main.Controller;

import Main.ApiClasses.Forecast;
import Main.Schedule.ScheduledTasks;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.*;

@Controller
public class LinkController {

    @RequestMapping("/")
    public String index()
    {
        return "redirect:/home";
    }

    @RequestMapping("/home")
    public ModelAndView home()
    {
        Forecast aux1 = ScheduledTasks.getInfo().peek();

        System.out.println("Clicked Home!");

        ModelAndView home = new ModelAndView("Home.html");
        home.addObject("forecast", aux1);

        return home;
    }

    @GetMapping("/info/{id}")
    public ModelAndView info(@PathVariable("id") int id) throws SQLException {
        String prec = null;
        int temp_min = 0;
        int temp_max = 0;
        String city_name = null;
        String pred_wind_dir = null;
        String latitude = null;
        String longitude = null;

        ModelAndView info = new ModelAndView("Info.html");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/weather","afonso","1234");
        String query = "select weather.prec, weather.temp_min, weather.temp_max, weather.city_name_fk, weather.pred_wind_dir, weather.latitude, weather.longitude  " +
                       "from weather " +
                       "where globalIdLocal = "+id;

        Statement st = con.createStatement();
        ResultSet res = st.executeQuery(query);

        while (res.next())
        {
            prec = res.getString("prec");
            temp_min = res.getInt("temp_min");
            temp_max = res.getInt("temp_max");
            city_name = res.getString("city_name_fk");
            pred_wind_dir = res.getString("pred_wind_dir");
            latitude = res.getString("latitude");
            longitude = res.getString("longitude");
        }
        st.close();

        info.addObject("prec", prec);
        info.addObject("t_min", temp_min);
        info.addObject("t_max", temp_max);
        info.addObject("city_name", city_name);
        info.addObject("pred_wind_dir", pred_wind_dir);
        info.addObject("lat", latitude);
        info.addObject("long", longitude);

        return info;
    }
}
