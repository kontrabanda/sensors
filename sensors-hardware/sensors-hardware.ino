#include "SensorsServer.h"


SensorsServer sensorsServer;

void setup() {
  sensorsServer.start();
}

void loop() {
  sensorsServer.run();
}
