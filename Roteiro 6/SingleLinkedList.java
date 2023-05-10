package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return getHead().isNIL();
	}

	@Override
	public int size() {
		
		int size = 0;
		
		SingleLinkedListNode<T> aux = getHead();
		
		while(!(aux.isNIL())) {
			aux = aux.getNext();
			size++;
		}
		return size;
	}

	@Override
	public T search(T element) {
		
		SingleLinkedListNode<T> aux = getHead();
		
		if(!(isEmpty()) && element != null) {
			
			while(!(aux.isNIL()) && !(aux.getData().equals(element))) {
				aux = aux.getNext();
			}
		}
		return aux.getData();
	}

	@Override
	public void insert(T element) {
		
		if(element != null) {
			
			SingleLinkedListNode<T> aux = getHead();
			SingleLinkedListNode<T> newAux = new SingleLinkedListNode<T> (element, getHead());
			
			if(isEmpty()) {
				setHead(newAux);
				
			} else {
				while(!(aux.isNIL())) {
					aux = aux.getNext();
				}
				aux.setData(element);;
				aux.setNext(new SingleLinkedListNode<>());
			}
		}
	}

	@Override
	public void remove(T element) {
		
		if(!(isEmpty()) && element != null) {
			
			SingleLinkedListNode<T> aux = getHead();
			
			if(getHead().getData().equals(element)) {
				
				setHead(getHead().getNext());
							
			} else {
				
				while(!(aux.isNIL()) && !(aux.getData().equals(element))) {
					aux = aux.getNext();
				}
				if(!(aux.isNIL())) {
					aux.setData(aux.getNext().getData());
					aux.setNext(aux.getNext().getNext());
				}
			}
		}
	}

	@Override
	public T[] toArray() {
		
		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Comparable[size()];
		
		SingleLinkedListNode<T> aux = getHead();
		
		int index = 0;
		
		while(!(aux.isNIL())) {
			array[index] = aux.getData();
			aux = aux.getNext();
			index++;
		}
		return array;
	}

	public SingleLinkedListNode<T> getHead() {
		return this.head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}
}
