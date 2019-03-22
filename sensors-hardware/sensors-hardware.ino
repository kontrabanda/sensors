#include <ESP8266WiFi.h>  
#include <OneWire.h>
#include <DallasTemperature.h>
#include <DHT.h>

#include "SensorsMessage.h"
#include "DS18B20AndDHTMessage.h"

const char* ssid     = "UPC2622721"; // Tu wpisz nazwę swojego wifi
const char* password = "EBHUUEVD"; // Tu wpisz hasło do swojego wifi
 
WiFiServer server(80);

DHT dht;
OneWire oneWire(D1);
DallasTemperature temperatureSensor(&oneWire);

DS18B20AndDHTMessage sensorsMessage;

void setup() {
  Serial.begin(9600);
  delay(10);
    
  // Connect to WiFi network
  Serial.println();
  Serial.println();
  Serial.print("Connecting to ");
  Serial.println(ssid);
   
  WiFi.begin(ssid, password);
  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }
   
  Serial.println("");
  Serial.println("WiFi connected");
   
  // Start the server
  server.begin();
  Serial.println("Server started");
   
  // Print the IP address
  Serial.print("Use this URL to connect: ");
  Serial.print("http://");
  Serial.print(WiFi.localIP());
  Serial.println("/"); 

  sensorsMessage.begin();
}

void loop() {
  // Check if a client has connected
  WiFiClient client = server.available();
  if (!client) {
    return;
  }
   
  // Wait until the client sends some data
  Serial.println("new client");
  int timewate = 0;
  while(!client.available()){
    delay(1);
    timewate = timewate +1;
    if(timewate>1800)
    {
      Serial.println(">>> Client Timeout !");
      client.stop();
      return;
    }
  }
   
  // Read the first line of the request
  String request = client.readStringUntil('\r');
  client.flush();
   
  // Return the response
  client.println("HTTP/1.1 200 OK");
  client.println("Content-Type: application/json");
  client.println(""); //  do not forget this one

  String msg = sensorsMessage.createMessage();
  client.print(msg);
  delay(1);
  Serial.println("Client disonnected");
  Serial.println("");
}
