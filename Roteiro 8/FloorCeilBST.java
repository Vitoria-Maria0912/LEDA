package adt.bst.extended;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

/**
 * Note que esta classe estende sua implementacao de BST (BSTImpl).
 * Dependendo do design que voce use, sua BSTImpl precisa ter apenas funcionando
 * corretamente o metodo insert para que voce consiga testar esta classe.
 */
public class FloorCeilBSTImpl extends BSTImpl<Integer> implements FloorCeilBST {

	@Override
	public Integer floor(Integer[] array, double numero) {
		
		Integer floor = null;
		
		if(array != null) {
			floor = floor(this.root, numero, floor);
		}
		return floor;
	}
	
	
	private Integer floor(BSTNode<Integer> node, double numero, Integer floor) {
		
		if(node.getData().compareTo((int) numero) < 0) {
			return floor((BSTNode<Integer>) node.getLeft(), numero, floor);
		
		} else if(node.getData().compareTo((int) numero) > 0){
			return floor((BSTNode<Integer>) node.getRight(), numero, floor);
			
		} else {
			floor = node.getData();
		}
		return floor;
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		//TODO Implemente seu codigo aqui
		throw new UnsupportedOperationException("Not implemented yet!");
	}

}
