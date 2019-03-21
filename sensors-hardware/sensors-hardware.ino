#include <ESP8266WiFi.h>  
#include <OneWire.h>
#include <DallasTemperature.h>
#include <DHT.h>

const char* ssid     = "UPC2622721"; // Tu wpisz nazwę swojego wifi
const char* password = "EBHUUEVD"; // Tu wpisz hasło do swojego wifi
 
WiFiServer server(80);

DHT dht;
OneWire oneWire(D1);
DallasTemperature temperatureSensor(&oneWire);

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

  //dht.setup(5);
  dht.setup(D2);
  temperatureSensor.begin();
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
  Serial.println(request);
  client.flush();
   
  // Return the response
  client.println("HTTP/1.1 200 OK");
  client.println("Content-Type: text/html");
  client.println(""); //  do not forget this one
  client.println("");
  client.println("");
  
  int wilgotnosc = dht.getHumidity();
  client.print("TEST: ");
  client.print(wilgotnosc);
  client.print("%RH | ");
  delay(100);
  
  //Pobranie informacji o temperaturze
  int temperatura = dht.getTemperature();
  client.print(temperatura);
  client.print("*C");
  delay(100);

  temperatureSensor.requestTemperatures();
  client.print("| Aktualna temperatura: ");
  client.print(temperatureSensor.getTempCByIndex(0));
  client.print("*C");
  delay(100);
  
  client.println("");
  client.println("");
  client.println("");
  client.println("");
  client.println("");
  client.println("");
  delay(1);
  Serial.println("Client disonnected");
  Serial.println("");
}
