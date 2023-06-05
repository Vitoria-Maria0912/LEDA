package orderStatistic;

import java.util.PriorityQueue;

public class OrderStatisticsHeapImpl<T extends Comparable<T>> implements OrderStatistics<T> {

	/**
	 * Existem diversas formas de se calcular uma estatistica de ordem. 
	 * Voce deve fazer isso usando uma heap restricoes:
	 * - nenhuma copia ou estrutura array auxiliar serah permitida, exceto o uso de
	 *   uma PriorityQueue
	 * - caso a estatistica de ordem procurada nao exista no array o metodo deve retornar null 
	 * 
	 * @param array
	 * @param k
	 * @return
	 */
	
	@Override
	public T getOrderStatistics(T[] array, int k) {
		
		PriorityQueue<T> heap = new PriorityQueue<T>();
		
		T orderStatistics = null;
		
		if(array != null && k > 0 && k <= array.length) {
			
			for(T value: array) {
				heap.add(value);
			} 
			
			for(int i = 0; i < k; i++) {
				orderStatistics = heap.poll();
			}
		}
		return orderStatistics;
	}
}
