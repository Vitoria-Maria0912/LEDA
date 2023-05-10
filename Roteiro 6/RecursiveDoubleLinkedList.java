package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {
	}

	@Override
	public void insert(T element) {
	}

	@Override
	public void insertFirst(T element) {
	}

	@Override
	public void remove(T element) {
	}

	@Override
	public void removeFirst() {
		
	}

	@Override
	public void removeLast() {
		
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return this.previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}
}
