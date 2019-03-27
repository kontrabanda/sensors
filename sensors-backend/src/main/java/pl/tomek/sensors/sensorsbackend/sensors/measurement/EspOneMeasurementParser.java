package pl.tomek.sensors.sensorsbackend.sensors.measurement;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.tomek.sensors.sensorsbackend.sensors.measurement.model.DhtMeasurement;
import pl.tomek.sensors.sensorsbackend.sensors.measurement.model.Ds18b20Measurement;
import pl.tomek.sensors.sensorsbackend.sensors.measurement.model.EspOneMeasurement;
import pl.tomek.sensors.sensorsbackend.util.ParserUtil;


@Component
public class EspOneMeasurementParser implements MeasurementParser<EspOneMeasurement> {
    private static final String ID_FIELD = "id";
    private static final String TYPE_FIELD = "type";
    private static final String SERIAL_FIELD = "serial";

    private final DhtMeasurementParser dhtMeasurementParser;
    private final Ds18B20MeasurementParser ds18B20MeasurementParser;

    @Autowired
    public EspOneMeasurementParser(
            DhtMeasurementParser dhtMeasurementParser,
            Ds18B20MeasurementParser ds18B20MeasurementParser) {
        this.dhtMeasurementParser = dhtMeasurementParser;
        this.ds18B20MeasurementParser = ds18B20MeasurementParser;
    }

    @Override
    public EspOneMeasurement parse(JsonNode input) {
        return EspOneMeasurement.EspOneMeasurementBuilder.of()
                .addId(ParserUtil.parseTextOrNull(input, ID_FIELD))
                .addType(ParserUtil.parseTextOrNull(input, TYPE_FIELD))
                .addSerial(ParserUtil.parseTextOrNull(input, SERIAL_FIELD))
     //           .addDht(dhtMeasurementParser.parse(input))
       //         .addDs18b20(ds18B20MeasurementParser.parse(input))
                .build();
    }
}
