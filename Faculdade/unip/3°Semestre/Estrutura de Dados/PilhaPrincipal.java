
public class Principal {
	
	public static void main (String args[])
	{
		PilhaEstatica p1 = new PilhaEstatica("Pilha1", 3);
		PilhaEstatica p2 = new PilhaEstatica("Pilha2", 3);
		
		p1.push(new Elemento("Jose", 4));
		p1.push(new Elemento("Maria", 6));
		p1.push(new Elemento("Sergio", 7));
		
		for (int i=0; i < p1.tamanho(p1); i++)
		{
			p1.pushpop(p1, p2);
		}
		
		
		//p1.pop();
		//p1.pop();
	}
	
	

}
