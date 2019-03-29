package pl.tomek.sensors.sensorsbackend.sensors.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.tomek.sensors.sensorsbackend.sensors.model.message.BoardMessage;
import pl.tomek.sensors.sensorsbackend.sensors.parser.BoardMessageParser;

@Service
public class SensorsMessageService {
    private final RestTemplate restTemplate = new RestTemplate();

    private final BoardMessageParser boardMessageParser;

    @Autowired
    public SensorsMessageService(BoardMessageParser boardMessageParser) {
        this.boardMessageParser = boardMessageParser;
    }

    public BoardMessage getMeasurement(String urlSensors) {
        ResponseEntity<ObjectNode> response = restTemplate.getForEntity(urlSensors, ObjectNode.class);
        return boardMessageParser.parse(response.getBody());
    }
}
