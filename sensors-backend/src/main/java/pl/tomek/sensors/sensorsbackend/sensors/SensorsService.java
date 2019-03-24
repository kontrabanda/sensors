package pl.tomek.sensors.sensorsbackend.sensors;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SensorsService {
    public JsonNode getSensorMessage() {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "http://192.168.0.35/";
        ResponseEntity<JsonNode> response = restTemplate.getForEntity(fooResourceUrl, JsonNode.class);
        return response.getBody();
    }
}
