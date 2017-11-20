int coffeePin = 8;
void setup() {
  Serial.bein(xxx);
  WiFi.begin(NETGEAR87, klkxygulac132);
  
  //Pin to relay
  pinMode(coffeePin, OUTPUT);

  server.begin();
  
}

void loop() {
  // put your main code here, to run repeatedly:
   //tries to reconnect if connection is lost
   if(WiFi.status() != WL_CONNECTED) {
    while(Wifi.status() != WL_CONNECTED) {
      delay500;
    }
   printWiFiStatus();
   }

WiFiClient client = server.available();

  if(client) {
    Serial.println("Client connected);
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

