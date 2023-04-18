package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * The selection sort algorithm chooses the smallest element from the array and
 * puts it in the first position. Then chooses the second smallest element and
 * stores it in the second position, and so on until the array is sorted.
 */
public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		if(leftIndex < 0 || leftIndex >= rightIndex || rightIndex >= array.length) {
		}
		
		for(int indexExterno = leftIndex; indexExterno <= rightIndex; indexExterno++) {
			
			int minimo = indexExterno;
			
			for(int indexInterno = indexExterno + 1; indexInterno <= rightIndex; indexInterno++) {
				if(array[minimo].compareTo(array[indexInterno]) >= 0) {
					minimo = indexInterno;
				}
			}
			Util.swap(array, minimo, indexExterno);
		}
	}
}
