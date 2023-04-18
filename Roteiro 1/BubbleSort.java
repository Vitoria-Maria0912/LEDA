package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * The bubble sort algorithm iterates over the array multiple times, pushing big
 * elements to the right by swapping adjacent elements, until the array is
 * sorted.
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		if(leftIndex < 0 || leftIndex >= rightIndex || rightIndex >= array.length) {
			return;
		}
		
		boolean troca = true;
		
		while(troca) {
			
			int index = leftIndex;
			troca = false;
			
			while(index < rightIndex) {
				if(array[index].compareTo(array[index + 1]) > 0) {
					troca = true;
					Util.swap(array, index, index + 1);
				}
				index++;

			}
		}
	}
}
