package pl.tomek.sensors.sensorsbackend.sensors.measurement;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Component;
import pl.tomek.sensors.sensorsbackend.sensors.measurement.model.DhtMeasurement;
import pl.tomek.sensors.sensorsbackend.util.ParserUtil;


@Component
class DhtMeasurementParser implements MeasurementParser<DhtMeasurement> {
    private static final String ID_FIELD = "id";
    private static final String TYPE_FIELD = "type";
    private static final String SERIAL_FIELD = "serial";
    private static final String HUMIDITY_FIELD = "humidity";
    private static final String TEMPERATURE_FIELD = "temperature";

    @Override
    public DhtMeasurement parse(JsonNode input) {
        return DhtMeasurement.DhtMeasurementBuilder.of()
                .addId(ParserUtil.parseTextOrNull(input, ID_FIELD))
                .addType(ParserUtil.parseTextOrNull(input, TYPE_FIELD))
                .addSerial(ParserUtil.parseTextOrNull(input, SERIAL_FIELD))
                .addTemperature(ParserUtil.parseIntegerOrNull(input, TEMPERATURE_FIELD))
                .addHumidity(ParserUtil.parseIntegerOrNull(input, HUMIDITY_FIELD))
                .build();
    }
}
