package sorting.divideAndConquer;

import sorting.AbstractSorting;
import util.Util;

/**
 * Quicksort is based on the divide-and-conquer paradigm. The algorithm chooses
 * a pivot element and rearranges the elements of the interval in such a way
 * that all elements lesser than the pivot go to the left part of the array and
 * all elements greater than the pivot, go to the right part of the array. Then
 * it recursively sorts the left and the right parts. Notice that if the list
 * has length == 1, it is already sorted.
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		if(leftIndex < 0 || rightIndex <= leftIndex || rightIndex >= array.length || array.length == 1) {
		}
		
		int indexPivot = partition(array, leftIndex, rightIndex);
		
		sort(array, leftIndex, indexPivot - 1);
		sort(array, indexPivot + 1, rightIndex);
	}

	private int partition(T[] array, int leftIndex, int rightIndex) {
		
		T pivot = array[leftIndex];
		
		int indexPivot = leftIndex;
		
		for(int index = indexPivot + 1; index <= rightIndex; index++) {
			if(pivot.compareTo(array[index]) >= 0) {
				
                indexPivot ++;
                
                Util.swap(array, indexPivot, index);
            }
		}
		Util.swap(array, indexPivot, leftIndex);
		
		return indexPivot;
	}
}
