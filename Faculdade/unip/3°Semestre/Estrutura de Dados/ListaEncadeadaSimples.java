
public class ListaEncadeadaSimples {
	
	public static void main(String[] args) {
		 
		ListaEncadeada l = new ListaEncadeada();

		 l.inserirNoFim(2);
		 l.inserirNoFim(12);
		 l.inserirNoInicio(22);
		 l.exibirLista();
		 l.inserirNoFim(32);
		 l.inserirNoFim(2);
		 l.exibirLista();
		 l.excluirNo(12);
		 l.exibirLista();
		 l.excluirNo(32);
		 l.exibirLista();
		 l.excluirNo(2);
		 l.exibirLista();
		 l.inserirSelect(55, 4);
		 l.exibirLista();
		 
		 }

}
