package submission;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import orderStatistic.QuickSelect;

class TesteQuickSelect {

	QuickSelect<Integer> quick;
	
	@BeforeEach
	void floor() {
		this.quick = new QuickSelect<>();
	}

	@Test
	public void test() {
		try {
			Integer[] array = new Integer [] {1, 2, 5, 10};
			int result = quick.quickSelect(array, 0);
			
			assertEquals(null, result);
		} catch(NullPointerException e) {
		}
	}

	@Test
	public void test2() {
		try {
			Integer[] array = new Integer [] {};
			int result = quick.quickSelect(array, 1);
			
			assertEquals(null, result);
		} catch(NullPointerException e) {
		}
	}
	
	@Test
	public void test3() {
		try {
			Integer[] array = new Integer [] {1, 2, 5, 10};
			int result = quick.quickSelect(array, 5);
			
			assertEquals(null, result);
		} catch(NullPointerException e) {
		}
	}
	
	@Test
	public void test4() {
		Integer[] array = new Integer [] {1, 2, 5, 10};
		int result = quick.quickSelect(array, 1);
		
		assertEquals(1, result);
	}
	
	@Test
	public void test5() {
		Integer[] array = new Integer [] {1, 2, 5, 10};
		int result = quick.quickSelect(array, 4);
		
		assertEquals(10, result);
	}
	
	@Test
	public void test6() {
		try {
			Integer[] array = new Integer [] {1, 4};
			int result = quick.quickSelect(array, 3);
			
			assertEquals(null, result);
		} catch(NullPointerException e) {
		}
	}
	
	@Test
	public void test7() {
		Integer[] array = new Integer [] {5, 10, 0, 2};
		int result = quick.quickSelect(array, 1);
		
		assertEquals(0, result);
	}
	
	@Test
	public void test8() {
		try {
			Integer[] array = new Integer [] {1, 2, 3};
			int result = quick.quickSelect(array, -1);
			
			assertEquals(null, result);
		} catch(NullPointerException e) {
		}
	}
	
	@Test
	public void test9() {
		Integer[] array = new Integer [] {1, 2, 3, 5, 10, 0};
		int result = quick.quickSelect(array, 4);
		
		assertEquals(3, result);
	}
	
	@Test
	public void test10() {
		Integer[] array = new Integer [] {1, 2, 3, 5, 10, 15};
		int result = quick.quickSelect(array, 6);
		
		assertEquals(15, result);
	}
	
	@Test
	public void test11() {
		Integer[] array = new Integer [] {5, 10, 0, 2};
		int result = quick.quickSelect(array, 2);
		
		assertEquals(2, result);
	}
	
	@Test
	public void test12() {
		Integer[] array = new Integer [] {15, 14, 13, 12, 11, 10};
		int result = quick.quickSelect(array, 1);
		
		assertEquals(10, result);
	}
}
