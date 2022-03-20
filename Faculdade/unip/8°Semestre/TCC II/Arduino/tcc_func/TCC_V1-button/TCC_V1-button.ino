#include <Thermistor.h>

#define led  2        //pino led do botao
#define button  7     //pino botão
#define ledStatus 5   //pino status monitoramento

Thermistor temp(A1);

int valorLDR = 0;
int pressionado = 0; //indicador de status do botao 0 desligado 1 ligado
int ligado = 0;

void setup() {
  // put your setup code here, to run once:
  pinMode(led, OUTPUT);
  pinMode(button, INPUT);
  pinMode(ledStatus, OUTPUT);
  Serial.begin(9600);
  Serial.println("Circuito configurado");
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
        break;
        
      case 1:
        digitalWrite(led, LOW);//envia saida para o led desligar
        Serial.println("Led desligado!");
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
  int temperatura = temp.getTemp();
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
