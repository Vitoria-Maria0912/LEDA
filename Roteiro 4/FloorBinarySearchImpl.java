package problems;

import util.Util;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		
		if(array.length == 0 || x == null || recursiveFloor(array, x, null, 0, array.length - 1) == null) {
			return null;
			
		} else {
			ordenaArray(array, 0, array.length - 1);
			return recursiveFloor(array, x, null, 0, array.length - 1);
		}
	}
	
	private Integer recursiveFloor(Integer[] array, Integer x, Integer floor, int left, int right) {
		
		if(left >= 0 && left <= right && right < array.length) {
		
			int middle = (left + right) / 2;
			
			if(array[middle] == x) {
				return array[middle];
				
			} else if(array[middle] > x) {
				return recursiveFloor(array, x, floor, left, middle - 1);
				
			} else if(array[middle] < x) {
				return recursiveFloor(array, x, array[middle], middle + 1, right);
			}
		}

		return floor;
	}

	private int partition(Integer[] array, int first, int last) {
		
		int pivot = array[first];
		int auxiliar = first;

		for (int j = first + 1; j <= last; j++) {
			if (array[j].compareTo(pivot) <= 0) {
				auxiliar += 1;
				Util.swap(array, auxiliar, j);
			}
		}

		Util.swap(array, first, auxiliar);

		return auxiliar;
	}
	
	public void ordenaArray(Integer[] array, int left, int right) {
		
		if(left < 0 || right <= left || right >= array.length || array.length == 1) {
			
		} else {
			
			int pivotIndex = partition(array, left, right);
			
			ordenaArray(array, left, pivotIndex - 1);
			ordenaArray(array, pivotIndex + 1, right);
		}
	}
}
