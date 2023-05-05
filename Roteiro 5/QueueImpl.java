package adt.queue;

public class QueueImpl<T> implements Queue<T> {

	private T[] array;
	private int tail;

	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
		array = (T[]) new Object[size];
		tail = -1;
	}

	@Override
	public T head() {
		if(!(isEmpty())) {
			return this.array[0]; 

		} else {
			return null;
		}
	}

	@Override
	public boolean isEmpty() {
		return this.tail == -1;
	}

	@Override
	public boolean isFull() {
		return this.tail == this.array.length - 1;
	}

	private void shiftLeft() {
		for (int index = 0; index < this.tail; index++) {
			this.array[index] = this.array[index + 1];
		}
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		
		if(isFull()) {
			throw new QueueOverflowException();
			
		} else {
			this.array[++tail] = element;
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if(isEmpty()) {
			throw new QueueUnderflowException();
			
		} else {
			T head = this.array[0];
			shiftLeft();
			return head;
		}
	}
}
