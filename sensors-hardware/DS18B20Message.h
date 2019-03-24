#ifndef DS18B20_MESSAGE_H
#define DS18B20_MESSAGE_H

#include <OneWire.h>
#include <DallasTemperature.h>

#include "SensorMessage.h"

class DS18B20Message: public SensorMessage {
public:
	String createMessage();
  String getName() {
    return "DS18B20";
  }
  void begin();
  DS18B20Message(int pin): pin(pin), oneWire(pin), temperatureSensor(&oneWire) { }
private:
  int pin;
	OneWire oneWire;
	DallasTemperature temperatureSensor;
};

#endif
