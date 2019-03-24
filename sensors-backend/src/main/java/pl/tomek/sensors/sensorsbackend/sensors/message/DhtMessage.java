package pl.tomek.sensors.sensorsbackend.sensors.message;

import lombok.Getter;


@Getter
public class DhtMessage implements SensorMessage {
    public static final String TYPE = "DHT";

    private final int temperature;
    private final int humidity;

    public DhtMessage(int temperature, int humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
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
