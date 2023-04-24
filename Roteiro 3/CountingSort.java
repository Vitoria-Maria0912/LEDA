package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala.
 *
 * Procure evitar desperdício de memória: AO INVÉS de alocar o array de contadores
 * com um tamanho arbitrariamente grande (por exemplo, com o maior valor de entrada possível),
 * aloque este array com o tamanho sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Seu algoritmo deve assumir que o array de entrada nao possui numeros negativos,
 * ou seja, possui apenas numeros inteiros positivos e o zero.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if(!(leftIndex < 0 || leftIndex >= rightIndex || rightIndex >= array.length)) {
			coutingSort(array, leftIndex, rightIndex);
		}
	}
	
	private void coutingSort(Integer[] array, int leftIndex, int rightIndex) {
		
		int[] arrayQuantidades = new int[calculaMaior(array, leftIndex, rightIndex) + 1];
		
		for(int index = leftIndex; index <= rightIndex; index++) {
			arrayQuantidades[array[index]] ++; 
		}
		
		for(int index = 1; index < arrayQuantidades.length; index++) {
			arrayQuantidades[index] += arrayQuantidades[index - 1]; 
		}
		
		int[] arrayOrdenado = new int[rightIndex - leftIndex + 1];
		
		for(int index = rightIndex; index >= leftIndex; index--) {
			arrayOrdenado[arrayQuantidades[array[index]] - 1] = array[index];
			arrayQuantidades[array[index]] --;
		}
		
		int indiceOrdenacao = 0;
		
		for(int index = leftIndex; index <= rightIndex; index++) {
			array[index] = arrayOrdenado[indiceOrdenacao];
			indiceOrdenacao++; 
		}
	}

	private int calculaMaior(Integer[] array, int leftIndex, int rightIndex) {
		
		int maior = array[leftIndex];
		
		for(int index = leftIndex + 1; index <= rightIndex; index++) {
			if(array[index] > maior) {
				maior = array[index];
			}
		}
		return maior;
	}
}
