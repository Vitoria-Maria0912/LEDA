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
            if(!(aux.isNIL)) { // no de Catarina não tem esse if, precisa?
                search = aux.getData();
            }
        }
       
		return search;
	}

	@Override
	public void insert(T element) {
        if(element != null){
            if(isEmpty) {
//              SingleLinkedListNode<T> newAux = new SingleLinkedListNode<>(element, this.getHead());
// 				this.setHead(newAux);   ---> não basta só o setHead não?
                setHead(element);
            } else {
                while(!(aux.isNIL)) {
                    aux = aux.getNext();
                }    
            }    
	}

	@Override
	public void remove(T element) {
	}

	@Override
	public T[] toArray() {
		T[] array = (T[]) new Comparable[this.size()];
		return array;
	}

	public SingleLinkedListNode<T> getHead() {
		return this.head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
