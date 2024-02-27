package client.demo.utility;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Utility {

    public String sendPost(String url, String data) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json");
        ResponseEntity<String> responseEntity =
                restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(data, httpHeaders), String.class);
        return responseEntity.getBody();
    }

    public String sendGet(String url) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        return responseEntity.getBody();
    }

    public String sendPut(String url, String data) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json");
        ResponseEntity<String> responseEntity =
                restTemplate.exchange(url, HttpMethod.PUT, new HttpEntity<>(data, httpHeaders), String.class);
        return responseEntity.getBody();
    }


}
