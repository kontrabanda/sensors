package pl.tomek.sensors.sensorsbackend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/test")
public class TestController {
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Object test() {
        Map<String, Object> result = new HashMap<>();
        result.put("text", getText());
        return result;
    }

    private String getText() {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "http://192.168.0.35/";
        ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl + "/1", String.class);
        return response.getBody();
    }
}
