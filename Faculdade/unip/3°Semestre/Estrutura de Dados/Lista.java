public class Lista {
	
	private String dados[];
    private int tamanho;   

    // construtor  irá requer o tamanho do arranjo neste caso 10 posições  e a variável tamanho onde */inicializará o arranjo
public Lista(){
        dados=new String [10];
        tamanho=0;
    }

//método de auxilio utilizado para verificar caso a lista esteja vazia ,caso tamanho seja igual a zero a  lista está vazia
public boolean vazia (){
        return tamanho==0;
 }

//método de auxílio utilizado para verificar caso a lista esteja cheia ,caso tamanho seja igual a 10 a lista está cheia.
public boolean cheia (){
    return tamanho ==dados.length;
}

public int tamanho() {
	return tamanho;
}

//Este método será utilizado pelo usuário verificar o conteúdo do arranjo.
public void percorrer(){
        for(int i=0;i < tamanho(); i++)
        {
            System.out.print(" "+dados[i]+" ,");   
        }
        System.out.println(" ");
    }

//parâmetro “x” será referente ao  dado a ser inserido na lista.
public void adicionafinal (String x){
//  devemos sempre devemos verificar se a lista está cheia através do método .
        if(!cheia())
       {
            dados[tamanho]=x;
            tamanho++;  // adiciona uma casa  aumentando o  tamanho  do arranjo.
        }
        else
        {
            System.out.print("Erro na Lista esta cheia");
        }  
    }

public boolean removefinal(){
//  devemos sempre devemos verificar se a lista está vazia através do método .
        if(!vazia())
       {
        	tamanho--; 
        	String aux = dados[tamanho];
            System.out.println(" Elemento removido: " + aux);
            dados[tamanho] = null;
            return true;
        }
        else
        {
            System.out.print("Erro na Lista esta vazia");
            return false;
        }  
    }

public void adicionainicio(String  x){
    if(!cheia()){           // método verifica se lista está cheia
       for(int i=tamanho;i>=1;i--)    //laço percorre o vetor
      {     
           dados[i]=dados[i-1];  //  aloca o elemento um índice a frente
       }
       tamanho++;                          // adiciona uma    casa  aumentando o  tamanho  do arranjo.
       dados[0]=x; //inserindo o novo elemento
     }
    else{
           System.out.println("lista cheia não possível  adicionar mais elementos"); 
       
        }
   }

public void removeinicio(){
    if(!vazia()){           // método verifica se lista está cheia
    	
    	String aux = dados[0];
        System.out.println(" Elemento removido: " + aux);
      
      for(int i=0;i<tamanho;i++)   
      {     
           dados[i]=dados[i+1];  
       }
       tamanho--;                          
       
     }
    else{
           System.out.println("lista vazia não possível  adicionar mais elementos"); 
       
        }
   }


public void adicionaselect (String x,  int y){  
	//”x” é referente ao elemento e” y “a posição a ser inserida
    if(cheia())  //verifica se a lista  cheia.
   {
    System.out.println("Erro a lista está vazia");
 }
 else
      {
       if(y==0)   // verifica se a posição encontra se  no inicio do da lista
           {
           adicionainicio(x);  // método adiciona  no inicio será utilizado.
          }
          else
            {
           if(y>tamanho) //caso seja maior que tamanho está for a da lista.
             {
              System.out.println("Erro posição inválida");
             }
              else
               {
                 for(int i=tamanho; i>=y;i--) // estrutura de laço decrementa até o até a posição a ser inserida.
               {
               dados[i]=dados[i-1];
              }
              dados[y]=x; // inserção de elemento no arranjo
              tamanho++; // adição de uma casa no arranjo
           }
        }
       }
    }



public void removeselect (int y){  
	
    if(vazia())  
   {
    System.out.println("Erro a lista está vazia");
 }
 else
      {
       if(y==0)   // verifica se a posição encontra se  no inicio do da lista
           {
           removeinicio();
          }
          else
            {
           if(y>tamanho) //caso seja maior que tamanho está for a da lista.
             {
              System.out.println("Erro posição inválida");
             }
              else
               {
            	  System.out.println("Elemento removido: " + dados[y]); 
                 for(int i=y; i< tamanho;i++) // estrutura de laço decrementa até o até a posição a ser removida.
               {
               dados[i]=dados[i+1];
              }
              
              tamanho--; 
           }
        }
       }
}
}
