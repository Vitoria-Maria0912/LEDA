package adt.bst;

import adt.bt.BTNode;

/**
 * - Esta eh a unica classe que pode ser modificada 
 * @author adalbertocajueiro
 *
 * @param <T>
 */
public class SimpleBSTManipulationImpl<T extends Comparable<T>> implements SimpleBSTManipulation<T> {

	@Override
	public boolean equals(BST<T> tree1, BST<T> tree2) {
		
		boolean equals = false;
		
		if(tree1 != null && tree2 != null) {
			equals = equals(tree1.preOrder(), tree2.preOrder(), 0);
		}
		return equals;
	}

	private boolean equals(T[] tree1, T[] tree2, int index) {
		
		boolean equals = false;
		
		if(tree1.length > index && tree2.length > index) {
			
			if(tree1[index].compareTo(tree2[index]) == 0) {
				
				equals = true;
				equals(tree1, tree2, index + 1);
			}
			
		} else if ((tree1.length < index && tree2.length > index) || (tree1.length > index && tree2.length < index)) {
			equals = false;
		} 
		
		return equals;
	}
	@Override
	public boolean isSimilar(BST<T> tree1, BST<T> tree2) {
		
		boolean isSimilar = false;
		
		if(tree1.getRoot().isEmpty() && tree2.getRoot().isEmpty()) {
			isSimilar = true;
		
		} else if(equals(tree1, tree2)) {
			isSimilar = true;
		
		} else if(tree1 != null && tree2 != null) {
			isSimilar = isSimilar(tree1.getRoot(), tree2.getRoot());
		}
		return isSimilar;
	}

	private boolean isSimilar(BTNode<T> tree1root, BTNode<T> tree2root) {
		
		boolean isSimilar = false;
		
		if(!(tree1root.isEmpty()) && !(tree2root.isEmpty())) {
			
			if(isSimilar((BSTNode<T>) tree1root.getLeft(), (BSTNode<T>) tree2root.getLeft())
				&& isSimilar((BSTNode<T>) tree1root.getRight(), (BSTNode<T>) tree2root.getRight())) {
				
				isSimilar = true;
			}
		}
		return isSimilar;
	}

	@Override
	public T orderStatistic(BST<T> tree, int k) {
		
		T orderStatistic = null;
		
		if(!(tree.isEmpty())) {
			
			if(k > 0 && tree.size() >= k) {
				
				if(k == 1) {
					orderStatistic = tree.minimum().getData();
					
				} else if(k == tree.size()) {
					orderStatistic = tree.maximum().getData();
					
				} else {
					orderStatistic = orderStatistic(tree.order(), k, 1);
				}
			} 
		}
		
		return orderStatistic;
	}

	private T orderStatistic(T[] tree1, int k, int index) {
		
		T orderStatistic = null;
		
		if(k == index + 1) {
			orderStatistic = tree1[index];
			
		} else {
			orderStatistic = orderStatistic(tree1, k, index + 1);
		}
		
		return orderStatistic;
	}
}
