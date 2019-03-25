package pl.tomek.sensors.sensorsbackend.sensors.message;

import lombok.Getter;


@Getter
public class Ds18b20Message implements SensorMessage {
    public static final String TYPE = "DS18B20";

    public static class Ds18b20MessageBuilder {
        private String prefix;
        private String name;
        private Float temperature;

        public static Ds18b20MessageBuilder of() {
            return new Ds18b20MessageBuilder();
        }

        public Ds18b20MessageBuilder addPrefix(String input) {
            prefix = input;
            return this;
        }

        public Ds18b20MessageBuilder addName(String input) {
            name = input;
            return this;
        }

        public Ds18b20MessageBuilder addTemperature(Float input) {
            temperature = input;
            return this;
        }

        public Ds18b20Message build() {
            return new Ds18b20Message(this);
        }
    }

    private final String prefix;
    private final String name;
    private final Float temperature;

    public Ds18b20Message(Ds18b20Message input) {
        prefix = input.prefix;
        name = input.name;
        temperature = input.temperature;
    }

    private Ds18b20Message(Ds18b20MessageBuilder builder) {
        prefix = builder.prefix;
        name = builder.name;
        temperature = builder.temperature;
    }

    @Override
    public String getType() {
        return TYPE;
    }
}
