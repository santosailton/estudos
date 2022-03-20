import javax.swing.*;

public class ListaEncadeada {

	    private No primeiro,ultimo;
	    private int totalNos;

	    public ListaEncadeada(){
	        primeiro = ultimo = null;
	        totalNos = 0;
	    }

	    public int getTotalNos(){
	        return totalNos;
	    }

	    public boolean checkIfListaVazia(){
	        if (getTotalNos() == 0){
	            return true;
	       }
	       return false;
	    }

	    public void inserirNoInicio(int  nodo) {
	    	No n = new No(nodo);
	    	
	    	if ( checkIfListaVazia() ){
	            primeiro = ultimo = n;
	        }
	        else{
	            n.setProx(primeiro);
	            primeiro = n;
	        }
	        totalNos++;
	    }

	    public void inserirNoFim(int nodo){
	        // caso n‹o existam n—s inseridos,
	        // insere o primeiro n— (n) na lista
	    	No n = new No(nodo);
	    	
	        if ( checkIfListaVazia() ){
	            primeiro = ultimo = n;
	        }
	        else{
	            ultimo.setProx(n);
	            ultimo = n;
	       }
	       totalNos++;
	    }

	    public void excluirNo(int valor){
	        No noAtual;
	        No noAnterior;
	        
	        noAtual = noAnterior = primeiro;
	        int contador = 1;

	        if (checkIfListaVazia() == false){
	            while (contador <= getTotalNos() &&
	                     noAtual.getValor() != valor){
	                noAnterior = noAtual;
	                noAtual = noAtual.getProx();
	                contador++;
	            } 

	        if(noAtual.getValor() == valor){
	            if ( getTotalNos() == 1){
	                primeiro = ultimo = null;
	           }
	           else{
	               if (noAtual == primeiro){
	                   primeiro = noAtual.getProx();
	               }
	               else{
	                   noAnterior.setProx(noAtual.getProx());
	               }
	           }
	           totalNos--;
	        }
	    }
	}

	    public void inserirSelect(int valor, int pos){
	        No noAtual;
	        No noAnterior;
	        No n = new No(valor);
	        noAtual = noAnterior = primeiro;
	        int contador = 1;
	        
	        if (pos==1) inserirNoInicio(valor);
	        else if ( pos > getTotalNos()) inserirNoFim(valor);
	        else {
	        if (checkIfListaVazia() == false){
	            while (contador < pos){
	                noAnterior = noAtual;
	                noAtual = noAtual.getProx();
	                contador++;
	            } 
	        	   n.setProx(noAnterior.getProx());
	        	   noAnterior.setProx(n);
	           }
	           totalNos++;
	        }
	        }
	    
	
	    
	public void exibirLista(){
	    No temp = primeiro;
	    String valores = "";
	    int contador = 1;
	    if ( checkIfListaVazia() == false ){
	        while (contador <= getTotalNos()){
	            valores += Integer.toString(temp.getValor())+"-";
	            temp = temp.getProx();
	            contador++;
	        }
	    }
	    JOptionPane.showMessageDialog(null, valores);
	 }
	}