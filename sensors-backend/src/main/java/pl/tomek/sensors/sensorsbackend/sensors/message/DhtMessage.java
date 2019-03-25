package pl.tomek.sensors.sensorsbackend.sensors.message;

import lombok.Getter;


@Getter
public class DhtMessage implements SensorMessage {
    public static final String TYPE = "DHT";

    public static class DhtMessageBuilder {
        private String prefix;
        private String name;
        private Integer temperature;
        private Integer humidity;

        public static DhtMessageBuilder of() {
            return new DhtMessageBuilder();
        }

        public DhtMessageBuilder addPrefix(String input) {
            prefix = input;
            return this;
        }

        public DhtMessageBuilder addName(String input) {
            name = input;
            return this;
        }

        public DhtMessageBuilder addTemperature(Integer input) {
            temperature = input;
            return this;
        }

        public DhtMessageBuilder addHumidity(Integer input) {
            humidity = input;
            return this;
        }

        public DhtMessage build() {
            return new DhtMessage(this);
        }
    }

    private final String prefix;
    private final String name;
    private final Integer temperature;
    private final Integer humidity;

    private DhtMessage(DhtMessageBuilder builder) {
        prefix = builder.prefix;
        name = builder.name;
        temperature = builder.temperature;
        humidity = builder.humidity;
    }

    @Override
    public String getType() {
        return TYPE;
    }
}
