package submission;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import orderStatistic.KLargestOrderStatisticsImpl;

public class TesteKLargestOrderStatistics {
	
    private KLargestOrderStatisticsImpl<Integer> order;

    @Before
    public void setUp() {
        this.order = new KLargestOrderStatisticsImpl<>();
    }

    @Test
    public void test1() {
    	Integer[] array = new Integer[] {30, 28, 7, 29, 11, 26};
    	try {
    		assertEquals(this.order.orderStatistics(array, 0), (Integer) null);
    	} catch(NullPointerException e) {
    	}
    }

    @Test
    public void test2() {
    	Integer[] array = new Integer[] {1, 2, 3};
        assertEquals(this.order.orderStatistics(array, 2), (Integer) 2);
    }

    @Test
    public void test3() {
    	Integer[] array = new Integer[] {};
    	try {
    		assertEquals(this.order.orderStatistics(array, 5), (Integer) null);
    	} catch(NullPointerException e) {
    	}
    }

    @Test
    public void test4() {
    	try {
    		assertEquals(this.order.orderStatistics(null, 5), null);
	    } catch(NullPointerException e) {
		}
    }

    @Test
    public void test5() {
    	Integer[] array = new Integer[] {0, 9, 7};
    	
    	try {
        assertEquals(this.order.orderStatistics((array), 11), null);
	    } catch(NullPointerException e) {
		}
    }

    @Test
    public void test6() {
    	Integer[] array = new Integer[] {0, 9, 7};
    	try {
            assertEquals(this.order.orderStatistics((array), -1), null);
	    } catch(NullPointerException e) {
		}
    }

    @Test
    public void test7() {
    	Integer[] array = new Integer[] {1, 2, 3};
    	try {
            assertEquals(this.order.orderStatistics((array), 0), null);
	    } catch(NullPointerException e) {
		}
    }

    @Test
    public void test8() {
    	Integer[] array = new Integer[] {1, 2, 3};
        assertArrayEquals(this.order.getKLargest(array, 1), new Integer[] {1});
    }

    @Test
    public void test9() {
        assertArrayEquals(this.order.getKLargest(new Integer[] {}, 2), new Integer[] {});
    }

    @Test
    public void test10() {
    	try {
    		assertArrayEquals(this.order.getKLargest(null, 5), new Integer[] {});
    	} catch(NullPointerException e) {
    	}
    }

    @Test
    public void test11() {
    	Integer[] array = new Integer[] {0, 9, 7};
        assertArrayEquals(this.order.getKLargest((array), 11), new Integer[] {});
    }

    @Test
    public void test12() {
    	Integer[] array = new Integer[] {0, 9, 7};
        assertArrayEquals(this.order.getKLargest((array), -1), new Integer[] {});
    }

    @Test
    public void test13() {
        assertArrayEquals(this.order.getKLargest(new Integer[] {}, 5), new Integer[] {});
    }
}
