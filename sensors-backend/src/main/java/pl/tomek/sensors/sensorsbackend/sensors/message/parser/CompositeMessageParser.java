package pl.tomek.sensors.sensorsbackend.sensors.message.parser;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.tomek.sensors.sensorsbackend.sensors.message.CompositeMessage;
import pl.tomek.sensors.sensorsbackend.sensors.message.DhtMessage;
import pl.tomek.sensors.sensorsbackend.sensors.message.Ds18b20Message;
import pl.tomek.sensors.sensorsbackend.sensors.message.SensorMessage;

import java.util.*;


@Component
public class CompositeMessageParser implements MessageParser<CompositeMessage> {
    private static final String NAME_FIELD = "name";
    private static final String PREFIX_FIELD = "prefix";
    private static final String TYPE_FIELD = "type";
    private static final String SENSORS_FIELD = "sensors";

    private final Map<String, MessageParser> sensorsParsersMap;
    @Autowired
    public CompositeMessageParser(
        DhtMessageParser dhtMessageParser,
        Ds18b20MessageParser ds18b20MessageParser
    ) {
        this.sensorsParsersMap = Map.ofEntries(
            new AbstractMap.SimpleImmutableEntry<>(DhtMessage.TYPE, dhtMessageParser),
            new AbstractMap.SimpleImmutableEntry<>(Ds18b20Message.TYPE, ds18b20MessageParser)
        );
    }

    @Override
    public CompositeMessage parse(JsonNode input) {
        return CompositeMessage.CompositeMessageBuilder.of()
                .addName(ParserUtil.parseTextOrNull(input, NAME_FIELD))
                .addPrefix(ParserUtil.parseTextOrNull(input, PREFIX_FIELD))
                .addType(ParserUtil.parseTextOrNull(input, TYPE_FIELD))
                .addSensors(getSensorMessages(input))
                .build();
    }

    private List<SensorMessage> getSensorMessages(JsonNode input) {
        JsonNode sensorsNode = input.get(SENSORS_FIELD);
        List<SensorMessage> result = new ArrayList<>();

        for(JsonNode jsonNode : sensorsNode) {
            SensorMessage sensorMessage = parseSensor(jsonNode);
            result.add(sensorMessage);
        }

        return result;
    }

    private SensorMessage parseSensor(JsonNode sensorNode) {
        String sensorType = sensorNode.get(TYPE_FIELD).asText();
        MessageParser messageParser = sensorsParsersMap.get(sensorType);
        return messageParser.parse(sensorNode);
    }
}
