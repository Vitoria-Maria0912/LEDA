package adt.queue;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	private int elements;

	@SuppressWarnings("unchecked")
	public CircularQueue(int size) {
		array = (T[]) new Object[size];
		head = -1;
		tail = -1;
		elements = 0;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		
		if(isFull()) {
			throw new QueueOverflowException();
			
		} else {
			this.array[tail] = element;
			this.tail = (this.tail + 1) % (this.array.length);
			this.elements++;
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		
		if(isFull()) {
			throw new QueueUnderflowException();
			
		} else {
			
			T peek = this.array[this.head];
			
			if (this.head == this.tail) {
				this.head = -1;
				this.tail = -1;
				
			} else {
				this.head = (this.head + 1) % (this.array.length);
			}
			
			this.elements--;
			
			return peek;
		}
	}

	@Override
	public T head() {
		if(!(isEmpty())) {
			return this.array[head];
		
		} else {
			return null;
		}
	}

	@Override
	public boolean isEmpty() {
		return this.elements == 0;
	}

	@Override
	public boolean isFull() {
		return this.elements == this.array.length;
	}
}
