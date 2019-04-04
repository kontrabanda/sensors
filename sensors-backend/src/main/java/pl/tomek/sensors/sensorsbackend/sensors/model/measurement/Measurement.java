package pl.tomek.sensors.sensorsbackend.sensors.model.measurement;

import lombok.Getter;

@Getter
public class Measurement<T> {
    public static class MeasurementBuilder<T> {
        private String name;
        private String unit;
        private MeasurementType type = MeasurementType.Unknown;
        private T value;

        public static MeasurementBuilder of() {
            return new MeasurementBuilder<>();
        }

        public static <T> MeasurementBuilder<T> of(Class<T> tClass) {
            return new MeasurementBuilder<>();
        }

        public MeasurementBuilder<T> addName(String input) {
            name = input;
            return this;
        }

        public MeasurementBuilder<T> addValue(T input) {
            value = input;
            return this;
        }

        public MeasurementBuilder<T> addUnit(String input) {
            unit = input;
            return this;
        }

        public MeasurementBuilder<T> addType(MeasurementType input) {
            type = input;
            return this;
        }

        public Measurement<T> build() {
            return new Measurement<>(this);
        }
    }

    private final String name;
    private final T value;
    private final String unit;
    private final MeasurementType type;

    private Measurement(MeasurementBuilder<T> builder) {
        this.name = builder.name;
        this.value = builder.value;
        this.unit = builder.unit;
        this.type = builder.type;
    }

    @Override
    public String toString() {
        return "Measurement{" +
                "name='" + name + '\'' +
                ", value=" + value +
                ", unit='" + unit + '\'' +
                ", type=" + type +
                '}';
    }
}
