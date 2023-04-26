package submission;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import problems.FloorBinarySearchImpl;

public class TesteFloor {
	
	FloorBinarySearchImpl floorBinarySearch;
	
	@BeforeEach
	void floor() {
		this.floorBinarySearch = new FloorBinarySearchImpl();
	}

	@Test
	public void test() {
		Integer[] array = new Integer [] {1, 2, 5, 10};
		int result = this.floorBinarySearch.floor(array, 4);
		
		assertEquals(2, result);
	}
	
	@Test
	public void test2() {
		Integer[] array = new Integer [] {1, 2, 5, 10};
		int result = this.floorBinarySearch.floor(array, 0);
		
		assertEquals(null, result);
	}
	
	@Test
	public void test3() {
		Integer[] array = new Integer [] {};
		int result = this.floorBinarySearch.floor(array, 1);
		
		assertNotEquals(2, result);
	}
}
