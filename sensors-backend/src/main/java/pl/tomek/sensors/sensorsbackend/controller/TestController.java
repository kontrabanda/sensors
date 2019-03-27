package pl.tomek.sensors.sensorsbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.tomek.sensors.sensorsbackend.sensors.measurement.SensorsMeasurementService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/test")
public class TestController {
    private final SensorsMeasurementService sensorsMeasurementService;

    @Autowired
    public TestController(SensorsMeasurementService sensorsMeasurementService) {
        this.sensorsMeasurementService = sensorsMeasurementService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Object test() {
        Map<String, Object> result = new HashMap<>();
        result.put("text", sensorsMeasurementService.getMeasurement("http://192.168.0.35/"));
        return result;
    }
}
