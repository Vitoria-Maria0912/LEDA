package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class StackDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedList<T> top;
	protected int size;

	public StackDoubleLinkedListImpl(int size) {
		this.size = size;
		this.top = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if(isFull()) {
			throw new StackOverflowException();

		} else {
			if(element != null) {
				this.top.insert(element);
			}
		}
	}

	@Override
	public T pop() throws StackUnderflowException {
		
		if(isEmpty()) {
			throw new StackUnderflowException();
			
		} else {
			T topo = ((DoubleLinkedListImpl<T>) this.top).getLast().getData();
			this.top.removeLast();
			return topo;
		}
	}

	@Override
	public T top() {
		return ((DoubleLinkedListImpl<T>) this.top).getLast().getData();
	}

	@Override
	public boolean isEmpty() {
		return this.top.isEmpty();
	}

	@Override
	public boolean isFull() {
		return this.size == this.top.size();
	}
}
