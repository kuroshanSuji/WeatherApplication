package com.kuroshan.WeatherApplication.service;

import com.kuroshan.WeatherApplication.response.ForeCastResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@Service
@Slf4j
public class GettingForeCastService {
   // https://api.openweathermap.org/data/3.0/onecall/day_summary?lat=39.099724&lon=-94.578331&date=2020-03-04&appid={API key}
    @Value("${geocoding.getweather}")
    private String url;
    @Value("${geocoding.apiKey")
    private String apiKey;
    @Autowired
    private RestTemplate restTemplate;

    public void hitForeCastApi(String lat,String lon)
    {
        log.info(lat);
        log.info(lon);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String formattedDate = formatter.format(date);
        StringBuilder buildingUrl=new StringBuilder(url);
        buildingUrl.append("lat=");
        buildingUrl.append(lat);
        buildingUrl.append("&lon=");
        buildingUrl.append(lon);
        buildingUrl.append("&date=");
        buildingUrl.append(formattedDate);
        buildingUrl.append("&apid=");
        buildingUrl.append(apiKey);
        HttpEntity<Object> httpEntity=new HttpEntity<>(getHttpHeader());
        ResponseEntity<ForeCastResponse> response=restTemplate.exchange(url, HttpMethod.GET, httpEntity, new ParameterizedTypeReference<ForeCastResponse>(){});
    }
    public HttpHeaders getHttpHeader()
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}
