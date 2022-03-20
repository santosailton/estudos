
public class Principal {
	public static void main (String args[] )
	{
		Lista L1 = new Lista();
		
		L1.adicionafinal("Maria");
		L1.adicionafinal("José");
		L1.adicionafinal("Carlos");
		
		L1.percorrer();
		
		L1.adicionainicio("Jessé");
		
		L1.percorrer();
		
		L1.adicionafinal("Fer");
		
		L1.percorrer();
		
		L1.adicionaselect("Adriana", 2);
		
		L1.percorrer();
		
		L1.removefinal();
		L1.percorrer();
		
		L1.removeinicio();
		L1.percorrer();
		
		L1.removeselect(1);
		L1.percorrer();
		
	}

}
