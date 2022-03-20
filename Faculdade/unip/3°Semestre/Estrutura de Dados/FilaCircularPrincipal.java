
public class Principal {
	public static void main (String args[] )
	{
		Fila F1 = new Fila();
		
		F1.adicionafinal(3);
		F1.adicionafinal(4);
		F1.adicionafinal(5);
		F1.adicionafinal(6);
		F1.adicionafinal(7);
		
		F1.imprimir();
		
		F1.adicionafinal(8);
		F1.removeinicio();
		F1.adicionafinal(9);
		
		F1.imprimir();
		
		F1.removeinicio();
		F1.removeinicio();
		F1.adicionafinal(10);
		F1.adicionafinal(11);
		
		F1.imprimir();
		
		F1.adicionafinal(12);
		F1.removeinicio();
		//F1.adicionafinal(12);
		
		F1.imprimir();
		
		
	}

}
