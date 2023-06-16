package problems;
   
 import adt.bst.BST;
 import adt.bst.BSTNode;

 public class BSTSumLeavesImpl implements BSTSumLeaves{

     public int sumLeaves(BST<Integer> bst){

      int sumLeaves = 0;

      if(!(bst.isEmpty())) {
        sumLeaves = sumLeavesRecursive((BSTNode<Integer>) bst.getRoot(), sumLeaves);
      }

      return sumLeaves;
    }

    private int sumLeavesRecursive(BSTNode<Integer> node, int sumLeaves){

      if(!(node.isEmpty())) {

        sumLeaves = sumLeavesRecursive((BSTNode<Integer>) node.getLeft(), sumLeaves);
        sumLeaves = sumLeavesRecursive((BSTNode<Integer>) node.getRight(), sumLeaves);

      		sumLeaves += node.getData();
      	}
      	
      	return sumLeaves;
      }
}
