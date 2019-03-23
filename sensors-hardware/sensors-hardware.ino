#include "SensorsServer.h"
#include "SensorsMessage.h"
#include "DS18B20AndDHTMessage.h"

#include "MainConst.h"

DS18B20AndDHTMessage sensorsMessage(dhtPin, ds18b20Pin);
SensorsServer sensorsServer(ssid, password, &sensorsMessage);

void setup() {
  sensorsServer.start();
}

void loop() {
  sensorsServer.run();
}
