package pl.tomek.sensors.sensorsbackend.sensors.message;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
public class CompositeMessage implements SensorMessage {
    public static class CompositeMessageBuilder {
        private String prefix;
        private String name;
        private String type;
        private List<SensorMessage> sensors = new ArrayList<>();

        public static CompositeMessageBuilder of() {
            return new CompositeMessageBuilder();
        }

        public CompositeMessageBuilder addPrefix(String input) {
            prefix = input;
            return this;
        }

        public CompositeMessageBuilder addName(String input) {
            name = input;
            return this;
        }

        public CompositeMessageBuilder addType(String input) {
            type = input;
            return this;
        }

        public CompositeMessageBuilder addSensors(List<SensorMessage> sensors) {
            List<SensorMessage> clonedList = new ArrayList<>(sensors);
            this.sensors = Collections.unmodifiableList(clonedList);
            return this;
        }

        public CompositeMessage build() {
            return new CompositeMessage(this);
        }
    }

    private final String name;
    private final String type;
    private final String prefix;
    private final List<? extends SensorMessage> sensors;

    private CompositeMessage(CompositeMessageBuilder builder) {
        name = builder.name;
        type = builder.type;
        prefix = builder.prefix;
        sensors = builder.sensors;
    }
}
