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
		
		if(element != null) {
			
			DoubleLinkedListNode<T> node = new DoubleLinkedListNode<>();
			
			node.setData(element);
			node.setNext(getHead());
			node.setPrevious(new DoubleLinkedListNode<>());
			
			((DoubleLinkedListNode<T>) getHead()).setPrevious(node);

			if(getHead().isNIL()) {
				setLast(node);
			}
			setHead(node);
		}
	}

	@Override
	public void removeFirst() {
		if(!(isEmpty())) {
			
			setHead(getHead().getNext());
			
			if(isEmpty()) {
				setLast((DoubleLinkedListNode<T>) getHead());
			}
			((DoubleLinkedListNode<T>) getHead()).setPrevious(new DoubleLinkedListNode<>());
		}
	}

	@Override
	public void removeLast() {
		if(!(isEmpty())) {
			
			if(getLast().isNIL()) {
				setHead(getLast());
				
			} else {
				setLast(getLast().getPrevious());
			}
			getLast().setNext(new DoubleLinkedListNode<>());
		}
	}
	
	@Override
	public T search(T element) {
		
		T search = null;
		
		DoubleLinkedListNode<T> auxHead = (DoubleLinkedListNode<T>) getHead();
		DoubleLinkedListNode<T> auxLast = (DoubleLinkedListNode<T>) getLast();
		
		if(!(isEmpty()) && element != null) {
			
			while(!(auxHead.getData().equals(element)) && !(auxHead.equals(auxLast)) && !(auxHead.getNext().equals(auxLast))
						&& !(auxHead.getData().equals(element)) && !(auxLast.getData().equals(element))) {
				auxHead = (DoubleLinkedListNode<T>) auxHead.getNext();
				auxLast = auxLast.getPrevious();
			}
			if (auxHead.getData().equals(element)) {
				search = auxHead.getData();
			}

			if (auxLast.getData().equals(element)) {
				search = auxLast.getData();
			}
		}
		return search;
	}

	@Override
	public void insert(T element) {
		
		if(element != null) {
			
			DoubleLinkedListNode<T> newLast = new DoubleLinkedListNode<>();
			
			newLast.setData(element);
			newLast.setPrevious(getLast());
			newLast.setNext(new DoubleLinkedListNode<>());

			getLast().setNext(newLast);

			if(getLast().isNIL()) {
				setHead(newLast);
			}
			setLast(newLast);		}
	}

	@Override
	public void remove(T element) {
		
		if(!(isEmpty()) && element != null) {
			
			DoubleLinkedListNode<T> aux = (DoubleLinkedListNode<T>) getHead();
			
			if(getHead().getData().equals(element)) {
				removeFirst();
				
			} else if(getLast().getData().equals(element)){
				removeLast();
			
			} else {
				
				while(!(aux.isNIL()) && !(aux.getData().equals(element))) {
					aux = (DoubleLinkedListNode<T>) aux.getNext();
				}
				if(!(aux.isNIL())) {
					aux.getPrevious().setNext(aux.getNext());
					((DoubleLinkedListNode<T>) aux.getNext()).setPrevious(aux.getPrevious());
				}
			}
		}
	}

	public DoubleLinkedListNode<T> getLast() {
		return this.last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}
}
