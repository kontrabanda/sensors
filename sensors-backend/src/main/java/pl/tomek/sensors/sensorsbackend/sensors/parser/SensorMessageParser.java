package pl.tomek.sensors.sensorsbackend.sensors.parser;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.tomek.sensors.sensorsbackend.sensors.model.message.SensorMessage;


@Component
public class SensorMessageParser implements Parser<SensorMessage> {
    private static final String DESCRIPTION_FIELD = "description";
    private static final String MEASUREMENT_FIELD = "measurement";

    private final DeviceDescriptionParser deviceDescriptionJsonParser;
    private final MeasurementParser measurementParser;

    @Autowired
    public SensorMessageParser(DeviceDescriptionParser deviceDescriptionJsonParser, MeasurementParser measurementParser) {
        this.deviceDescriptionJsonParser = deviceDescriptionJsonParser;
        this.measurementParser = measurementParser;
    }

    @Override
    public SensorMessage parse(JsonNode input) {
        return SensorMessage.SensorMessageBuilder.of()
                .addDescription(ParserUtil.parseObjectOrNull(input, DESCRIPTION_FIELD, deviceDescriptionJsonParser))
                .addMeasurements(ParserUtil.parseList(input, MEASUREMENT_FIELD, measurementParser))
                .build();
    }
}
