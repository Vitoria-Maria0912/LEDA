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
        
        while(!(aux.isNIL())){
            size++;
            aux = aux.getNext();
        }
	return size;
	}

	@Override
	public T search(T element) {
        
		T search = null;
        
        if(isEmpty || element == null) {
       
        } else {
            SingleLinkedListNode<T> aux = getHead();
        
            while(!(aux.isNIL()) && !(aux.getData().equals(element))) {
                aux = aux.getNext();
            }
            search = aux.getData();
        }
		return search;
	}

	@Override
	public void insert(T element) {
        if(element != null) {
			
			SingleLinkedListNode<T> aux = getHead();
			SingleLinkedListNode<T> newAux = new SingleLinkedListNode<>(element, this.getHead());
			
            if(isEmpty) {
				setHead(newAux);
				
            } else {
                while(!(aux.isNIL())) {
                    aux = aux.getNext();
                }
				aux.data = element;
				aux.next = new SingleLinkedListNode<>();
            }    
	}

	@Override
	public void remove(T element) {
		if(!(isEmpty()) && element != null) {
			
			SingleLinkedListNode<T> aux = getHead();
			
			if(getHead().getData.equals(element)) {
				setHead(getHead().getNext());
			} else {
				while(!(aux.isNIL()) && !(aux.getData().equals(element))) {
					aux = aux.getNext();
				}
				if(!(aux.getData().isNIL()) {
					setData(aux.getNext().getData());
					setNext(aux.getNext().getNext());
					aux.getData() = 
				}
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] array = (T[]) new Comparable[size()];
		
		SingleLinkedListNode<T> aux = getHead();
		
		int index = 0;
		
		while(!(aux.isNIL()) {
			array[index] = aux.getData();
			index++;
			aux = aux.getNext();
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
