package com.kuroshan.WeatherApplication.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Max {
    @JsonProperty("speed")
    private Double speed;
    @JsonProperty("direction")
    private Integer direction;
}
