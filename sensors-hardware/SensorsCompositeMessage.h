#ifndef SENSORS_COMPOSITE_MESSAGE_H
#define SENSORS_COMPOSITE_MESSAGE_H

#include "SensorMessage.h"

class SensorsCompositeMessage: public SensorMessage {
public:
  String createMessage();
  String getName();
  void begin();
  SensorsCompositeMessage(char* sensorName, SensorMessage** sensors, int size): sensorName(sensorName), sensors(sensors), size(size) { }
private:
  char* sensorName;
  SensorMessage** sensors;
  int size;
};

#endif
