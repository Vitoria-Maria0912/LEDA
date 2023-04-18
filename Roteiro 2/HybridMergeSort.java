package sorting.divideAndConquer.hybridMergesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * A classe HybridMergeSort representa a implementação de uma variação do
 * MergeSort que pode fazer uso do InsertionSort (um algoritmo híbrido) da
 * seguinte forma: o MergeSort é aplicado a entradas maiores a um determinado
 * limite. Caso a entrada tenha tamanho menor ou igual ao limite o algoritmo usa
 * o InsertionSort.
 * 
 * A implementação híbrida deve considerar os seguintes detalhes:
 * - Ter contadores das quantidades de MergeSorts e InsertionSorts aplicados, de forma
 *   que essa informação possa ser capturada pelo teste.
 * - A cada chamado do método de sort(T[] array) esses contadores são resetados. E a cada chamada
 *   interna de um merge ou insertion, os contadores MERGESORT_APPLICATIONS e
 *   INSERTIONSORT_APPLICATIONS são incrementados.
 * - O InsertionSort utilizado no algoritmo híbrido deve ser in-place.
 */
public class HybridMergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	/**
	 * For inputs with size less or equal to this value, the insertionsort
	 * algorithm will be used instead of the mergesort.
	 */
	public static final int SIZE_LIMIT = 4;

	protected static int MERGESORT_APPLICATIONS = 0;
	protected static int INSERTIONSORT_APPLICATIONS = 0;

	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		MERGESORT_APPLICATIONS = 0;
		INSERTIONSORT_APPLICATIONS = 0;
		
		if(leftIndex < 0 || leftIndex >= rightIndex || rightIndex >= array.length) {
			
		} else {
			
			if(array.length <= SIZE_LIMIT) {
				insertionSort(array, leftIndex, rightIndex);
			}
			
			int middle = (leftIndex + rightIndex) / 2;
			
			sort(array, leftIndex, middle);
			sort(array, middle + 1, rightIndex);
			
			mergeSort(array, leftIndex, middle, rightIndex);
		}
	}

	private void insertionSort(T[] array, int leftIndex, int rightIndex) {
		
		int indexExterno = leftIndex + 1;
		
		while(indexExterno <= rightIndex) {
			
			int indexInterno = indexExterno;
			
			while(indexInterno > leftIndex && array[indexInterno].compareTo(array[indexInterno - 1]) < 0) {
				Util.swap(array, indexInterno, indexInterno - 1);
				indexInterno--;
			}
			indexExterno++;
		}
		
		INSERTIONSORT_APPLICATIONS++;
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
