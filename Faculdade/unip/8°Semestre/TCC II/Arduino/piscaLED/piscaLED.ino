int ledPin = 13; 
void setup() {
  // put your setup code here, to run once:
  pinMode(13, OUTPUT);
}

void loop() {
  // put your main code here, to run repeatedly:
  digitalWrite(ledPin, HIGH);   // liga o LED
                 // temporiza 1 segundo
  digitalWrite(ledPin, LOW);    // desliga o LED
                // aguarda mais um segundo
}
