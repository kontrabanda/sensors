package pl.tomek.sensors.sensorsbackend.sensors.parser;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Component;
import pl.tomek.sensors.sensorsbackend.sensors.model.measurement.Measurement;
import pl.tomek.sensors.sensorsbackend.sensors.model.measurement.MeasurementType;


@Component
public class MeasurementParser implements Parser<Measurement> {
    private static final String NAME_FIELD = "name";
    private static final String UNIT_FIELD = "unit";
    private static final String VALUE_FIELD = "value";
    private static final String TYPE_FIELD = "type";


    @Override
    public Measurement<?> parse(JsonNode input) {
        MeasurementType type = ParserUtil.getEnum(input, TYPE_FIELD, MeasurementType.class, MeasurementType.Unknown);
        Measurement.MeasurementBuilder<?> builder = isNumericType(type) ? getFloatMeasurementBuilder(input) : getTextMeasurementBuilder(input);
        return builder
                .addName(ParserUtil.parseTextOrNull(input, NAME_FIELD))
                .addUnit(ParserUtil.parseTextOrNull(input, UNIT_FIELD))
                .addType(type)
                .build();
    }

    private Measurement.MeasurementBuilder<String> getTextMeasurementBuilder(JsonNode input) {
        return Measurement.MeasurementBuilder.of(String.class)
                .addValue(ParserUtil.parseTextOrNull(input, VALUE_FIELD));
    }

    private Measurement.MeasurementBuilder<Float> getFloatMeasurementBuilder(JsonNode input) {
        return Measurement.MeasurementBuilder.of(Float.class)
                .addValue(ParserUtil.parseFloatOrNull(input, VALUE_FIELD));
    }

    private boolean isNumericType(MeasurementType type) {
        return type == MeasurementType.Number || type  == MeasurementType.Percentage;
    }
}
