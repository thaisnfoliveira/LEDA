package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	public DoubleLinkedListImpl() {
		this.head = new DoubleLinkedListNode<T>();
		this.last = (DoubleLinkedListNode<T>) head;
	}

	@Override
	public void insertFirst(T element) {
		if (element != null){
			DoubleLinkedListNode<T> newHead = new DoubleLinkedListNode<T>(element, (DoubleLinkedListNode<T>) this.getHead(), new DoubleLinkedListNode<>());
			
			newHead.setPrevious(new DoubleLinkedListNode<>());
			((DoubleLinkedListNode<T>)head).setPrevious(newHead);

			if (this.getHead().isNIL()){
				this.setLast(newHead);
			}
			this.setHead(newHead);
			}
	}

	@Override
	public void removeFirst() {
		//se a lista não estiver vazia
		if(!this.isEmpty()){
			//remova a cabeça da lista
			this.setHead(this.getHead().getNext());
			//se após essa remoção a lista ficar vazia
			if(this.isEmpty()){
				//o último elemento da lista também vai ser a nova cabeça
				this.setLast((DoubleLinkedListNode<T>) this.getHead());
			} else{
				//se estiver vazia, o elemento anterior da cabeça é um nó sentinela
				((DoubleLinkedListNode<T>) this.getHead()).setPrevious(new DoubleLinkedListNode<>());
			}
		}
	}

	@Override
	public void removeLast() {
		//se a árvore não estiver vazia
		if(!this.last.isNIL()){
			//o último elemento da lista é trocado pelo penúltimo
			this.setLast(this.last.getPrevious());
			//se após essa remoção o último elemento é nulo, significa que a cabeça é igual ao último elemento
			if(this.last.isNIL()){
				this.setHead(this.getLast());
			//se não
			} else{
				//o próximo nó do último elemento é um nó sentinela
				this.last.setNext(new DoubleLinkedListNode<>());
			}
		}

	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
