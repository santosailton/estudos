import javax.swing.*;

public class ListaEncadeada {

	    No primeiro,ultimo;
	    int totalNos;

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
	            n.prox = primeiro;
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
	            ultimo.prox = n;
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
	                     noAtual.valor != valor){
	                noAnterior = noAtual;
	                noAtual = noAtual.prox;
	                contador++;
	            } 

	        if(noAtual.valor == valor){
	            if ( getTotalNos() == 1){
	                primeiro = ultimo = null;
	           }
	           else{
	               if (noAtual == primeiro){
	                   primeiro = noAtual.prox;
	               }
	               else{
	                   noAnterior.prox = noAtual.prox;
	               }
	           }
	           totalNos--;
	        }
	    }
	}

	public void exibirLista(){
	    No temp = primeiro;
	    String valores = "";
	    int contador = 1;
	    if ( checkIfListaVazia() == false ){
	        while (contador <= getTotalNos()){
	            valores += Integer.toString(temp.valor)+"-";
	            temp = temp.prox;
	            contador++;
	        }
	    }
	    JOptionPane.showMessageDialog(null, valores);
	 }
	}