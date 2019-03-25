package pl.tomek.sensors.sensorsbackend.sensors;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.tomek.sensors.sensorsbackend.sensors.message.SensorMessage;
import pl.tomek.sensors.sensorsbackend.sensors.message.parser.CompositeMessageParser;

@Service
public class SensorsService {
    private final CompositeMessageParser compositeMessageParser;

    @Autowired
    public SensorsService(CompositeMessageParser compositeMessageParser) {
        this.compositeMessageParser = compositeMessageParser;
    }

    public SensorMessage getSensorMessage() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ObjectNode> response = restTemplate.getForEntity("http://192.168.0.35/", ObjectNode.class);
        return compositeMessageParser.parse(response.getBody());
    }
}
