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
  String getPrefix() {
    return prefix;
  }
  void begin();
  DS18B20Message(String prefix, int pin): prefix(prefix), pin(pin), oneWire(pin), temperatureSensor(&oneWire) { }
private:
  String prefix;
  int pin;
	OneWire oneWire;
	DallasTemperature temperatureSensor;
};

#endif
