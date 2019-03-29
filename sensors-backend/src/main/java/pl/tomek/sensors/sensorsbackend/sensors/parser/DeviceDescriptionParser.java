package pl.tomek.sensors.sensorsbackend.sensors.parser;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Component;
import pl.tomek.sensors.sensorsbackend.sensors.model.device.DeviceDescription;


@Component
public class DeviceDescriptionParser implements Parser<DeviceDescription> {
    private static final String ID_FIELD = "id";
    private static final String TYPE_FIELD = "type";
    private static final String SERIAL_FIELD = "serial";

    @Override
    public DeviceDescription parse(JsonNode input) {
        return DeviceDescription.DeviceDescriptionBuilder.of()
                .addId(ParserUtil.parseTextOrNull(input, ID_FIELD))
                .addType(ParserUtil.parseTextOrNull(input, TYPE_FIELD))
                .addSerial(ParserUtil.parseTextOrNull(input, SERIAL_FIELD))
                .build();
    }
}
