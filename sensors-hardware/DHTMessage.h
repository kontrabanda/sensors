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
  String getSerial() {
    return serial;
  }
  void begin();
  DHTMessage(String serial, int pin): serial(serial), pin(pin), dht() { }
private:
  String serial;
  int pin;
  DHT dht;
};

#endif
