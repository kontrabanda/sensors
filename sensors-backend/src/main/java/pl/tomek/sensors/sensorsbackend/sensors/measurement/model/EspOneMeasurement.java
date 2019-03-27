package pl.tomek.sensors.sensorsbackend.sensors.measurement.model;

import lombok.Getter;

@Getter
public class EspOneMeasurement implements Measurement {
    public static class EspOneMeasurementBuilder {
        private String id;
        private String type;
        private String serial;
        private DhtMeasurement dht;
        private Ds18b20Measurement ds18b20;

        public static EspOneMeasurementBuilder of() {
            return new EspOneMeasurementBuilder();
        }

        public EspOneMeasurementBuilder addId(String input) {
            id = input;
            return this;
        }

        public EspOneMeasurementBuilder addSerial(String input) {
            serial = input;
            return this;
        }

        public EspOneMeasurementBuilder addType(String input) {
            type = input;
            return this;
        }

        public EspOneMeasurementBuilder addDht(DhtMeasurement input) {
            dht = input;
            return this;
        }

        public EspOneMeasurementBuilder addDs18b20(Ds18b20Measurement input) {
            ds18b20 = input;
            return this;
        }

        public EspOneMeasurement build() {
            return new EspOneMeasurement(this);
        }
    }

    private final String id;
    private final String type;
    private final String serial;
    private final DhtMeasurement dht;
    private final Ds18b20Measurement ds18b20;

    private EspOneMeasurement(EspOneMeasurementBuilder builder) {
        id = builder.id;
        type = builder.type;
        serial = builder.serial;
        dht = builder.dht;
        ds18b20 = builder.ds18b20;
    }

    @Override
    public String toString() {
        return "EspOneMeasurement{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", serial='" + serial + '\'' +
                ", dht=" + dht +
                ", ds18b20=" + ds18b20 +
                '}';
    }
}
