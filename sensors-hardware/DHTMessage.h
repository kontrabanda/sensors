#ifndef DHT_MESSAGE_H
#define DHT_MESSAGE_H

#include <DHT.h>

#include "SensorMessage.h"

class DHTMessage: public SensorMessage {
public:
  String createMessage();
  String getType() {
    return "DHT";
  }
  String getPrefix() {
    return prefix;
  }
  void begin();
  DHTMessage(String prefix, int pin): prefix(prefix), pin(pin), dht() { }
private:
  String prefix;
  int pin;
  DHT dht;
};

#endif
