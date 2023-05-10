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
			
			setData(element);
			setNext(getHead());
			setPrevious(new DoubleLinkedListNode<T>());

			// daqui para baixo não entendi nada
			((DoubleLinkedListNode<T>) this.getHead()).setPrevious(node);
			
			if(getHead().isNIL()) {
				this.setLast(node);
			}
			this.setHead(node);
		}
	}

	@Override
	public void removeFirst() {
		if(!(this.isEmpty())) {
		}
	}

	@Override
	public void removeLast() {
		if(!(this.isEmpty())) {
		}
	}

	@Override
	public void insert(T element) {
		if(element != null) {
		}
	}

	@Override
	public void remove(T element) {
		if(!(this.isEmpty() && element != null) {
		}
	}

	@Override
	public T search(T element) {
		
		T found = null;
		
		if(!(this.isEmpty() && element != null) {
			
			DoubleLinkedListNode<T> auxHead = (DoubleLinkedListNode<T>) this.getHead();
			DoubleLinkedListNode<T> auxLast = this.getLast();
			
			while(!(auxHead.equals(auxLast)) && !(auxHead.getData().equals(element)) && !(auxLast.getData().equals(element))) {
				auxHead = auxHead.getNext(); // tem que fazer o cast?
				auxLast = auxLast.getPrevious();
			}
			if(auxHead.getData().equals(element)) {
				found = auxHead.getData();
				
			} else if(auxLast.getData().equals(element)) { // acho que tem o "else", porque se um ocorrer o outro não precisa ser checado
				found = auxLast.getData();
			}
		}
		return found;
	}

	public DoubleLinkedListNode<T> getLast() {
		return this.last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}
}
