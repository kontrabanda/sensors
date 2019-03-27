package pl.tomek.sensors.sensorsbackend.sensors.measurement.model;

import lombok.Getter;


@Getter
public class Ds18b20Measurement implements Measurement {
    public static final String TYPE = "DS18B20";

    public static class Ds18b20MeasurementBuilder {
        private String id;
        private String type;
        private String serial;
        private Float temperature;

        public static Ds18b20MeasurementBuilder of() {
            return new Ds18b20MeasurementBuilder();
        }

        public Ds18b20MeasurementBuilder addId(String input) {
            id = input;
            return this;
        }

        public Ds18b20MeasurementBuilder addType(String input) {
            type = input;
            return this;
        }

        public Ds18b20MeasurementBuilder addSerial(String input) {
            serial = input;
            return this;
        }

        public Ds18b20MeasurementBuilder addTemperature(Float input) {
            temperature = input;
            return this;
        }

        public Ds18b20Measurement build() {
            return new Ds18b20Measurement(this);
        }
    }

    private final String id;
    private final String type;
    private final String serial;
    private final Float temperature;

    private Ds18b20Measurement(Ds18b20MeasurementBuilder builder) {
        id = builder.id;
        type = builder.type;
        serial = builder.serial;
        temperature = builder.temperature;
    }

    @Override
    public String toString() {
        return "Ds18b20Measurement{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", serial='" + serial + '\'' +
                ", temperature=" + temperature +
                '}';
    }
}
