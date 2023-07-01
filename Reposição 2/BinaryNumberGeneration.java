import java.util.List;

/**
 * Interface contendo um método para gerar todos os numeros binarios de 1 até k
 * retornando-os em uma lista na ordem crescente (de 1 até k). As representações
 * em binário são em strings de 0's e 1's.
 **/
public interface BinaryNumberGeneration {
    /**
     * Metodo para gerar representacoes binarias (strings) de numeros de 1 até k
     * colocando-os em uma lista, em ordem crescente, e retornando a lista ao final.
     * Exemplo: k = 3
     * Retorno: ["1","10","11"]
     * 
     * Exemplo: k = 10
     * Retorno: ["1","10","11","100","101", "110", "111", "1000", "1001", "1010"]
     *
     * Restricoes e informacoes:
     * - O metodo Integer.toBinaryString(k) retorna a representacao binaria em string 
     *   de um numero inteiro. Esse metodo pode ser util. 
     * - Voce NAO pode simplesmente pegar os numeros de 1 até k (em um loop por exemplo), usar
     *   Integer.toBinaryString para gerar a representacao binária e colocar na sua
     *   lista de resposta!!!!!
     * - Voce DEVE usar uma fila ou uma pilha para construir as representacoes binárias de 
     *   todos os numeros de 1 até k e depois montar sua resposta, em tempo linear!
     * - A decisão de suar fila ou pilha é completamente sua, baseado no que você entende
     *   do problema e das estruturas.
     * - Voce NÃO pode usar comandos break e continue em seu código
     * - A classe java.util.ArrayDeque é uma coleção especial que pode funcioanr como 
     *   pilha ou como fila. Alguns metodos dela são:
     *   addFirst(elem) = insere um elemento no inicio da estrutura
     *   removeFirst() = remove do início da estrutura
     *   getFirst() = retorna o primeiro elemento sem remove-lo da estrutura
     *   clear() = esvazia a estrutura removendo todos os seus elementos
     *   isEmpty() = diz se a estrutura está vazia ou não
     *   addLast(elem) = insere um elemento no final da estrutura
     *   removeLast() = remove do final da estrutura
     *   getLast() = retorna o ultimo elemento sem remove-lo da estrutura
     * 
     *   Note que essa estrutura tem diversos métodos. A forma de usar ela como pilha ou como fila 
     *   nada mais é do que usar os metodos corretos para faze-la funcionar com uma política 
     *   conveniente. Voce DEVE usar uma instancia/objeto dessa classe dentro de seu método
     *   para resolver o problema de gerar as representações binárias.  
     * - Voce NÃO pode usar espaço extra além de uma intancia de java.util.ArrayDeque
     * - Voce NÃO pode criar atributos novos na classe BinaryNumberGenerationImpl
     * - Voce só pode modificar apenas a classe BinaryNumberGenerationImpl
     **/
    public List<String> generateBinaryNumbers(int k);
}