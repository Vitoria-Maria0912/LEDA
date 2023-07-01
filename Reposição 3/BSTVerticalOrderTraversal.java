import java.util.List;

/**
 * Percurso vertical de uma BST consiste dos nos visitados da esquerda para a direita
 * na arvore. Ele é semelhante a traçar linhas verticais (níveis verticais) na BST de forma a que se detecte
 * os nós que se encontram em cada linha vertical. Assim o elemento mais a esquerda da árvore está
 * na primeira linha vertical. O filho a direita e o pai desse elemento estariam na segunda linha
 * vertical, e assim por diante.
 *
 * É possivel que um nivel vertical tenha mais de um elemento. No caso de elementos em um mesmo
 * nivel vertical sendo de diferentes nivels horizontais, os elementos de menores níveis horizontais
 * (que estão acima) devem ser visitados primeiro.
 */
public interface BSTVerticalOrderTraversal<T extends Comparable<T>> {

  /**
   * Metodo para construir a lista de elementos visitados segundo o percurso vertical
   * em uma BST.
   *
   * Exemplo: sejam as seguintes BSTs A e B conforma abaixo
   * Input 1:
   * 
   * A =
   *          6
   *        /   \
   *       3     7
   *      / \     \
   *     2   5     9
   *
   * B =
   *            1
   *          /   \
   *         2     3
   *       / \
   *      4   5
   *
   * As saidas dos percursos verticais das arvores acima seriam a seguir
   * considere a representacao [x,y] como sendo uma lista contendo os elementos x,y
   * 
   * Output A:
   *      [  [2],     // 2 é o elemento mais a esquerda (primeiro nivel vertical)
   *         [3],     // 3 é o elemento no nivel vertical 1 (segundo nivel vertical)
   *         [6,5],   // 6 e 5 sao os elementos no nivel vertical 2
   *         [7],     // 7 é o elemento no nivel vertical 3
   *         [9]      // 9 é o elemento no nivel vertical 4
   *      ]
   *
   * Output B:
   * 
   *      [  [4],
   *         [2],
   *         [1,5],
   *         [3]
   *      ]
   *
   * Restricoes:
   * 
   * - Voce pode usar estrutura auxiliar (coleção) apenas para preencher retornar
   *   a resposta. Seu algoritmo não pode operar sobre essa estrutura para resulver
   *   o problema.
   * - Voce nao pode reutilizar nenhum método pronto da uma BST na implementação
   *   deste método, exceto o getRoot() já fornecido no ambiente
   * - Voce DEVE utilizar resursão para resolver o problema
   * - Voce pode resolver o problema de diferentes formas, mas preocupe-se em
   *   usar o melhor design possivel, aproveitando as classes que foram fornecidas
   * - A unica classe que voce pode editar é BSTVerticalOrderTraversalImpl.java
   *
   * Observacoes:
   * - A classe BSTInteger é fornecida como uma implementacao de BST para que voce possa
   */
  public List<List<T>> verticalTraversal(BST<T> bst);
}

public class MultiValueMap<K,V> extends TreeMap<K,List<V>>{

  public void putPair(K key, V value) {
    List<V> values = new LinkedList<V>();
    if(this.containsKey(key)){
      values = this.get(key);
    } else {
      super.put(key, values);
    }
    values.add(value);
  }

  @Override
  public List<V> put(K key, List<V> value) {
    throw new UnsupportedOperationException("Invalid operation. Use putValue instead");
  }
}
