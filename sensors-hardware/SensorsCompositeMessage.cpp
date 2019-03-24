#include "SensorsCompositeMessage.h"


void SensorsCompositeMessage::begin()
{
  for (int i = 0; i < size; i++) {
      sensors[i]->begin();
  }
}

String SensorsCompositeMessage::getName() {
  String name = String("");
	for (int i = 0; i < size-1; i++) {
      name += sensors[i]->getName() + "_";
  }
  name += sensors[size-1]->getName();
  return name;
}

String SensorsCompositeMessage::createMessage()
{
  String msg = String("{");
  msg += String("\"name\": \"") + sensorName + String("\",");
  msg += String("\"sensors\": ") + String("[");
  
  for (int i = 0; i < size-1; i++) {
      msg += sensors[i]->createMessage() + ",";
  }
  
  msg += sensors[size-1]->createMessage();
  msg += String("]}");
  return msg;
}
