package submission;

import static org.junit.Assert.*;

import org.junit.Test;

import problems.FloorBinarySearchImpl;

public class TesteFloor {
	
	@Test
	public void test() {
		FloorBinarySearchImpl floorBinarySearch = new FloorBinarySearchImpl();
		Integer[] array = new Integer [] {1, 2, 5, 10};
		int result = floorBinarySearch.floor(array, 4);
		
		assertEquals(2, result);
	}
	
	@Test
	public void test2() {
		try {
			FloorBinarySearchImpl floorBinarySearch = new FloorBinarySearchImpl();
			Integer[] array = new Integer [] {1, 2, 5, 10};
			int result = floorBinarySearch.floor(array, 0);
			
			assertEquals(null, result);
		} catch (NullPointerException e) {
		}
	}
	
	@Test
	public void test3() {
		try {
			FloorBinarySearchImpl floorBinarySearch = new FloorBinarySearchImpl();
			Integer[] arrayVazio = new Integer [] {};
			int result = floorBinarySearch.floor(arrayVazio, 1);
			
			assertNotEquals(null, result);
		} catch(NullPointerException e) {
			
		}
	}
	
	@Test
	public void test4() {
		FloorBinarySearchImpl floorBinarySearch = new FloorBinarySearchImpl();
		Integer[] array = new Integer [] {-1, 2, 4, 5};
		int result = floorBinarySearch.floor(array, 0);
		
		assertEquals(-1, result);
	}
	
	@Test
	public void test5() {
		FloorBinarySearchImpl floorBinarySearch = new FloorBinarySearchImpl();
		Integer[] array = new Integer [] {1, 2, 4, 5, 7};
		int result = floorBinarySearch.floor(array, 4);
		
		assertNotEquals(2, result); 
	}

	@Test
	public void test6() {
		FloorBinarySearchImpl floorBinarySearch = new FloorBinarySearchImpl();
		Integer[] array = new Integer [] {1, 2, 4, 5, 7};
		int result = floorBinarySearch.floor(array, 8);
		
		assertEquals(7, result);
	}
	
	@Test
	public void test7() {
		FloorBinarySearchImpl floorBinarySearch = new FloorBinarySearchImpl();
		Integer[] array = new Integer [] {7, 6, 2, 0};
		int result = floorBinarySearch.floor(array, 8);
		
		assertEquals(7, result);
	}
	
	@Test
	public void test8() {
		FloorBinarySearchImpl floorBinarySearch = new FloorBinarySearchImpl();
		Integer[] array = new Integer [] {10, 0, 60, -1};
		int result = floorBinarySearch.floor(array, 4);
		
		assertEquals(0, result);
	}
	
	@Test
	public void test9() {
		try {
			FloorBinarySearchImpl floorBinarySearch = new FloorBinarySearchImpl();
			Integer[] array = new Integer [] {1};
			int result = floorBinarySearch.floor(array, 0);
			
			assertEquals(null, result);
		} catch (NullPointerException e) {
		}
	}
	
	@Test
	public void test10() {
		FloorBinarySearchImpl floorBinarySearch = new FloorBinarySearchImpl();
		Integer[] array = new Integer [] {-2};
		int result = floorBinarySearch.floor(array, 0);
		
		assertEquals(-2, result);
	}
	
	@Test
	public void test11() {
		FloorBinarySearchImpl floorBinarySearch = new FloorBinarySearchImpl();
		Integer[] array = new Integer [] {-2, 1};
		int result = floorBinarySearch.floor(array, 0);
		
		assertEquals(-2, result);
	}
	
	@Test
	public void test12() {
		try {
			FloorBinarySearchImpl floorBinarySearch = new FloorBinarySearchImpl();
			Integer[] array = new Integer [] {-2, 1, 7};
			int result = floorBinarySearch.floor(array, -3);
			
			assertEquals(null, result);
		} catch (NullPointerException e) {
		}
	}
}
