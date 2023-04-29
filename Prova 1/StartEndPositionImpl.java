package problems;

/**
 * Dado um array A ordenado de inteiros de tamanho N e um valor x, possivelmente com mais de uma ocorrencia,
 * usar busca binária para encontrar as posicoes da primeira e ultima ocorrencias de x em  A.

Return an array of size 2, such that first element = starting position of B in A and second element = ending position of B in A, if B is not found in A return [-1, -1].

 * Restricoes: 
 * - Seu algoritmo NÃO pode usar memória extra (a nao ser variaveis simples locais e nao de colecao/estrutura) 
 * - O tempo de seu algoritmo deve ser O(log n).
 * - Retornar um array com dois elementos [primeiraPosicao,ultimaPosicao], onde primeiraPosicao
 *   tem o valor do indice da primeira ocorrencia de x em A, e ultimaPosicao tem o valor do indice 
 *   da ultima ocorrencia de x em A
 * - Note que se x nao esta em A entao o retorno deve ser [-1,-1]
 *
 */
public class StartEndPositionImpl implements StartEndPosition{


	@Override
	public int[] startEndPosition(Integer[] array, Integer x){
		
		int first = binaryFist(array, 0, array.length - 1, x);
		int last = binaryLast(array, 0, array.length - 1, x);
		
		if(!(array.length == 0 || array == null || first == -1 || last == -1)) {
			
			int[] esta = new int[] {first, last};
			
			return esta;
			
		} else {
			return new int[] {-1,-1};
		}
	}

	private int binaryFist(Integer[] array, int i, int f, int x) {
		
		int mid = (i + f) / 2;
		
		if(array[i] == x) {
			return i;
		}
		
		else if(i <= f) {
		
			if(array[mid] >= x) {
				return binaryFist(array, i + 1, mid - 1, x);
				
			} else {
				return binaryFist(array, mid + 1, f, x);
			}
		}
		return -1;
	}
	
	private int binaryLast(Integer[] array, int i, int f, int x) {
		
		int mid = (i + f) / 2;
		
		if(array[f] == x) {
			return f;
		}
		
		else if(i <= f) {
			
			if(array[mid] >= x) {
				return binaryFist(array, i, mid, x);
				
			} else if(array[mid] > x && array[mid + 1] > x){
				return binaryFist(array, mid + 1, f - 1, x);
			}
		}
		return -1;
	}
}
