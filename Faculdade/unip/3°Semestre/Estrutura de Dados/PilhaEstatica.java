
public class PilhaEstatica {
	private Elemento elementos[];
	private int topo;
	private int max_elementos;
	private String nome;
	
	public PilhaEstatica(String _nome, int _max)
	{
		nome = _nome;
		max_elementos = _max;
		topo = 0;
		System.out.println("Criando pilha " + nome + "com m‡ximo de " + max_elementos);
		elementos = new Elemento[max_elementos];
	}

	public boolean pilhaCheia()
	{
		if (topo == max_elementos) return true;
		else return false;
	}
	
	public boolean pilhaVazia()
	{
		if (topo == 0 ) return true;
		else return false;
	}
	
	public int tamanho(PilhaEstatica p)
	{
		return p.max_elementos;
	}
	
	public Elemento pop()
	{
		System.out.print(nome + " :Retornando valor da pilha....");
		if (!pilhaVazia())
		{
			topo = topo - 1;
			System.out.println(elementos[topo]);
			return elementos[topo];
			
		}
		else
		{
			System.out.println("Pilha vazia");
		}
		return null;
	}
	
	public boolean push(Elemento _elem)
	{
		System.out.println(nome + " :Empilhando um valor na pilha...");
		if (!pilhaCheia())
		{
			elementos[topo] = _elem;
			topo = topo + 1;
			System.out.println(_elem);
			return true;
			
		}
		else
		{
			System.out.println("Pilha Cheia");
		}
		return false;
	}
	
	public void pushpop(PilhaEstatica p1, PilhaEstatica p2)
	{
		p2.push(p1.pop());
	}
}
