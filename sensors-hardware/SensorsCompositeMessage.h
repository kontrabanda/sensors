#ifndef SENSORS_COMPOSITE_MESSAGE_H
#define SENSORS_COMPOSITE_MESSAGE_H

#include "SensorMessage.h"

class SensorsCompositeMessage: public SensorMessage {
public:
  String createMessage();
  String getPrefix() {
    return prefix;
  }
  String getType() {
    return type;
  }
  void begin();
  SensorsCompositeMessage(String type, String prefix, SensorMessage** sensors, int size): type(type), prefix(prefix), sensors(sensors), size(size) { }
private:
  String type;
  String prefix;
  SensorMessage** sensors;
  int size;
};

#endif
