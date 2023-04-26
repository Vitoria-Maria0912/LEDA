package problems;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		
		if(recursiveFloor(array, x, 0, array.length - 1) == -1) {
			return null;
			
		} else {
			return recursiveFloor(array, x, 0, array.length - 1);
		}
		
	}

	private Integer recursiveFloor(Integer[] array, Integer x, int left, int right) {
		
		int middle = (left + right) / 2;
		
		int floor = -1;
		
		if(left < right) {
			if(array[middle] == x) {
				floor = array[middle];
				
			} else if(array[middle] > x) {
				recursiveFloor(array, x, left, middle - 1);
				
			} else {
				recursiveFloor(array, x, middle + 1, right);
				floor = array[middle];
			}
		}
		
		return floor;
	}
}
