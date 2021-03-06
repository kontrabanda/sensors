#include "SensorsServer.h"
#include "SensorMessage.h"
#include "SensorsCompositeMessage.h"
#include "DS18B20Message.h"
#include "DHTMessage.h"
#include "MainConst.h"

DS18B20Message ds18b20Message(sensorSerial, ds18b20Pin);
DHTMessage dhtMessage(sensorSerial, dhtPin);
SensorMessage* sensorsMessageArr[] = {&ds18b20Message, &dhtMessage};

SensorsCompositeMessage sensorsMessage(sensorType, sensorSerial, sensorsMessageArr, 2);

SensorsServer sensorsServer(ssid, password, &sensorsMessage);

void setup() {
  sensorsServer.start();
}

void loop() {
  sensorsServer.run();
}
