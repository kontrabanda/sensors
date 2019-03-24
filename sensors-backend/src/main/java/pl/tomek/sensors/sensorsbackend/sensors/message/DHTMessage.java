package pl.tomek.sensors.sensorsbackend.sensors.message;

public class DHTMessage implements SensorMessage {
    public static final String DHT_NAME = "DHT";

    public int temperature;
    public int humidity;

    @Override
    public String getName() {
        return DHT_NAME;
    }
}
