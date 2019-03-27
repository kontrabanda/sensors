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
  virtual String createMessage();
  virtual void begin();
};

#endif
