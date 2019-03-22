#include "SensorsServer.h"
#include "SensorsMessage.h"
#include "DS18B20AndDHTMessage.h"

char* ssid     = "*"; // Tu wpisz nazwę swojego wifi
char* password = "*"; // Tu wpisz hasło do swojego wifi
int dhtPin = D2;
int ds18b20Pin = D1;

DS18B20AndDHTMessage sensorsMessage(dhtPin, ds18b20Pin);
SensorsServer sensorsServer(ssid, password, &sensorsMessage);

void setup() {
  sensorsServer.start();
}

void loop() {
  sensorsServer.run();
}
