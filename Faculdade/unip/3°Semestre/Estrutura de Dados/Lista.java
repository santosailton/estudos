public class Lista {
	
	private String dados[];
    private int tamanho;   

    // construtor  ir� requer o tamanho do arranjo neste caso 10 posi��es  e a vari�vel tamanho onde */inicializar� o arranjo
public Lista(){
        dados=new String [10];
        tamanho=0;
    }

//m�todo de auxilio utilizado para verificar caso a lista esteja vazia ,caso tamanho seja igual a zero a  lista est� vazia
public boolean vazia (){
        return tamanho==0;
 }

//m�todo de aux�lio utilizado para verificar caso a lista esteja cheia ,caso tamanho seja igual a 10 a lista est� cheia.
public boolean cheia (){
    return tamanho ==dados.length;
}

public int tamanho() {
	return tamanho;
}

//Este m�todo ser� utilizado pelo usu�rio verificar o conte�do do arranjo.
public void percorrer(){
        for(int i=0;i < tamanho(); i++)
        {
            System.out.print(" "+dados[i]+" ,");   
        }
        System.out.println(" ");
    }

//par�metro �x� ser� referente ao  dado a ser inserido na lista.
public void adicionafinal (String x){
//  devemos sempre devemos verificar se a lista est� cheia atrav�s do m�todo .
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
//  devemos sempre devemos verificar se a lista est� vazia atrav�s do m�todo .
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
    if(!cheia()){           // m�todo verifica se lista est� cheia
       for(int i=tamanho;i>=1;i--)    //la�o percorre o vetor
      {     
           dados[i]=dados[i-1];  //  aloca o elemento um �ndice a frente
       }
       tamanho++;                          // adiciona uma    casa  aumentando o  tamanho  do arranjo.
       dados[0]=x; //inserindo o novo elemento
     }
    else{
           System.out.println("lista cheia n�o poss�vel  adicionar mais elementos"); 
       
        }
   }

public void removeinicio(){
    if(!vazia()){           // m�todo verifica se lista est� cheia
    	
    	String aux = dados[0];
        System.out.println(" Elemento removido: " + aux);
      
      for(int i=0;i<tamanho;i++)   
      {     
           dados[i]=dados[i+1];  
       }
       tamanho--;                          
       
     }
    else{
           System.out.println("lista vazia n�o poss�vel  adicionar mais elementos"); 
       
        }
   }


public void adicionaselect (String x,  int y){  
	//�x� � referente ao elemento e� y �a posi��o a ser inserida
    if(cheia())  //verifica se a lista  cheia.
   {
    System.out.println("Erro a lista est� vazia");
 }
 else
      {
       if(y==0)   // verifica se a posi��o encontra se  no inicio do da lista
           {
           adicionainicio(x);  // m�todo adiciona  no inicio ser� utilizado.
          }
          else
            {
           if(y>tamanho) //caso seja maior que tamanho est� for a da lista.
             {
              System.out.println("Erro posi��o inv�lida");
             }
              else
               {
                 for(int i=tamanho; i>=y;i--) // estrutura de la�o decrementa at� o at� a posi��o a ser inserida.
               {
               dados[i]=dados[i-1];
              }
              dados[y]=x; // inser��o de elemento no arranjo
              tamanho++; // adi��o de uma casa no arranjo
           }
        }
       }
    }



public void removeselect (int y){  
	
    if(vazia())  
   {
    System.out.println("Erro a lista est� vazia");
 }
 else
      {
       if(y==0)   // verifica se a posi��o encontra se  no inicio do da lista
           {
           removeinicio();
          }
          else
            {
           if(y>tamanho) //caso seja maior que tamanho est� for a da lista.
             {
              System.out.println("Erro posi��o inv�lida");
             }
              else
               {
            	  System.out.println("Elemento removido: " + dados[y]); 
                 for(int i=y; i< tamanho;i++) // estrutura de la�o decrementa at� o at� a posi��o a ser removida.
               {
               dados[i]=dados[i+1];
              }
              
              tamanho--; 
           }
        }
       }
}
}
