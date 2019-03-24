#ifndef SENSORS_MESSAGE_H
#define SENSORS_MESSAGE_H

#include "WString.h"

class SensorMessage {
public:
  virtual String getPrefix();
  virtual String getType();
  virtual String getName() {
    return getPrefix() + "_" + getType();
  }
  virtual String createMessage();
  virtual void begin();
};

#endif
