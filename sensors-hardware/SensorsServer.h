#ifndef SENSORS_SERVER_H
#define SENSORS_SERVER_H

#include <ESP8266WiFi.h>

#include "SensorMessage.h"

class SensorsServer {
public:
  void start();
  void run();
  SensorsServer(char* ssid, char* password, SensorMessage* sensorsMsg): ssid(ssid), password(password), sensorsMessage(sensorsMsg), server(80) { }
private:
  char* ssid;
  char* password;
  WiFiServer server;
  SensorMessage* sensorsMessage;
};

#endif
