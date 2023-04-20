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
		if(!(leftIndex < 0 || leftIndex >= rightIndex || rightIndex >= array.length)) {
			coutingSort(array, leftIndex, rightIndex);
		}
	}

	private void coutingSort(Integer[] array, int leftIndex, int rightIndex) {
		
		int maior = calculaMaior(array, leftIndex, rightIndex);
		int menor = calculaMenor(array, leftIndex, rightIndex);
		
		int[] arrayQuantidades = new int[maior - menor + 1];
		
		for(int index = leftIndex; index <= rightIndex; index++) {
			arrayQuantidades[array[index] - menor]++; 
		}
		
		for(int index = 1; index < arrayQuantidades.length; index++) {
			arrayQuantidades[index] += arrayQuantidades[index - 1]; 
		}
		
		int[] arrayOrdenado = new int[rightIndex - leftIndex + 2]; // isso esta errado, é + 1
		
		for(int index = rightIndex; index >= leftIndex; index--) {
			arrayOrdenado[arrayQuantidades[array[index] - menor]] = array[index];
			arrayQuantidades[array[index] - menor] --;
		}
		
		int indiceOrdenacao = 0;
		
		for(int index = leftIndex; index <= rightIndex; index++) {
			array[index] = arrayOrdenado[indiceOrdenacao];
			indiceOrdenacao++; 
		}
	}
	
	private int calculaMenor(Integer[] array, int leftIndex, int rightIndex) {
		
		int menor = array[leftIndex];
		
		for(int index = leftIndex + 1; index <= rightIndex; index++) {
			if(array[index] < menor) {
				menor = array[index];
			}
		}
		return menor;
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
