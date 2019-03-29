package pl.tomek.sensors.sensorsbackend.sensors.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.tomek.sensors.sensorsbackend.sensors.service.SensorsMessageService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/test")
public class TestController {
    private final SensorsMessageService sensorsMessageService;

    @Autowired
    public TestController(SensorsMessageService sensorsMessageService) {
        this.sensorsMessageService = sensorsMessageService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Object test() {
        Map<String, Object> result = new HashMap<>();
        result.put("text", sensorsMessageService.getMeasurement("http://192.168.0.35/"));
        return result;
    }
}
