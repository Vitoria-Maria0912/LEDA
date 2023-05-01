package orderStatistic;

import util.Util;

/**
 * Uma implementacao da interface KLargest que usa estatisticas de ordem para 
 * retornar um array com os k maiores elementos de um conjunto de dados/array.
 * 
 * A k-esima estatistica de ordem de um conjunto de dados eh o k-esimo menor
 * elemento desse conjunto. Por exemplo, considere o array [4,8,6,9,12,1]. 
 * A 3a estatistica de ordem eh 6, a 6a estatistica de ordem eh 12.
 * 
 * Note que, para selecionar os k maiores elementos, pode-se pegar todas as 
 * estatisticas de ordem maiores que k. 
 * 
 * Requisitos do algoritmo:
 * - DEVE ser in-place. Porem, voce pode modificar o array original.
 *   Voce pode criar ainda um array de tamanho k que vai armazenar apenas
 *   os elementos a serem retornados.
 * - Voce DEVE usar alguma ideia de algoritmo de ordenacao visto em sala 
 *   para calcular estatisticas de ordem.
 * - Se a entrada for invalida, deve-se retornar um array vazio (por exemplo,
 *   ao solicitar os 5 maiores elementos em um array que soh contem 3 elementos).
 *   Este metodo NUNCA deve retornar null.
 * 
 * @author campelo and adalberto
 *
 * @param <T>
 */
public class KLargestOrderStatisticsImpl<T extends Comparable<T>> implements KLargest<T>{

	@Override
	public T[] getKLargest(T[] array, int k) {
		
		if(orderStatistics(array, k) != null) {
			return kLarguestArray(array, k);
		}
		
		return (T[]) new Comparable[0];
	}

	/**
	 * Metodo que retorna a k-esima estatistica de ordem de um array, usando
	 * a ideia de algum algoritmo de ordenacao visto em sala. Caso nao exista 
	 * a k-esima estatistica de ordem, entao retorna null.
	 * 
	 * Obs: o valor de k deve ser entre 1 e N.
	 * 
	 * @param array
	 * @param k
	 * @return
	 */
	public T orderStatistics(T[] array, int k){
		
		if(k > 0 && k <= array.length) {
			
			array = ordena(array, 0, array.length - 1);
			
			return array[k - 1];
			
		} else {
			return null;			
		}
	}

	private T[] kLarguestArray(T[] array, int k) {
		
		T[] KLargest = (T[]) new Comparable[k];
		
		array = ordena(array, 0, array.length - 1);
		
		for(int index = 0; index < k; index++) {
			KLargest[index] = array[index];
		}
		
		return KLargest;
	}
	
	public T[] ordena(T[] array, int left, int right) {
		
		int indexExterno = left + 1;
		
		while(indexExterno <= right) {
			
			int indexInterno = indexExterno;
			
			while(indexInterno > left && array[indexInterno].compareTo(array[indexInterno - 1]) < 0) {
				Util.swap(array, indexInterno, indexInterno - 1);
				indexInterno--;
			}
			indexExterno++;
		}
		
		return array;
	}
}
