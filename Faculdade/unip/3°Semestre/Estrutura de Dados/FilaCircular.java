
public class Fila {
	
	private int dados[];
    private int tamanho;  
    private int inicio;
    private int fim;
    
public Fila(){
        dados=new int [5];
        tamanho=0;
        inicio = 0;
        fim = -1;
    }

//método de auxilio utilizado para verificar caso a lista esteja vazia ,caso tamanho seja igual a zero a  lista está vazia
public boolean vazia (){
        return tamanho==0;
 }

public void primeiro() {
	if (vazia()) 
		System.out.println("Fila vazia");
	else {
		 System.out.print("Elemento do início da Fila: " + dados[inicio]);
	}
}


public boolean cheia() {
	if (tamanho == dados.length) 
		return true;
	else return false;
}

//parâmetro “x” será referente ao  dado a ser inserido na fila.
public void adicionafinal (int x){
//  devemos sempre devemos verificar se a fila está cheia através do método .
        if(!cheia())
       {
        	fim = (fim+1) % dados.length;
            dados[fim]=x;
            tamanho++;  // adiciona uma casa  aumentando o  tamanho  do arranjo.
            System.out.println("Elemento inserido: "+ dados[fim]);
       }
        else
        {
            System.out.println("Erro: Fila esta cheia");
        }  
    }

public void removeinicio(){
    if(!vazia()){           // método verifica se está cheia
    	primeiro();
        System.out.println(" Elemento removido: " + dados[inicio]);
        dados[inicio]=0; // adiciona 0 para mostrar que o elemento foi removido
        tamanho--;   
        inicio = (inicio+1) % dados.length;	
       
     }
    else{
           System.out.println("Fila vazia: não é possível  adicionar mais elementos"); 
       
        }
   }

public void imprimir(){
	System.out.print("Dados no vetor: ");
	for(int i=0; i<dados.length; i++)
		System.out.print(" " + dados[i]);
	System.out.println(" ");
}


}
