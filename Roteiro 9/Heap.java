package adt.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import util.Util;

/**
 * O comportamento de qualquer heap é definido pelo heapify. Neste caso o
 * heapify dessa heap deve comparar os elementos e colocar o menor sempre no
 * topo. Ou seja, admitindo um comparador normal (responde corretamente 2 < 3),
 * essa heap deixa os elementos menores no topo. Essa comparação não é feita
 * diretamente com os elementos armazenados, mas sim usando um comparator.
 * Dessa forma, dependendo do comparator, a heap pode funcionar como uma
 * max-heap
 * ou min-heap.
 */
public class HeapImpl<T extends Comparable<T>> implements Heap<T> {

	protected T[] heap;
	protected int index = -1;
	/**
	 * O comparador é utilizado para fazer as comparações da heap. O ideal é
	 * mudar apenas o comparator e mandar reordenar a heap usando esse
	 * comparator. Assim os metodos da heap não precisam saber se vai funcionar
	 * como max-heap ou min-heap.
	 */
	protected Comparator<T> comparator;

	private static final int INITIAL_SIZE = 20;
	private static final int INCREASING_FACTOR = 10;

	/**
	 * Construtor da classe. Note que de inicio a heap funciona como uma
	 * min-heap. OU seja, voce deve considerar que a heap usa o comparator
	 * interno e se o comparator responde compare(x,y) < 0 entao o x eh menor
	 * e sobe na heap.
	 */
	@SuppressWarnings("unchecked")
	public HeapImpl(Comparator<T> comparator) {
		this.heap = (T[]) (new Comparable[INITIAL_SIZE]);
		this.comparator = comparator;
	}

	// /////////////////// METODOS IMPLEMENTADOS
	private int parent(int i) {
		return (i - 1) / 2;
	}

	/**
	 * Deve retornar o indice que representa o filho a esquerda do elemento
	 * indexado pela posicao i no vetor
	 */
	private int left(int i) {
		return (i * 2 + 1);
	}

	/**
	 * Deve retornar o indice que representa o filho a direita do elemento
	 * indexado pela posicao i no vetor
	 */
	private int right(int i) {
		return (i * 2 + 1) + 1;
	}

	@Override
	public boolean isEmpty() {
		return (index == -1);
	}

	@Override
	public T[] toArray() {
		ArrayList<T> resp = new ArrayList<T>();
		for (int i = 0; i <= this.index; i++) {
			resp.add(this.heap[i]);
		}
		return (T[]) resp.toArray(new Comparable[0]);
	}

	// ///////////// METODOS A IMPLEMENTAR
	/**
	 * Valida o invariante de uma heap a partir de determinada posicao, que pode
	 * ser a raiz da heap ou de uma sub-heap. O heapify deve usar o comparator
	 * para subir os elementos na heap.
	 */
	private void heapify(int position) {
		
		if(position >= 0 && position < size()) {
			
			int left = left(position);
			int right = right(position);
			
			int largestOrSmallest = position;
			
			if(left <= this.index && comparator.compare(getHeap()[left], getHeap()[position]) > 0) {
				largestOrSmallest = left;
			}
			
			if(right <= this.index && comparator.compare(getHeap()[right], getHeap()[largestOrSmallest]) > 0) {
				largestOrSmallest = right;
			}
			
			if(largestOrSmallest != position) {
				
				Util.swap(getHeap(), position, largestOrSmallest);
				
				heapify(largestOrSmallest);
			}
		}
	}

	@Override
	public void insert(T element) {
		// ESSE CODIGO E PARA A HEAP CRESCER SE FOR PRECISO. NAO MODIFIQUE
		if (index == heap.length - 1) {
			heap = Arrays.copyOf(heap, heap.length + INCREASING_FACTOR);
		}
		// /////////////////////////////////////////////////////////////////
		insert(this.heap, element);
	}

	private void insert(T[] array, T element) {
		
		if(element != null) {
			
			int indice = ++this.index;
			
			while(indice > 0 && comparator.compare(array[parent(indice)], element) < 0) {
				
				array[indice] = array[parent(indice)];
				indice = parent(indice);
			}
			
			array[indice] = element;
		}
	}

	@Override
	public void buildHeap(T[] array) {
		
		if(array != null) {
			
			this.heap = array;
			this.index = array.length - 1;
			
			for(int indice = this.index / 2; indice >= 0; indice--) {
				heapify(indice);
			}
		}
	}

	@Override
	public T extractRootElement() {
		
		T rootElement = rootElement();
		
		if(!(this.isEmpty())) {
			
			this.heap[0] = this.heap[this.index--];
			heapify(0);
		}
		return rootElement;
	}

	@Override
	public T rootElement() {
		
		T rootElement = null;

		if(!(this.isEmpty())) {
			rootElement = this.heap[0];

		}
		return rootElement;
	}

	@Override
	public T[] heapsort(T[] array) {
		
		if(array != null && array.length > 1) {
			
			buildHeap(array);
			
			for(int indice = this.index; indice >= 0; indice--) {
				
				Util.swap(array, 0, indice);
				
				this.index--;
				this.heapify(0);
			}
			
			if(this.heap[0].compareTo(this.heap[1]) > 0) {
				
				int indice2inverso = array.length - 1;
				
				for(int indice2 = 0; indice2 < indice2inverso; indice2++) {
					Util.swap(array, indice2, indice2inverso--);
				}
			}
		}
		return array;
	}

	@Override
	public int size() {
		return this.index + 1;
	}

	public Comparator<T> getComparator() {
		return comparator;
	}

	public void setComparator(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	public T[] getHeap() {
		return heap;
	}
}
