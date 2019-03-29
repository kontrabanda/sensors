package pl.tomek.sensors.sensorsbackend.sensors.parser;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.tomek.sensors.sensorsbackend.sensors.model.message.BoardMessage;


@Component
public class BoardMessageParser implements Parser<BoardMessage> {
    private static final String DESCRIPTION_FIELD = "description";
    private static final String SENSORS_FIELD = "sensors";

    private final DeviceDescriptionParser deviceDescriptionParser;
    private final SensorMessageParser sensorMessageParser;

    @Autowired
    public BoardMessageParser(DeviceDescriptionParser deviceDescriptionParser, SensorMessageParser sensorMessageParser) {
        this.deviceDescriptionParser = deviceDescriptionParser;
        this.sensorMessageParser = sensorMessageParser;
    }

    @Override
    public BoardMessage parse(JsonNode input) {
        return BoardMessage.BoardMessageBuilder.of()
                .addDescription(ParserUtil.parseObjectOrNull(input, DESCRIPTION_FIELD, deviceDescriptionParser))
                .addSensorsMessages(ParserUtil.parseList(input, SENSORS_FIELD, sensorMessageParser))
                .build();
    }
}
