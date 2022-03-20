
public class Elemento {
	private String nome;
	private int codigo;
	
	public Elemento(String _nome, int _codigo) {
		nome = _nome;
		codigo = _codigo;
	}
	
	public String toString()
	{
		return codigo + "-" + nome;
	}

}
