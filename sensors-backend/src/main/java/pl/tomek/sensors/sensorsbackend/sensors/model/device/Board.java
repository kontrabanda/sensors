package pl.tomek.sensors.sensorsbackend.sensors.model.device;

import lombok.Getter;

import java.util.List;


@Getter
public class Board {
    public static class BoardBuilder {
        private DeviceDescription description;
        private String url;
        private List<DeviceDescription> sensors;

        public static BoardBuilder of() {
            return new BoardBuilder();
        }

        public BoardBuilder addDescription(DeviceDescription input) {
            description = input;
            return this;
        }

        public BoardBuilder addUrl(String input) {
            url = input;
            return this;
        }

        public BoardBuilder addSensors(List<DeviceDescription> input) {
            sensors = List.copyOf(input);
            return this;
        }

        public Board build() {
            return new Board(this);
        }
    }

    private final DeviceDescription description;
    private final String url;
    private final List<DeviceDescription> sensors;

    private Board(BoardBuilder builder) {
        description = builder.description;
        url = builder.url;
        sensors = builder.sensors;
    }

    @Override
    public String toString() {
        return "Board{" +
                "description=" + description +
                ", url='" + url + '\'' +
                ", sensors=" + sensors +
                '}';
    }
}
