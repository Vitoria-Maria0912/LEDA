package submission;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import orderStatistic.KLargestOrderStatisticsImpl;

class TesteKLargestOrderStatistics {
	
	KLargestOrderStatisticsImpl<Integer> order;

	@BeforeEach
	void order() {
		this.order = new KLargestOrderStatisticsImpl<>();
	}
	
	@Test
	void test() {
		Integer[] array = new Integer [] {1, 2, 5, 10};
		int result = order.orderStatistics(array, 1);
		
		assertEquals(1, result);
	}
}
