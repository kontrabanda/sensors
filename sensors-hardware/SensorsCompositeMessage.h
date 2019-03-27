#ifndef SENSORS_COMPOSITE_MESSAGE_H
#define SENSORS_COMPOSITE_MESSAGE_H

#include "SensorMessage.h"

class SensorsCompositeMessage: public SensorMessage {
public:
  String createMessage();
  String getSerial() {
    return serial;
  }
  String getType() {
    return type;
  }
  void begin();
  SensorsCompositeMessage(String type, String serial, SensorMessage** sensors, int size): type(type), serial(serial), sensors(sensors), size(size) { }
private:
  String type;
  String serial;
  SensorMessage** sensors;
  int size;
};

#endif
