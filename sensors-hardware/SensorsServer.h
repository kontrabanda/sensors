#ifndef SENSORS_SERVER_H
#define SENSORS_SERVER_H

#include <ESP8266WiFi.h>  

#include "SensorsMessage.h"
#include "DS18B20AndDHTMessage.h"

class SensorsServer {
public:
  void start();
  void run();
  SensorsServer(): sensorsMessage(), server(80) { }
private:
  const char* ssid     = "UPC2622721"; // Tu wpisz nazwę swojego wifi
  const char* password = "EBHUUEVD"; // Tu wpisz hasło do swojego wifi
  WiFiServer server;
  DS18B20AndDHTMessage sensorsMessage;
  
};

#endif
