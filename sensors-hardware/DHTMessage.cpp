#include "DHTMessage.h"


void DHTMessage::begin()
{
  dht.setup(pin);
}

String DHTMessage::createMessage()
{
	int humidity = dht.getHumidity();
	delay(100);

	int temperature = dht.getTemperature();
	delay(100);

	return String("{") +
         String("\"name\":") + "\"" + getName() + "\"" +
         String(",") +
         String("\"type\": \"") + getType() + String("\"") +
         String(",") +
         String("\"prefix\": \"") + getPrefix() + String("\"") +
         String(",") +
		     String("\"temperature\":") + String(temperature) + 
		     String(",") +
		     String("\"humidity\":") + String(humidity) +
		   String("}");
}
