package adt.bst;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		return height(this.root);
	}

	private int height(BSTNode<T> root) {
		
		int height = -1;
		
		while(!(root.isEmpty())) {
			height = 1 + Math.max(height((BSTNode<T>) root.getLeft()), height((BSTNode<T>) root.getRight()));
		}
		return height;
	}

	@Override
	public BSTNode<T> search(T element) {
		
		BSTNode<T> found = null;
		
		if((getRoot().getData()).compareTo(element) > 0) {
			
		} else if ((getRoot().getData()).compareTo(element) < 0){
			
		} else {
			
		}
		return found;
	}

	@Override
	public void insert(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public BSTNode<T> maximum() {
		BSTNode<T> maximum = null;
		
		if(!(isEmpty())) {
			maximum = maximum(this.root);
		}
		return maximum;
	}

	private BSTNode<T> maximum(BSTNode<T> root) {
		
		BSTNode<T> maximum = root;
		
		while(!(root.getRight().isEmpty())) {
			maximum = maximum((BSTNode<T>) root.getRight());
		}
		
		return maximum;
	}

	@Override
	public BSTNode<T> minimum() {
		
		BSTNode<T> minimum = null;
		
		if(!(isEmpty())) {
			minimum = minimum(this.root);
		}
		
		return minimum;
	}

	private BSTNode<T> minimum(BSTNode<T> root) {
		
		BSTNode<T> minimum = root;
		
		while(!(root.getLeft().isEmpty())) {
			minimum = minimum((BSTNode<T>) root.getLeft());
		}
		return minimum;
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public void remove(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] preOrder() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] order() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] postOrder() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}
