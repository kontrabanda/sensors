#include "DS18B20AndDHTMessage.h"


void DS18B20AndDHTMessage::begin()
{
  dht.setup(D2);
  temperatureSensor.begin();
}

String DS18B20AndDHTMessage::createMessage()
{
	int dhtHumidity = dht.getHumidity();
	delay(100);

	int dthTemperature = dht.getTemperature();
	delay(100);

	temperatureSensor.requestTemperatures();
	float ds18b20Temperature = temperatureSensor.getTempCByIndex(0);
	delay(100);

	return String("{") +
				  String("\"ds18b20Temperature\":") + String(ds18b20Temperature, 2) + 
				  String(",") +
				  String("\"dhtTemperature\":") + String(dthTemperature) + 
				  String(",") +
				  String("\"dhtHumidity\":") + String(dhtHumidity) +
				 String("}");
}
