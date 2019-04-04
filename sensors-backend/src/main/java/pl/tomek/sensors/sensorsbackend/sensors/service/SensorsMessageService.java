package pl.tomek.sensors.sensorsbackend.sensors.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import io.reactivex.Observable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.tomek.sensors.sensorsbackend.sensors.model.message.BoardMessage;
import pl.tomek.sensors.sensorsbackend.sensors.parser.BoardMessageParser;

import javax.annotation.PostConstruct;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
public class SensorsMessageService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final BoardMessageParser boardMessageParser;
    private Observable<BoardMessage> boardMessageObservable;

    @Autowired
    public SensorsMessageService(BoardMessageParser boardMessageParser) {
        this.boardMessageParser = boardMessageParser;
    }

    @PostConstruct
    public void init() {
        boardMessageObservable = Observable.interval(1, TimeUnit.MINUTES)
                .map(time -> getMeasurement("http://192.168.0.35/"))
                .filter(Optional::isPresent)
                .map(Optional::get);
    }

    // TODO exception handling
    public Optional<BoardMessage> getMeasurement(String urlSensors) {
        return Optional.of(urlSensors)
                .map(url -> restTemplate.getForEntity(url, ObjectNode.class))
                .map(ResponseEntity::getBody)
                .map(boardMessageParser::parse);
    }

    public Observable<BoardMessage> getBoardMessage() {
        return boardMessageObservable;
    }
}
