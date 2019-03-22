#ifndef DS18B20_AND_DHT_MESSAGE_H
#define DS18B20_AND_DHT_MESSAGE_H

#include <OneWire.h>
#include <DallasTemperature.h>
#include <DHT.h>

#include "SensorsMessage.h"

class DS18B20AndDHTMessage: public SensorsMessage {
public:
	String createMessage();
  void begin();
  DS18B20AndDHTMessage(): dht(), oneWire(D1), temperatureSensor(&oneWire) { }
private:
	DHT dht;
	OneWire oneWire;
	DallasTemperature temperatureSensor;
};

#endif
