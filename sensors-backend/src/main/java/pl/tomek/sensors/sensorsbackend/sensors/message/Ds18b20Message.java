package pl.tomek.sensors.sensorsbackend.sensors.message;

import lombok.Getter;


@Getter
public class Ds18b20Message implements SensorMessage {
    public static final String TYPE = "DS18B20";

    private final float temperature;
    private final String prefix;
    private final String name;

    public Ds18b20Message(float temperature, String prefix, String name) {
        this.temperature = temperature;
        this.prefix = prefix;
        this.name = name;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    public String getPrefix() {
        return null;
    }
}
