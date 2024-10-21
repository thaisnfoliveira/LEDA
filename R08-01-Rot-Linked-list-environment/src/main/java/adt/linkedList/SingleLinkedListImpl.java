package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		//Gosto da ideia de usar o getAtributo e o this!
		return this.getHead().isNIL();
	}

	@Override
	public int size() {
		//inicializamos o contador como zero
		int resp = 0;

		//criamos um nó auxiliar para percorrer a lista de forma iterativa - começamos pela cabeça da lista
		SingleLinkedListNode<T> auxNode = this.getHead();

		//Não estamos procurando elemento nenhum, então o nosso critério de parada é apenas o fim da lista
		//A cada iteração, aumentamos em 1 o contador do tamanho da lista
		while(!auxNode.isNIL()){
			auxNode = auxNode.getNext();
			resp += 1;
		}

		return resp;

	}

	@Override
	//Porque o search retorna o próprio elemento que estamos procuranodo? Deverua retornar a "posição" que esse elemento está na lista...
	public T search(T element) {
		T resp = null;

		if(!this.isEmpty() && element != null){
			//Criamos um "current" auxiliar para que não modifiquemos diretamente o valor da "cabeça" da LinkedList
			SingleLinkedListNode<T> auxNode = this.getHead();
			
			//Enquanto o conteúdo do nó auxiliar é diferente do elemento que queremos encontrar E ele não é nulo (se ele for nulo, significa que a lista acabou) mudamos o valor do auxiliar para o next dele mesmo
			while(!auxNode.isNIL() && !auxNode.data.equals(element)){
				auxNode = auxNode.next;
			}

			resp = auxNode.getData();
		}

		//realmente, se a linked list só tiver o head, ele já é encontrado!
		return resp;
	}

	@Override
	public void insert(T element) {
		if(element != null){
			//ao invés de verificar se o head é nil, temos um métodos que faz isso!
			if(this.isEmpty()){
				//criamos um novo nó que vai ser a cabeça da nossa linked list
				SingleLinkedListNode<T> newHead = new SingleLinkedListNode<T>(element, this.getHead());
				newHead.setNext(this.getHead());
				this.setHead(newHead);
			}else{
				//Criamos um nó auxiliar para "percorrer" a lista até encontrar o fim - e aí inserir no final, já que esse método não recebe parametro de posição
				SingleLinkedListNode<T> auxNode = this.getHead();
				while(!auxNode.isNIL()){
					auxNode = auxNode.getNext();
				}
				//Quando o nosso nó auxiliar é igual ao NIL do fim da lista, adicionamos nele o nosso elemento e criamos um novo nó vazio(NIL) para ser o next deste que criamos
				auxNode.data = element;
				auxNode.next = new SingleLinkedListNode<>();
			}
		}
	}

	@Override
	public void remove(T element) {
		if(!this.isEmpty() && element != null){
			//Temos dois casos possíveis aqui:
			//1: o elemento é a cabeça da Linked List, estando na primeira posição
			if(this.getHead().getData().equals(element)){
				//se esse for o caso, apenas mudamos a cabeça da lista para ser o next da cabeça anterior
				this.setHead(getHead().getNext());
			}

			else{
				//criamos um nó auxiliar
				SingleLinkedListNode<T> auxNode = this.getHead();

				//aqui fazemos um search para procurar o elemento

				while(!auxNode.isNIL() && !auxNode.getData().equals(element)){
					auxNode = auxNode.getNext();
				}

				//2: o elemento está entre o head e a última posição do array
				if(!auxNode.isNIL()){
					auxNode.setData(auxNode.getNext().getData());
					auxNode.setNext(auxNode.getNext().getNext());
				}

			}
		}
	}

	@Override
	public T[] toArray() {
		//a ideia aqui é criar um array - inicialmente vazio mas do tamanho da linked list para alocarmos cada um dos "Datas" dos nós da lista encadeada
		T[] array = (T[]) new Comparable[this.size()];

		//começamos com o valor do índice e com o costumeiro nó auxiliar
		int i = 0;
		SingleLinkedListNode<T> auxNode = this.getHead();

		while(!auxNode.isNIL()){
			array[i] = auxNode.getData();
			i ++;
			auxNode = auxNode.getNext();
		}

		return array;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
