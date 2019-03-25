package pl.tomek.sensors.sensorsbackend.sensors.message.parser;

import com.fasterxml.jackson.databind.JsonNode;
import pl.tomek.sensors.sensorsbackend.sensors.message.SensorMessage;

public interface MessageParser<T extends SensorMessage> {
    T parse(JsonNode input);
}
