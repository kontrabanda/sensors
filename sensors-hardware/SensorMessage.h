#ifndef SENSORS_MESSAGE_H
#define SENSORS_MESSAGE_H

#include "WString.h"

class SensorMessage {
public:
  virtual String getSerial();
  virtual String getType();
  virtual String getId() {
    return getSerial() + "_" + getType();
  }
  String getDescription() {
    return String("{") +
             String("\"id\":") + "\"" + getId() + "\"" +
             String(",") +
             String("\"type\": \"") + getType() + String("\"") +
             String(",") +
             String("\"serial\": \"") + getSerial() + String("\"") +
           String("}");
  }
  virtual String createMessage();
  virtual void begin();
};

#endif
