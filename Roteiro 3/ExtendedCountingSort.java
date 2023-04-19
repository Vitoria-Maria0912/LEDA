package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if(leftIndex < 0 || leftIndex >= rightIndex || rightIndex >= array.length) {
		}  else {
			coutingSort(array, rightIndex, rightIndex);
		}
	}

	private void coutingSort(Integer[] array, int leftIndex, int rightIndex) {
		
	}
}
