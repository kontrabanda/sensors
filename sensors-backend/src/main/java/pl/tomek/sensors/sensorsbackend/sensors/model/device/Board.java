package pl.tomek.sensors.sensorsbackend.sensors.model.device;

import lombok.Getter;

import java.util.List;
import java.util.concurrent.TimeUnit;


@Getter
public class Board {
    public static class BoardBuilder {
        private DeviceDescription description;
        private String url;
        private List<DeviceDescription> sensors;

        private TimeUnit timeUnit = TimeUnit.MINUTES;
        private Long time = 60L;
        private BoardStatus status = BoardStatus.NEW;

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

        public BoardBuilder addTimeUnit(TimeUnit input) {
            timeUnit = input;
            return this;
        }

        public BoardBuilder addTime(Long input) {
            time = input;
            return this;
        }

        public BoardBuilder addStatus(BoardStatus input) {
            status = input;
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
    private final TimeUnit timeUnit;
    private final Long time;
    private final BoardStatus status;
    private final List<DeviceDescription> sensors;

    private Board(BoardBuilder builder) {
        description = builder.description;
        url = builder.url;
        timeUnit = builder.timeUnit;
        time = builder.time;
        status = builder.status;
        sensors = builder.sensors;
    }

    public enum BoardStatus {
        NEW, ACTIVE, INACTIVE
    }

    @Override
    public String toString() {
        return "Board{" +
                "description=" + description +
                ", url='" + url + '\'' +
                ", timeUnit=" + timeUnit +
                ", time=" + time +
                ", status=" + status +
                ", sensors=" + sensors +
                '}';
    }
}
