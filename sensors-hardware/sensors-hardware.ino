#include "SensorsServer.h"

//const char* ssid     = "UPC2622721"; // Tu wpisz nazwę swojego wifi
//const char* password = "EBHUUEVD"; // Tu wpisz hasło do swojego wifi

SensorsServer sensorsServer;

void setup() {
  sensorsServer.start();
}

void loop() {
  sensorsServer.run();
}
