#include "SensorsCompositeMessage.h"


void SensorsCompositeMessage::begin()
{
  for (int i = 0; i < size; i++) {
      sensors[i]->begin();
  }
}

String SensorsCompositeMessage::createMessage()
{
  String msg = String("{");
  msg += String("\"name\": \"") + getName() + String("\",");
  msg += String("\"prefix\": \"") + getPrefix() + String("\",");
  msg += String("\"type\": \"") + getType() + String("\",");
  msg += String("\"sensors\": ") + String("[");
  
  for (int i = 0; i < size-1; i++) {
      msg += sensors[i]->createMessage() + ",";
  }
  
  msg += sensors[size-1]->createMessage();
  msg += String("]}");
  return msg;
}
