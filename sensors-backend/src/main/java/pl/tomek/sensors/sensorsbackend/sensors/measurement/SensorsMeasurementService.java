package pl.tomek.sensors.sensorsbackend.sensors.measurement;

import com.fasterxml.jackson.databind.node.ObjectNode;
import io.reactivex.Observable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.tomek.sensors.sensorsbackend.sensors.measurement.model.Measurement;

import java.util.concurrent.TimeUnit;

@Service
public class SensorsMeasurementService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final EspOneMeasurementParser espOneMeasurementParser;

    @Autowired
    public SensorsMeasurementService(EspOneMeasurementParser espOneMeasurementParser) {
        this.espOneMeasurementParser = espOneMeasurementParser;
    }

    public Observable<Measurement> getMeasurement(long period, TimeUnit timeUnit) {
        return Observable.interval(period, timeUnit)
                .map(el -> getMeasurement("http://192.168.0.35/"));
    }

    public Measurement getMeasurement(String urlSensors) {
        ResponseEntity<ObjectNode> response = restTemplate.getForEntity(urlSensors, ObjectNode.class);
        return espOneMeasurementParser.parse(response.getBody());
    }
}
