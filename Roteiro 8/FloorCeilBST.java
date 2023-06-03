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
		
		if(array != null && array.length > 0) {
			
			for(Integer element : array) {
				this.insert(element);
			}

			floor = floor(getRoot(), numero, null);
		}
		
		return floor;
	}

	private Integer floor(BSTNode<Integer> root2, double numero, Integer floor) {
		if (!(root2.isEmpty())) {
			if(numero < root2.getData()) {
				floor = floor((BSTNode<Integer>) root2.getLeft(), numero, floor);
				
			} else if(numero > root2.getData()) {
				floor = floor((BSTNode<Integer>) root2.getRight(), numero, root2.getData());
			
			} else {
				floor = root2.getData();
			}
		}
		return floor;
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		Integer ceil = null;
		
		if(array != null && array.length > 0) {
			
			for(Integer element : array) {
				this.insert(element);
			}

			ceil = ceil(getRoot(), numero, null);
		}
		
		return ceil;
	}

	private Integer ceil(BSTNode<Integer> root2, double numero, Integer ceil) {
		
		if (!(root2.isEmpty())) {
			if(numero < root2.getData()) {
				ceil = ceil((BSTNode<Integer>) root2.getLeft(), numero, root2.getData());
				
			} else if(numero > root2.getData()) {
				ceil = ceil((BSTNode<Integer>) root2.getRight(), numero, ceil);
			
			} else {
				ceil = root2.getData();
			}
		}
		return ceil;
	}
}
