#ifndef SENSORS_MESSAGE_H
#define SENSORS_MESSAGE_H

class SensorsMessage {
public:
  virtual String createMessage();
  virtual void begin();
};

#endif
