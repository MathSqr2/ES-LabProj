package Main;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "owner",
        "country",
        "forecastDate",
        "data",
        "dataUpdate"
})
public class Forecast implements Serializable
{

    @JsonProperty("owner")
    private String owner;
    @JsonProperty("country")
    private String country;
    @JsonProperty("forecastDate")
    private String forecastDate;
    @JsonProperty("data")
    private ArrayList<ForecastData> data = null;
    @JsonProperty("dataUpdate")
    private String dataUpdate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -5674977810870751411L;

    @JsonProperty("owner")
    public String getOwner() {
        return owner;
    }

    @JsonProperty("owner")
    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Forecast withOwner(String owner) {
        this.owner = owner;
        return this;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    public Forecast withCountry(String country) {
        this.country = country;
        return this;
    }

    @JsonProperty("forecastDate")
    public String getForecastDate() {
        return forecastDate;
    }

    @JsonProperty("forecastDate")
    public void setForecastDate(String forecastDate) {
        this.forecastDate = forecastDate;
    }

    public Forecast withForecastDate(String forecastDate) {
        this.forecastDate = forecastDate;
        return this;
    }

    @JsonProperty("data")
    public ArrayList<ForecastData> getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(ArrayList<ForecastData> data) {
        this.data = data;
    }

    public Forecast withData(ArrayList<ForecastData> data) {
        this.data = data;
        return this;
    }

    @JsonProperty("dataUpdate")
    public String getDataUpdate() {
        return dataUpdate;
    }

    @JsonProperty("dataUpdate")
    public void setDataUpdate(String dataUpdate) {
        this.dataUpdate = dataUpdate;
    }

    public Forecast withDataUpdate(String dataUpdate) {
        this.dataUpdate = dataUpdate;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Forecast withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }


}
