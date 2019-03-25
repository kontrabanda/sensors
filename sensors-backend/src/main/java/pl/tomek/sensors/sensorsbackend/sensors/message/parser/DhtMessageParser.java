package pl.tomek.sensors.sensorsbackend.sensors.message.parser;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Component;
import pl.tomek.sensors.sensorsbackend.sensors.message.DhtMessage;


@Component
public class DhtMessageParser implements MessageParser<DhtMessage> {
    private static final String NAME_FIELD = "name";
    private static final String PREFIX_FIELD = "prefix";
    private static final String HUMIDITY_FIELD = "humidity";
    private static final String TEMPERATURE_FIELD = "temperature";

    @Override
    public DhtMessage parse(JsonNode input) {
        return DhtMessage.DhtMessageBuilder.of()
                .addName(ParserUtil.parseTextOrNull(input, NAME_FIELD))
                .addPrefix(ParserUtil.parseTextOrNull(input, PREFIX_FIELD))
                .addTemperature(ParserUtil.parseIntegerOrNull(input, HUMIDITY_FIELD))
                .addHumidity(ParserUtil.parseIntegerOrNull(input, TEMPERATURE_FIELD))
                .build();
    }
}
