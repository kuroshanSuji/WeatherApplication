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
//
//[
//        {
//        "name":"London",
//        "local_names":{
//        "ms":"London",
//        "gu":"લંડન",
//        "is":"London",
//        "wa":"Londe",
//        "mg":"Lôndôna",
//        "ht":"Lonn",
//        "ka":"ლონდონი",
//        "ur":"علاقہ لندن"
//        },
//        "lat":51.5073219,
//        "lon":-0.1276474,
//        "country":"GB",
//        "state":"England"
//        },
//        {
//        "name":"City of London",
//        "local_names":{
//        "es":"City de Londres",
//        "ru":"Сити",
//        "ur":"لندن شہر",
//        "zh":"倫敦市",
//        "en":"City of London",
//        "pt":"Cidade de Londres",
//        "fr":"Cité de Londres",
//        "uk":"Лондонське Сіті",
//        "he":"הסיטי של לונדון",
//        "hi":"सिटी ऑफ़ लंदन",
//        "ko":"시티 오브 런던",
//        "lt":"Londono Sitis"
//        },
//        "lat":51.5156177,
//        "lon":-0.0919983,
//        "country":"GB",
//        "state":"England"
//        }
//]
