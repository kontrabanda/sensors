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
  DS18B20AndDHTMessage(int dhtPin, int ds18b20Pin): dhtPin(dhtPin), ds18b20Pin(ds18b20Pin), dht(), oneWire(ds18b20Pin), temperatureSensor(&oneWire) { }
private:
  int dhtPin;
  int ds18b20Pin;
  
	DHT dht;
	OneWire oneWire;
	DallasTemperature temperatureSensor;
};

#endif
