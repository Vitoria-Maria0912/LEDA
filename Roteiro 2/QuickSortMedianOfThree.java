package sorting.divideAndConquer.quicksort3;

import sorting.AbstractSorting;
import util.Util;

/**
 * A classe QuickSortMedianOfThree representa uma variação do QuickSort que
 * funciona de forma ligeiramente diferente. Relembre que quando o pivô
 * escolhido divide o array aproximadamente na metade, o QuickSort tem um
 * desempenho perto do ótimo. Para aproximar a entrada do caso ótimo, diversas
 * abordagens podem ser utilizadas. Uma delas é usar a mediana de 3 para achar o
 * pivô. Essa técnica consiste no seguinte:
 * 1. Comparar o elemento mais a esquerda, o central e o mais a direita do intervalo.
 * 2. Ordenar os elementos, tal que: A[left] < A[center] < A[right].
 * 3. Adotar o A[center] como pivô.
 * 4. Colocar o pivô na penúltima posição A[right-1].
 * 5. Aplicar o particionamento considerando o vetor menor, de A[left+1] até A[right-1].
 * 6. Aplicar o algoritmo na particao a esquerda e na particao a direita do pivô.
 */
public class QuickSortMedianOfThree<T extends Comparable<T>> extends AbstractSorting<T> {

	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		if(leftIndex < 0 || rightIndex <= leftIndex || rightIndex >= array.length || array.length == 1) {
			
		} else {
			
			int pivot = partition(array, leftIndex, rightIndex);
			
			sort(array, leftIndex, pivot - 1);
			sort(array, pivot + 1, rightIndex);
		}
	}

	private int partition(T[] array, int leftIndex, int rightIndex) {
		
		int indexPivot = pivotMedianOfThree(array, leftIndex, rightIndex);
		int auxiliar = rightIndex - 1;
		
		Util.swap(array, indexPivot, rightIndex - 1);
		
		T pivot = array[rightIndex - 1];
		
		for(int index = auxiliar - 1; index >= leftIndex + 1; index--) {
			if(array[index].compareTo(pivot) >= 0) {
				auxiliar--;
                Util.swap(array, auxiliar, index);
            }
		}
		
		Util.swap(array, auxiliar, rightIndex - 1);
		
		return auxiliar;
		
	}

	private int pivotMedianOfThree(T[] array, int first, int last) {
		
		int center = (first + last) / 2;

		if (array[last].compareTo(array[first]) <= 0) {
			Util.swap(array, last, first);
		}
		if (array[center].compareTo(array[first]) <= 0) {
			Util.swap(array, center, first);
		}
		if (array[last].compareTo(array[center]) <= 0) {
			Util.swap(array, last, center);
		}
		return center;
	}
}
