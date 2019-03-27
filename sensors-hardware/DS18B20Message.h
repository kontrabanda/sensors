#ifndef DS18B20_MESSAGE_H
#define DS18B20_MESSAGE_H

#include <OneWire.h>
#include <DallasTemperature.h>

#include "SensorMessage.h"

class DS18B20Message: public SensorMessage {
public:
	String createMessage();
  String getType() {
    return "DS18B20";
  }
  String getSerial() {
    return serial;
  }
  void begin();
  DS18B20Message(String serial, int pin): serial(serial), pin(pin), oneWire(pin), temperatureSensor(&oneWire) { }
private:
  String serial;
  int pin;
	OneWire oneWire;
	DallasTemperature temperatureSensor;
};

#endif
