package pl.tomek.sensors.sensorsbackend.sensors.message.parser;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Component;
import pl.tomek.sensors.sensorsbackend.sensors.message.Ds18b20Message;


@Component
public class Ds18b20MessageParser implements MessageParser<Ds18b20Message> {
    private static final String NAME_FIELD = "name";
    private static final String PREFIX_FIELD = "prefix";
    private static final String TEMPERATURE_FIELD = "temperature";

    @Override
    public Ds18b20Message parse(JsonNode input) {
        return Ds18b20Message.Ds18b20MessageBuilder.of()
                .addPrefix(ParserUtil.parseTextOrNull(input, PREFIX_FIELD))
                .addName(ParserUtil.parseTextOrNull(input, NAME_FIELD))
                .addTemperature(ParserUtil.parseFloatOrNull(input, TEMPERATURE_FIELD))
                .build();
    }
}
