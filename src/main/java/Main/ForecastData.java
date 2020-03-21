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

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "precipitaProb",
        "tMin",
        "tMax",
        "predWindDir",
        "idWeatherType",
        "classWindSpeed",
        "longitude",
        "globalIdLocal",
        "latitude",
        "classPrecInt"
})
public class ForecastData implements Serializable
{

    @JsonProperty("precipitaProb")
    private String precipitaProb;
    @JsonProperty("tMin")
    private Integer tMin;
    @JsonProperty("tMax")
    private Integer tMax;
    @JsonProperty("predWindDir")
    private String predWindDir;
    @JsonProperty("idWeatherType")
    private Integer idWeatherType;
    @JsonProperty("classWindSpeed")
    private Integer classWindSpeed;
    @JsonProperty("longitude")
    private String longitude;
    @JsonProperty("globalIdLocal")
    private Integer globalIdLocal;
    @JsonProperty("latitude")
    private String latitude;
    @JsonProperty("classPrecInt")
    private Integer classPrecInt;
    private String local;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -8336729964096368348L;

    @JsonProperty("precipitaProb")
    public String getPrecipitaProb() {
        return precipitaProb;
    }

    @JsonProperty("precipitaProb")
    public void setPrecipitaProb(String precipitaProb) {
        this.precipitaProb = precipitaProb;
    }

    public ForecastData withPrecipitaProb(String precipitaProb) {
        this.precipitaProb = precipitaProb;
        return this;
    }

    @JsonProperty("tMin")
    public Integer getTMin() {
        return tMin;
    }

    @JsonProperty("tMin")
    public void setTMin(Integer tMin) {
        this.tMin = tMin;
    }

    public ForecastData withTMin(Integer tMin) {
        this.tMin = tMin;
        return this;
    }

    @JsonProperty("tMax")
    public Integer getTMax() {
        return tMax;
    }

    @JsonProperty("tMax")
    public void setTMax(Integer tMax) {
        this.tMax = tMax;
    }

    public ForecastData withTMax(Integer tMax) {
        this.tMax = tMax;
        return this;
    }

    @JsonProperty("predWindDir")
    public String getPredWindDir() {
        return predWindDir;
    }

    @JsonProperty("predWindDir")
    public void setPredWindDir(String predWindDir) {
        this.predWindDir = predWindDir;
    }

    public ForecastData withPredWindDir(String predWindDir) {
        this.predWindDir = predWindDir;
        return this;
    }

    @JsonProperty("idWeatherType")
    public Integer getIdWeatherType() {
        return idWeatherType;
    }

    @JsonProperty("idWeatherType")
    public void setIdWeatherType(Integer idWeatherType) {
        this.idWeatherType = idWeatherType;
    }

    public ForecastData withIdWeatherType(Integer idWeatherType) {
        this.idWeatherType = idWeatherType;
        return this;
    }

    @JsonProperty("classWindSpeed")
    public Integer getClassWindSpeed() {
        return classWindSpeed;
    }

    @JsonProperty("classWindSpeed")
    public void setClassWindSpeed(Integer classWindSpeed) {
        this.classWindSpeed = classWindSpeed;
    }

    public ForecastData withClassWindSpeed(Integer classWindSpeed) {
        this.classWindSpeed = classWindSpeed;
        return this;
    }

    @JsonProperty("longitude")
    public String getLongitude() {
        return longitude;
    }

    @JsonProperty("longitude")
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public ForecastData withLongitude(String longitude) {
        this.longitude = longitude;
        return this;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    @JsonProperty("globalIdLocal")
    public Integer getGlobalIdLocal() {
        return globalIdLocal;
    }

    @JsonProperty("globalIdLocal")
    public void setGlobalIdLocal(Integer globalIdLocal) {
        this.globalIdLocal = globalIdLocal;
    }

    public ForecastData withGlobalIdLocal(Integer globalIdLocal) {
        this.globalIdLocal = globalIdLocal;
        return this;
    }

    @JsonProperty("latitude")
    public String getLatitude() {
        return latitude;
    }

    @JsonProperty("latitude")
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public ForecastData withLatitude(String latitude) {
        this.latitude = latitude;
        return this;
    }

    @JsonProperty("classPrecInt")
    public Integer getClassPrecInt() {
        return classPrecInt;
    }

    @JsonProperty("classPrecInt")
    public void setClassPrecInt(Integer classPrecInt) {
        this.classPrecInt = classPrecInt;
    }

    public ForecastData withClassPrecInt(Integer classPrecInt) {
        this.classPrecInt = classPrecInt;
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

    public ForecastData withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
