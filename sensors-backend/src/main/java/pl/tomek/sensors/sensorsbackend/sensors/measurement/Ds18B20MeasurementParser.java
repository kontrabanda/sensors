package pl.tomek.sensors.sensorsbackend.sensors.measurement;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Component;
import pl.tomek.sensors.sensorsbackend.sensors.measurement.model.Ds18b20Measurement;
import pl.tomek.sensors.sensorsbackend.util.ParserUtil;


@Component
class Ds18B20MeasurementParser implements MeasurementParser<Ds18b20Measurement> {
    private static final String ID_FIELD = "id";
    private static final String TYPE_FIELD = "type";
    private static final String SERIAL_FIELD = "serial";
    private static final String TEMPERATURE_FIELD = "temperature";

    @Override
    public Ds18b20Measurement parse(JsonNode input) {
        return Ds18b20Measurement.Ds18b20MeasurementBuilder.of()
                .addId(ParserUtil.parseTextOrNull(input, ID_FIELD))
                .addType(ParserUtil.parseTextOrNull(input, TYPE_FIELD))
                .addSerial(ParserUtil.parseTextOrNull(input, SERIAL_FIELD))
                .addTemperature(ParserUtil.parseFloatOrNull(input, TEMPERATURE_FIELD))
                .build();
    }
}
