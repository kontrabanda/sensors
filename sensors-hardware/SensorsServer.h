#ifndef SENSORS_SERVER_H
#define SENSORS_SERVER_H

#include "SensorsMessage.h"

class SensorsServer {
public:
  void start();
  void run();
private:
  SensorsMessage sensorsMessage;
  SensorsServer(): sensorsMessage() { }
};

#endif
