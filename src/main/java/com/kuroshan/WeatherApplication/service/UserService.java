package com.kuroshan.WeatherApplication.service;

import com.kuroshan.WeatherApplication.response.JsonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class UserService {

    // http://api.openweathermap.org/geo/1.0/direct?q=London&limit=5&appid={API key}
    @Value("${geocoding.baseurl}")
    private String url;
    @Value("${geocoding.apiKey}")
    private String key;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private GettingForeCastService gettingForeCastService;

    public void getGeoLocatio(String location) // orginal
    {
        StringBuilder finalUrl=new StringBuilder(url);
        finalUrl.append("q=");
        finalUrl.append(location);
        finalUrl.append("&limit=1&appid=");
        finalUrl.append(key);
        HttpEntity<Object> httpEntity = new HttpEntity<>(gethttpHeaders()); // in this entiy we can sent header and body ,but here request is get ,so no body needed
        String url = finalUrl.toString();
        log.info(key);
        log.info(url);
     //   String urlll="http://api.openweathermap.org/geo/1.0/direct?q=Chennai&limit=1&appid=2fc79f7ca22775efdc69c4eac62f2eda";
        ResponseEntity<List> response= restTemplate.exchange(url, HttpMethod.GET,httpEntity,List.class) ;
        log.info(response.getBody().toString());
        log.info(response.getBody().get(0).toString());
    }

    public void getGeoLocati(String location) // gives answer;
    {
        StringBuilder finalUrl=new StringBuilder(url);
        finalUrl.append("q=");
        finalUrl.append(location);
        finalUrl.append("&limit=4&appid=");
        finalUrl.append(key);
        HttpEntity<Object> httpEntity = new HttpEntity<>(gethttpHeaders()); // in this entiy we can sent header and body ,but here request is get ,so no body needed
        String url = finalUrl.toString();
        log.info(key);
        log.info(url);
        //   String urlll="http://api.openweathermap.org/geo/1.0/direct?q=Chennai&limit=1&appid=2fc79f7ca22775efdc69c4eac62f2eda";
        ResponseEntity<JsonResponse[]> response= restTemplate.exchange(url, HttpMethod.GET,httpEntity,JsonResponse[].class);
        log.info(response.getBody().toString());
        JsonResponse jsonResponse=response.getBody()[0];
        log.info(jsonResponse.toString());
        log.info(jsonResponse.getLatitude());
    }

    public void getGeoLocation(String location){
        StringBuilder finalUrl=new StringBuilder(url);
        finalUrl.append("q=");
        finalUrl.append(location);
        finalUrl.append("&limit=2&appid=");
        finalUrl.append(key);
        HttpEntity<Object> httpEntity = new HttpEntity<>(gethttpHeaders());
        String url = finalUrl.toString();
        String lat="";
        String lon = "";
        ResponseEntity<List<JsonResponse>> response= restTemplate.exchange(url, HttpMethod.GET, httpEntity, new ParameterizedTypeReference<List<JsonResponse>>() {});
        List<JsonResponse> city=response.getBody();
        if(! city.isEmpty())
        {
            for(JsonResponse jsonResponse:city)
            {
                log.info(jsonResponse.getName());
                lat= jsonResponse.getLatitude();
                lat= jsonResponse.getLongitude();
                Map<String, String> localNames = jsonResponse.getLocalName(); // Get the local names map
                if (localNames != null && !localNames.isEmpty()) {
                    System.out.println("Local Names:");
                    for (Map.Entry<String, String> entry : localNames.entrySet()) {
                        String languageCode = entry.getKey(); // Language code (e.g., "ms", "gu")
                        String localName = entry.getValue(); // Local name
                        System.out.println("  " + languageCode + ": " + localName);
                    }
                }
            }
        }
        // here we have received lat and long , now with this we need to make an api to get today's weather forecast
        // using lat ,long , current date in formate of 2020-03-04
        //https://api.openweathermap.org/data/3.0/onecall/day_summary?lat=39.099724&lon=-94.578331&date=2020-03-04&appid={API key}
        gettingForeCastService.hitForeCastApi(lat,lon);

    }
    private HttpHeaders gethttpHeaders(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}
