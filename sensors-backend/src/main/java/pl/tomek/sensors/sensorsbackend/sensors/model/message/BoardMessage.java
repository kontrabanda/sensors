package pl.tomek.sensors.sensorsbackend.sensors.model.message;

import lombok.Getter;
import pl.tomek.sensors.sensorsbackend.sensors.model.device.DeviceDescription;

import java.util.ArrayList;
import java.util.List;

@Getter
public class BoardMessage {
    public static class BoardMessageBuilder {
        private DeviceDescription description;
        private List<SensorMessage> sensorMessages = new ArrayList<>();

        public static BoardMessageBuilder of() {
            return new BoardMessageBuilder();
        }

        public BoardMessageBuilder addDescription(DeviceDescription input) {
            description = input;
            return this;
        }

        public BoardMessageBuilder addSensorsMessages(List<SensorMessage> input) {
            sensorMessages = List.copyOf(input);
            return this;
        }

        public BoardMessage build() {
            return new BoardMessage(this);
        }
    }

    private final DeviceDescription description;
    private final List<SensorMessage> sensorMessages;

    private BoardMessage(BoardMessageBuilder builder) {
        this.description = builder.description;
        this.sensorMessages = builder.sensorMessages;
    }

    @Override
    public String toString() {
        return "BoardMessage{" +
                "description=" + description +
                ", sensorMessages=" + sensorMessages +
                '}';
    }
}
