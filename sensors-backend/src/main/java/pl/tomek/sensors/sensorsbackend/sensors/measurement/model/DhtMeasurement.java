package pl.tomek.sensors.sensorsbackend.sensors.measurement.model;

import lombok.Getter;


@Getter
public class DhtMeasurement implements Measurement {
    public static final String TYPE = "DHT";

    public static class DhtMeasurementBuilder {
        private String id;
        private String type;
        private String serial;
        private Integer temperature;
        private Integer humidity;

        public static DhtMeasurementBuilder of() {
            return new DhtMeasurementBuilder();
        }

        public DhtMeasurementBuilder addId(String input) {
            id = input;
            return this;
        }

        public DhtMeasurementBuilder addType(String input) {
            type = input;
            return this;
        }

        public DhtMeasurementBuilder addSerial(String input) {
            serial = input;
            return this;
        }

        public DhtMeasurementBuilder addTemperature(Integer input) {
            temperature = input;
            return this;
        }

        public DhtMeasurementBuilder addHumidity(Integer input) {
            humidity = input;
            return this;
        }

        public DhtMeasurement build() {
            return new DhtMeasurement(this);
        }
    }

    private final String id;
    private final String type;
    private final String serial;
    private final Integer temperature;
    private final Integer humidity;

    private DhtMeasurement(DhtMeasurementBuilder builder) {
        id = builder.id;
        type = builder.type;
        serial = builder.serial;
        temperature = builder.temperature;
        humidity = builder.humidity;
    }

    @Override
    public String toString() {
        return "DhtMeasurement{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", serial='" + serial + '\'' +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                '}';
    }
}
