package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {

	}

	@Override
	public void insertFirst(T element) {
		if(element != null) {
			
			if(isEmpty()) {
				insert(element);
				
			} else {
				
				RecursiveDoubleLinkedListImpl<T> node = new RecursiveDoubleLinkedListImpl<>();
						
				node.setData(getData());
				node.setNext(getNext());
				node.setPrevious(this);
				
				setData(element);
				setNext(node);
				((RecursiveDoubleLinkedListImpl<T>) getNext()).setPrevious(node);
			}

		}
	}

	@Override
	public void removeFirst() {
		if(!(isEmpty())) {
			
			if(getNext().isEmpty() && getPrevious().isEmpty()) {
				setData(null);

			} else {
				setData(getNext().getData());
				setNext(getNext().getNext());
				
				((RecursiveDoubleLinkedListImpl<T>) getNext()).setPrevious(this);
			}
		}
	}

	@Override
	public void removeLast() {
		if(!(isEmpty())) {
			if(getNext().isEmpty()) {
				setData(null);
			
			} else {
				((RecursiveDoubleLinkedListImpl<T>) getNext()).removeLast();
			}
		}
	}
	
	@Override
	public void insert(T element) {
		
		if(element != null) {
			
			if(isEmpty()) {
				setData(element);
				setNext(new RecursiveDoubleLinkedListImpl<T>());
				
				if (this.previous == null) {
					setPrevious(new RecursiveDoubleLinkedListImpl<T>());
				}
			} else {
				getNext().insert(element);			
			}
		}
	}
	
	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return this.previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}
}
