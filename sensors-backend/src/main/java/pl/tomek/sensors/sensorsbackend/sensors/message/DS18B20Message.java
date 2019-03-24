package pl.tomek.sensors.sensorsbackend.sensors.message;

public class DS18B20Message implements SensorMessage {
    public static final String DS18B20_NAME = "DS18B20";

    public float temperature;

    @Override
    public String getName() {
        return DS18B20_NAME;
    }
}
