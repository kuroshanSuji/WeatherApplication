package com.kuroshan.WeatherApplication.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;
import java.util.Map;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonResponse {
    @JsonProperty("name")
    String name;
    @JsonProperty("local_names")
    Map<String,String> localName;
    @JsonProperty("lat")
    String latitude;
    @JsonProperty("lon")
    String longitude;

    public String toString()
    {
        return longitude+" "+latitude;
    }
}
