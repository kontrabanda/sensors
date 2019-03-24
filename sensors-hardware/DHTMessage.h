#ifndef DHT_MESSAGE_H
#define DHT_MESSAGE_H

#include <DHT.h>

#include "SensorMessage.h"

class DHTMessage: public SensorMessage {
public:
  String createMessage();
  String getName() {
    return "DHT";
  }
  void begin();
  DHTMessage(int pin): pin(pin), dht() { }
private:
  int pin;
  DHT dht;
};

#endif
