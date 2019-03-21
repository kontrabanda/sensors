package pl.tomek.sensors.sensorsbackend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/hello")
public class HelloController {
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Object helloWorld() {
        Map<String, Object> result = new HashMap<>();
        result.put("text", "Hello World101!");
        return result;
    }
}
