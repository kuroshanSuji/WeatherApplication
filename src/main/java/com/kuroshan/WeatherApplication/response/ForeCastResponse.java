package com.kuroshan.WeatherApplication.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Map;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ForeCastResponse {
    @JsonProperty("lat")
    private String latitude;
    @JsonProperty("lon")
    private String longtitude;
    @JsonProperty("cloud_cover")
    private Map<String,Integer> couldCover;
    @JsonProperty("humidity")
    private Map<String,Integer> humidity;
    @JsonProperty("temperature")
    private Map<String,Double> temperature;
    @JsonProperty("wind")
    private Wind wind;

}


  /* {
          "lat":33,
          "lon":35,
          "tz":"+02:00",
          "date":"2020-03-04",
          "units":"standard",
          "cloud_cover":{
          "afternoon":0
          },
          "humidity":{
          "afternoon":33
          },
          "precipitation":{
          "total":0
          },
          "temperature":{
          "min":286.48,
          "max":299.24,
          "afternoon":296.15,
          "night":289.56,
          "evening":295.93,
          "morning":287.59
          },
          "pressure":{
          "afternoon":1015
          },
          "wind":{
             "max":{
                    "speed":8.7,
                    "direction":120
                   }
                 }
        } */

