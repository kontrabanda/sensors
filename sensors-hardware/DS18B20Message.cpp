#include "DS18B20Message.h"


void DS18B20Message::begin()
{
  temperatureSensor.begin();
}

String DS18B20Message::createMessage()
{
	temperatureSensor.requestTemperatures();
	float temperature = temperatureSensor.getTempCByIndex(0);
	delay(100);

	return String("{") +
          String("\"description\":") + getDescription() +
          String(",") +
          String("\"measurement\":") +
          String("[") +
              String("{") +
                String("\"name\":\"temperature\",") +
  			        String("\"value\":") + String(temperature, 2) + "," +
                String("\"type\":\"Number\",") +
                String("\"unit\":\"C\"") +
              String("}") +
          String("]") +
		     String("}");
}
