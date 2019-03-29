package pl.tomek.sensors.sensorsbackend.sensors.model.device;

import lombok.Getter;

@Getter
public class DeviceDescription {
    public static class DeviceDescriptionBuilder {
        private String id;
        private String type;
        private String serial;

        public static DeviceDescriptionBuilder of() {
            return new DeviceDescriptionBuilder();
        }

        public DeviceDescriptionBuilder addId(String input) {
            id = input;
            return this;
        }

        public DeviceDescriptionBuilder addType(String input) {
            type = input;
            return this;
        }

        public DeviceDescriptionBuilder addSerial(String input) {
            serial = input;
            return this;
        }

        public DeviceDescription build() {
            return new DeviceDescription(this);
        }
    }

    private final String id;
    private final String type;
    private final String serial;

    private DeviceDescription(DeviceDescriptionBuilder builder) {
        id = builder.id;
        type = builder.type;
        serial = builder.serial;
    }

    @Override
    public String toString() {
        return "DeviceDescription{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", serial='" + serial + '\'' +
                '}';
    }
}
