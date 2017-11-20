#include <ESP8266WiFi.h>

int coffeePin = 8;
const char* ssid ="MYSSID";
const char* password = "MYPASS";
WiFiServer server(5000);

void printWiFiStatus();

void setup() {
  Serial.begin(115200);
  WiFi.begin(ssid,password);
  
  //Pin to relay
  pinMode(coffeePin, OUTPUT);

  server.begin();

  
}

void loop() {
  // put your main code here, to run repeatedly:
   //tries to reconnect if connection is lost
   if(WiFi.status() != WL_CONNECTED) {
    while(WiFi.status() != WL_CONNECTED) {
      delay(500);
    }
   printWiFiStatus();
   }

  WiFiClient client = server.available();
  if(client) {
    Serial.println("Client connected");
    while(client.connected()) {
      if(client.available()) {
        char command = client.read();
        //"O" is the ON signal
        if(command == 'O') {
          digitalWrite(coffeePin, HIGH);
          Serial.println("The coffee machine is now on.");
          
        }
        // The off signal is "/"
        else if (command == '/'){
          digitalWrite(coffeePin, LOW);
          Serial.println("The coffee machine is now OFF");
        }
      }
    }

  Serial.println("Client has disconnected");
  client.stop();
    
  }


}
void printWiFiStatus(){
  Serial.println("");
  Serial.print("Connected to ");
  Serial.println(ssid);
  Serial.print("IP address: ");
  Serial.println(WiFi.localIP());
}

