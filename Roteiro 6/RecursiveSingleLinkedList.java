package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}

	@Override
	public boolean isEmpty() {
		return this.getData() == null;
	}

	@Override
	public int size() {
		
		int size = 0;
		
		if(!(isEmpty())) {
			size = 1 + this.next.size();
		}
		return size;
	}

	@Override
	public T search(T element) {
		
		T search = null;
		
		if(!(isEmpty()) && element != null) {
			
			if(!(getData().equals(element))){
				search = getData();
				
			} else {
				search = this.next.search(element);
			}
		}
		return search;
	}

	@Override
	public void insert(T element) {
		if(element != null) {
			if(isEmpty()) {
				setData(element);
				this.next = new RecursiveSingleLinkedListImpl<>();
				
			} else {
				this.next.insert(element);
			}
		}
	}

	@Override
	public void remove(T element) {
		if(!(isEmpty()) && element != null) {
			
			if(getData().equals(element)) {
				setData(this.next.getData());
				setNext(this.next.getNext());
			
			} else {
				this.next.remove(element);
			}
		}
	}

	@Override
	public T[] toArray() {
		
		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Comparable[size()];
		
		toArrayRecursivo(array, 0);
		
		return array;
	}
	
	private void toArrayRecursivo(T[] array, int i) {
		if(!(this.isEmpty())) {
			array[i] = getData();
			this.next.toArrayRecursivo(array, i + 1);
		}
	}

	public T getData() {
		return this.data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return this.next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
