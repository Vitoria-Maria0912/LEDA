package sorting.divideAndConquer;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		if(leftIndex < 0 || rightIndex <= leftIndex || rightIndex >= array.length || array.length == 1) {
		}
		
		else {
			int middle = (leftIndex + rightIndex) / 2;
			
			sort(array, leftIndex, middle);
			sort(array, middle + 1, rightIndex);
			
			mergeSort(array, leftIndex, middle, rightIndex);
		}
	}
	
	private void mergeSort(T[] array, int leftIndex, int middle, int rightIndex) {
		
		T[] listaOrdenada = (T[]) new Comparable[array.length];
		
		for(int copia = leftIndex; copia <= rightIndex; copia++) {
			listaOrdenada[copia] = array[copia];
		}
		
		int indiceDoMenor = leftIndex;
		
		int particao = middle + 1;
		int indexArrayInicial = leftIndex;
		
		while (indiceDoMenor <= middle && particao <= rightIndex) {
			
			if(listaOrdenada[indiceDoMenor].compareTo(listaOrdenada[particao]) < 0) {
				array[indexArrayInicial] = listaOrdenada[indiceDoMenor];
				
				indiceDoMenor++;
				
			} else {
				array[indexArrayInicial] = listaOrdenada[particao];
				
				particao++;
			}
			indexArrayInicial++;
		}
		
		while(indiceDoMenor <= middle) {
			array[indexArrayInicial] = listaOrdenada[indiceDoMenor];
			
			indiceDoMenor++;
			indexArrayInicial++;
		}
		
		while(particao <= rightIndex) {
			array[indexArrayInicial] = listaOrdenada[particao];
			
			particao++;
			indexArrayInicial++;
		}
	}
}
