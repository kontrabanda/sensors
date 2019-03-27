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
         String("\"id\":") + "\"" + getId() + "\"" +
         String(",") +
         String("\"type\": \"") + getType() + String("\"") +
         String(",") +
         String("\"serial\": \"") + getSerial() + String("\"") +
         String(",") +
		     String("\"temperature\":") + String(temperature) + 
		     String(",") +
		     String("\"humidity\":") + String(humidity) +
		   String("}");
}
