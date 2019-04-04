package pl.tomek.sensors.sensorsbackend.sensors.model.message;

import lombok.Getter;
import pl.tomek.sensors.sensorsbackend.sensors.model.device.DeviceDescription;
import pl.tomek.sensors.sensorsbackend.sensors.model.measurement.Measurement;

import java.util.List;

@Getter
public class SensorMessage {
    public static class SensorMessageBuilder {
        private DeviceDescription description;
        private List<Measurement> measurements;

        public static SensorMessageBuilder of() {
            return new SensorMessageBuilder();
        }

        public SensorMessageBuilder addDescription(DeviceDescription input) {
            description = input;
            return this;
        }

        public SensorMessageBuilder addMeasurements(List<Measurement> input) {
            measurements = List.copyOf(input);
            return this;
        }

        public SensorMessage build() {
            return new SensorMessage(this);
        }
    }

    private final DeviceDescription description;
    private final List<Measurement> measurements;

    public static SensorMessage of(DeviceDescription description, List<Measurement> measurements) {
        return SensorMessageBuilder.of()
                .addDescription(description)
                .addMeasurements(measurements)
                .build();
    }

    private SensorMessage(SensorMessageBuilder builder) {
        description = builder.description;
        measurements = builder.measurements;
    }

    @Override
    public String toString() {
        return "SensorMessage{" +
                "description=" + description +
                ", measurements=" + measurements +
                '}';
    }
}
