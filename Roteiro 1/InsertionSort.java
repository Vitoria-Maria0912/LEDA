package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * As the insertion sort algorithm iterates over the array, it makes the
 * assumption that the visited positions are already sorted in ascending order,
 * which means it only needs to find the right position for the current element
 * and insert it there.
 */
public class InsertionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		if(leftIndex < 0 || leftIndex >= rightIndex || rightIndex >= array.length) {
		}

		int indexExterno = leftIndex + 1;
		
		while(indexExterno <= rightIndex) {
			
			int indexInterno = indexExterno;
			
			while(indexInterno > leftIndex && array[indexInterno].compareTo(array[indexInterno - 1]) < 0) {
				Util.swap(array, indexInterno, indexInterno - 1);
				indexInterno--;
			}
			indexExterno++;
		}
	}
}
