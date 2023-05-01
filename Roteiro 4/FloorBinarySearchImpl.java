package problems;

import util.Util;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		
		if(array.length == 0 || recursiveFloor(array, x, 0, array.length - 1) == -1 ) {
			return null;
			
		} else {
			return recursiveFloor(array, x, 0, array.length - 1);
		}
	}
	
	private Integer recursiveFloor(Integer[] array, Integer x, int left, int right) {
		
		array = ordenaArray(array);
		
		int middle = (left + right) / 2;
		
		int floor = -1;
		
		if(array[right] <= x) {
			return array[right];
			
		} else if(array[left] > x) {
			return -1;
			
		} else if(left < right) {
			
			if(array[middle] > x) {
				recursiveFloor(array, x, left, middle - 1);
				
			} else if(array[middle] < x) {
				recursiveFloor(array, x, middle + 1, right);
				floor = array[middle];
			}
			else {
				return array[middle];
			}
		}
		
		return floor;
	}

	private Integer[] ordenaArray(Integer[] array) {
		
		int first = 0;
		int last = array.length - 1;
		
		int indexPivot = pivotMedianOfThree(array, first, last);
		int auxiliar = last - 1;
		
		Util.swap(array, indexPivot, last - 1);
		
		Integer pivot = array[last - 1];
		
		for(int index = auxiliar - 1; index >= first + 1; index--) {
			if(array[index].compareTo(pivot) >= 0) {
				auxiliar--;
                Util.swap(array, auxiliar, index);
            }
		}
		
		Util.swap(array, auxiliar, last - 1);
		
		return array;
	}
	
	private int pivotMedianOfThree(Integer[] array, int first, int last) {
	
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
