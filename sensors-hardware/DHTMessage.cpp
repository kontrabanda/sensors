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
         String("\"description\":") + getDescription() +
         String(",") +
         String("\"measurement\":") +
          String("[") +
              String("{") +
                String("\"name\":\"temperature\",") +
                String("\"value\":") + String(temperature) + "," +
                String("\"type\":\"Number\",") +
                String("\"unit\":\"C\"") +
              String("},") +
              String("{") +
                String("\"name\":\"humidity\",") +
                String("\"value\":") + String(humidity) + "," +
                String("\"type\":\"Percentage\",") +
                String("\"unit\":\"%\"") +
              String("}") +
          String("]") +
		   String("}");
}
