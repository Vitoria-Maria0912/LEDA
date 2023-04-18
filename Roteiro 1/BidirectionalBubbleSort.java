package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * This bubble sort variation has two internal iterations. In the first, it
 * pushes big elements to the right, like the normal bubble sort does. Then in
 * the second, iterates the array backwards, that is, from right to left, while
 * pushing small elements to the left. This process is repeated until the array
 * is sorted.
 */
public class BidirectionalBubbleSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		if(leftIndex < 0 || leftIndex >= rightIndex || rightIndex >= array.length) {
		}
		
		boolean troca = true;
		
		while(troca) {
			
			troca = false;
			
			for (int index = leftIndex; index < rightIndex; index++) {
				if(array[index].compareTo(array[index + 1]) > 0) {
					troca = true;
					Util.swap(array, index, index + 1);
				}
			}
			
			for (int index = rightIndex; index > leftIndex; index--) {
				if(array[index].compareTo(array[index - 1]) < 0) {
					troca = true;
					Util.swap(array, index, index - 1);
				}
			}
		}
	}
}
