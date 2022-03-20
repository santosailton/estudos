#define ledStatus 5
int valorLDR = 0;

void setup() {
  // put your setup code here, to run once:
  pinMode(ledStatus, OUTPUT);
  Serial.begin(9600);
}

void loop() {
  // put your main code here, to run repeatedly:
  valorLDR = analogRead(A0);
  Serial.println(valorLDR);
  delay(500);
  if(valorLDR > 90){
    digitalWrite(ledStatus,HIGH);
  }else{
    digitalWrite(ledStatus,LOW);
  }
 }
