package pl.tomek.sensors.sensorsbackend.sensors.measurement;

import com.fasterxml.jackson.databind.JsonNode;
import pl.tomek.sensors.sensorsbackend.sensors.measurement.model.Measurement;

interface MeasurementParser<T extends Measurement> {
    T parse(JsonNode input);
}
