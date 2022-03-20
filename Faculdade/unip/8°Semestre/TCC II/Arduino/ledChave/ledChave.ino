const int led = 2;
const int botao = 12;
int estado = 0;

void setup(){
  pinMode(led,OUTPUT);
  pinMode(botao,INPUT);
}
void loop(){
  estado = digitalRead(botao);

  if(estado == HIGH){
    digitalWrite(led,HIGH);//acende o led
  }else{
    digitalWrite(led,LOW);//apaga o led
  }
}
