package pl.tomek.sensors.sensorsbackend.sensors.service;

import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;
import org.junit.Test;
import pl.tomek.sensors.sensorsbackend.sensors.model.device.DeviceDescription;
import pl.tomek.sensors.sensorsbackend.sensors.model.measurement.Measurement;
import pl.tomek.sensors.sensorsbackend.sensors.model.measurement.MeasurementType;
import pl.tomek.sensors.sensorsbackend.sensors.model.message.SensorMessage;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

import static org.junit.Assert.*;

public class SensorsMessageServiceTest {

    @Test
    public void testOne() throws Exception {
        /*Observable.fromArray(1, 2, 3, 4, 5)
                .delay(20, TimeUnit.SECONDS)
                .flatMap(num -> Observable.interval(5, TimeUnit.SECONDS).map(el -> "test" + num))
                .subscribe(System.out::println);*/

        /*Observable<String> myObservable = Observable.just("a", "b", "c");
        myObservable.repeatWhen(completed -> completed.delay(3, TimeUnit.SECONDS))
                .subscribe(System.out::println);*/

        Observable<Long> fiveSecondInterval = Observable.interval(5, TimeUnit.SECONDS);
        Observable<Long> thirtySecondInterval = Observable.interval(30, TimeUnit.SECONDS);

        Observable<Integer> ints = Observable.range(1,100);
        Observable<String> texts = Observable.just("A", "B", "C", "D", "E", "F");

        Observable<String> first = Observable.zip(thirtySecondInterval, texts, (interval, item) -> item);
        Observable<Integer> second = Observable.zip(fiveSecondInterval, ints, (interval, item) -> item);

        Observable.combineLatest(first, second, (a, b) -> a + b)
                .subscribe(System.out::println);



        Thread.sleep(100000);
    }

    @Test
    public void testTwo() throws Exception {
        BehaviorSubject<DeviceDescription> subject = BehaviorSubject.create();
        subject.subscribe(System.out::println);

        subject.onNext(getFirstDeviceDescription());
        Thread.sleep(60*1000);
        subject.onNext(getSecondDeviceDescription());
    }

    private DeviceDescription getFirstDeviceDescription() {
        return DeviceDescription.DeviceDescriptionBuilder.of()
                .addId("0001_DS18B20")
                .addSerial("0001")
                .addType("DS18B20")
                .build();
    }

    private DeviceDescription getSecondDeviceDescription() {
        return DeviceDescription.DeviceDescriptionBuilder.of()
                .addId("0002")
                .addSerial("VXYZ")
                .addType("MOCK_2")
                .build();
    }

    @Test
    public void testThree() throws Exception {
        Observable<SensorMessage> ds18b20MessageGenerator = getGeneratorWithInterval(this::getDs18b20MessageGenerator, 8, TimeUnit.SECONDS);
        Observable<SensorMessage> dhtMessageGenerator = getGeneratorWithInterval(this::getDhtMessageGenerator, 11, TimeUnit.SECONDS);

        List<Observable<SensorMessage>> messagesGenerators = List.of(ds18b20MessageGenerator, dhtMessageGenerator);

        Observable.merge(messagesGenerators)
                .subscribe(System.out::println);


        Thread.sleep(5*60*1000);
    }

    private <T> Observable<T> getGeneratorWithInterval(Supplier<Observable<T>> supplier, long period, TimeUnit timeUnit) {
        Observable<Long> intervalGenerator = Observable.interval(period, timeUnit);
        return Observable.zip(intervalGenerator, supplier.get(), (interval, item) -> item);
    }

    private Observable<SensorMessage> getDs18b20MessageGenerator() {
        return Observable.just(
                getDs18b20Message(21.4f),
                getDs18b20Message(25.3f),
                getDs18b20Message(22.7f),
                getDs18b20Message(24.6f),
                getDs18b20Message(25.3f)
        ).repeat(5);
    }

    private Observable<SensorMessage> getDhtMessageGenerator() {
        return Observable.just(
                getDhtMessage(21, 48),
                getDhtMessage(23, 65),
                getDhtMessage(21, 64),
                getDhtMessage(22, 33),
                getDhtMessage(20, 90)
        ).repeat(5);
    }

    private SensorMessage getDs18b20Message(float temperature) {
        DeviceDescription deviceDescription = DeviceDescription.of("0001_DS18B20", "0001", "DS18B20");
        Measurement<Float> temperatureMeasurement = getMeasurement("temperature", temperature, "C", MeasurementType.Number);
        return SensorMessage.of(deviceDescription, Collections.singletonList(temperatureMeasurement));
    }

    private SensorMessage getDhtMessage(int temperature, int humidity) {
        DeviceDescription deviceDescription = DeviceDescription.of("0002_DHT", "0002", "DHT");
        Measurement<Integer> temperatureMeasurement = getMeasurement("temperature", temperature, "C", MeasurementType.Number);
        Measurement<Integer> humidityMeasurement = getMeasurement("humidity", humidity, "%", MeasurementType.Percentage);
        return SensorMessage.of(deviceDescription, List.of(temperatureMeasurement, humidityMeasurement));
    }

    @SuppressWarnings("unchecked")
    private <T> Measurement<T> getMeasurement(String name, T value, String unit, MeasurementType type) {
        return Measurement.MeasurementBuilder.of()
                .addName(name)
                .addValue(value)
                .addUnit(unit)
                .addType(type)
                .build();
    }

}