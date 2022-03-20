#include <sim808.h>
#include <DFRobot_sim808.h>
#include <SoftwareSerial.h>
#include <Thermistor.h>

#define PHONE_NUMBER "16981662408"
#define MESSAGE  "hello world"
#define led  2        //pino led do botao
#define button  7     //pino botão
#define ledStatus 5   //pino status monitoramento

//#define PIN_TX    1
//#define PIN_RX    0
//SoftwareSerial mySerial(PIN_TX,PIN_RX);
//DFRobot_SIM808 sim808(&mySerial);//Connect RX,TX,PWR,

DFRobot_SIM808 sim808(&Serial);

Thermistor temp(A1);

int valorLDR = 0;
int pressionado = 0; //indicador de status do botao 0 desligado 1 ligado
int ligado = 0;

bool enviado = false;

void setup() {
  // put your setup code here, to run once:
  pinMode(led, OUTPUT);
  pinMode(button, INPUT);
  pinMode(ledStatus, OUTPUT);
  Serial.begin(9600);
  Serial.println("Circuito configurado");
}
bool enviaSMS(){
 //mySerial.begin(9600);
 enviado = true;
 //******** Initialize sim808 module *************
  while(!sim808.init()) {
      delay(1000);
      Serial.print("Sim808 init error\r\n");
  }  
  Serial.println("Sim808 init success");
  Serial.println("Start to send message ...");

  //******** define phone number and text **********
  sim808.sendSMS(PHONE_NUMBER,MESSAGE);
  return enviado;
}

void loop() {
  // put your main code here, to run repeatedly:
 //código monitoramento de acionamento de partida...?
  pressionado = digitalRead(button);
  if(pressionado == HIGH){//e se ligar o carro...?
    delay(500);
    switch(ligado){
      
      case 0:
        digitalWrite(led, HIGH);//envia saida para o led ligar
        Serial.println("Led ligado!");
        //código sms, call, gps...
        ligado = 1;
        if(enviado == false){
            Serial.println("Enviando SMS...");
            enviado = enviaSMS();
        }
        break;
        
      case 1:
        digitalWrite(led, LOW);//envia saida para o led desligar
        Serial.println("Led desligado!");
        //código sms, call, gps...
        ligado = 0;
        break;
        
      default:
        Serial.println("erro de entrada");
    }
  }
  
//código monitoramento sensor de luz
  valorLDR = analogRead(A0);
  Serial.println(valorLDR);
  delay(500);
  
  if(valorLDR > 90){
    digitalWrite(ledStatus,HIGH);
  }else{
    digitalWrite(ledStatus,LOW);
  }
  
//código monitoramento sensor de temperatura
  int temperatura = temp.getTemp(); //e se ligar o motor...?
  Serial.print("Temperatura: ");
  Serial.print(temperatura);
  Serial.println(" °C");
  delay(500);
  
  if(temperatura > 30){
    digitalWrite(ledStatus,HIGH);
  }else{
    digitalWrite(ledStatus,LOW);
  }
}
