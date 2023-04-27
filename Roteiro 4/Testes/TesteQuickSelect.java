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
		
		assertEquals(1, result);
	}
	
	@Test
	public void test6() {
		try {
			Integer[] array = new Integer [] {null};
			int result = quick.quickSelect(array, 1);
			
			assertEquals(null, result);
		} catch(NullPointerException e) {
		}
	}
}
