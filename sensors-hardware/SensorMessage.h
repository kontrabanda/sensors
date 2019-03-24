#ifndef SENSORS_MESSAGE_H
#define SENSORS_MESSAGE_H

#include "WString.h"

class SensorMessage {
public:
  virtual String getName();
  virtual String createMessage();
  virtual void begin();
};

#endif
