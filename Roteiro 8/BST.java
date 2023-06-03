package adt.bst;

import java.util.ArrayList;

import adt.bt.BTNode;

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

	private int height(BSTNode<T> root2) {
		
		int height = -1;
		
		if(!(root2.isEmpty())) {
			height = 1 + Math.max(this.height((BSTNode<T>) root2.getLeft()), this.height((BSTNode<T>) root2.getRight()));
		}
		return height;
	}

	@Override
	public BSTNode<T> search(T element) {
		return search(element, getRoot());
	}

	private BSTNode<T> search(T element, BSTNode<T> root2) {
		
		BSTNode<T> found = new BSTNode<>();
		
		if(element != null && !(root2.isEmpty())) {
		
			if(element.compareTo(root2.getData()) < 0) {
				found = search(element, (BSTNode<T>) root2.getLeft());
				
			} else if(element.compareTo(root2.getData()) > 0){
				found = search(element, (BSTNode<T>) root2.getRight());
				
			} else {
				found = root2;
			}
		}
		return found;
	}

	@Override
	public void insert(T element) {
		if(element != null && search(element) == null) {
			insert(element, getRoot());
		}
	}

	private void insert(T element, BSTNode<T> root2) {
		
		if(root2.isEmpty()) {
			root2.setData(element);
			root2.setLeft(new BTNode<>());
			root2.setRight(new BTNode<>());
			root2.getLeft().setParent(root2);
			root2.getRight().setParent(root2);
			
		} else {
			
			if(root2.getData().compareTo(element) > 0) {
				insert(element, (BSTNode<T>) root2.getLeft());
				
			} else {
				insert(element, (BSTNode<T>) root2.getRight());
			}
		}
	}

	@Override
	public BSTNode<T> maximum() {
		
		BSTNode<T> maximum = null;
		
		if(!(isEmpty())) {
			maximum = maximum(getRoot());
		}
		return maximum;
	}

	private BSTNode<T> maximum(BSTNode<T> root2) {
		
		BSTNode<T> maximum = root2;
		
		if(!(root2.getRight().isEmpty())) {
			maximum = maximum((BSTNode<T>) root2.getRight());
		}
		
		return maximum;
	}

	@Override
	public BSTNode<T> minimum() {
		
		BSTNode<T> minimum = null;
		
		if(!(isEmpty())) {
			minimum = minimum(getRoot());
		}
		
		return minimum;
	}

	private BSTNode<T> minimum(BSTNode<T> root2) {
		
		BSTNode<T> minimum = root2;
		
		if(!(root.getLeft().isEmpty())) {
			minimum = minimum((BSTNode<T>) root2.getLeft());
		}
		return minimum;
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		
		BSTNode<T> sucessor = null;
		BSTNode<T> node = search(element);
		
		if(!(node.isEmpty())) {
			
			if(!(node.getRight().isEmpty())) {
				sucessor = minimum((BSTNode<T>) node.getRight());
			
			} else {
				sucessor = sucessor(node);
			}
		}
		return sucessor;
	}

	private BSTNode<T> sucessor(BTNode<T> root2) {
		
		BSTNode<T> sucessor = (BSTNode<T>) root2.getParent();
		
		if(!(sucessor.isEmpty()) && !(root2.getParent().isEmpty()) && !(sucessor.getRight().equals(root2))) {
			sucessor = sucessor((BSTNode<T>) root2.getParent());
		}

		return sucessor;
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		
		BSTNode<T> predecessor = null;
		BSTNode<T> node = search(element);
		
		if(!(node.isEmpty())) {
			if(!(node.getLeft().isEmpty())) {
				predecessor = maximum((BSTNode<T>) node.getLeft());
			
			} else {
				predecessor = predecessor(node);
			}
		}
		return predecessor;
	}

	private BSTNode<T> predecessor(BSTNode<T> root2) {
		
		BSTNode<T> predecessor = (BSTNode<T>) root2.getParent();
		
		if(!(root2.getParent().isEmpty()) && !(predecessor.isEmpty()) && !(root2.equals(predecessor.getLeft()))){
			predecessor = predecessor((BSTNode<T>) root2.getParent());
		}
		
		return predecessor;
	}

	@Override
	public void remove(T element) {
		
		BSTNode<T> node = search(element);
		
		remove(node);
	}
	
	private void remove(BSTNode<T> node) {
		if(!(node.isEmpty()) && node != null) {
			
			if(node.isLeaf())
				if(node.equals(node.getParent().getLeft())) {
					node.getParent().setLeft(new BTNode<>());
			
				} else if(node.equals(node.getParent().getRight())) {
					node.getParent().setRight(new BTNode<>());
			
					
			} else if (!(node.getLeft().isEmpty()) && !(node.getRight().isEmpty())) {
				
				BSTNode<T> sucessor = sucessor(node.getData());
				node.setData(sucessor.getData());
				remove(sucessor);
					
			} else {
					
				if (!(node.getParent().isEmpty())) {
					
					if(node.getLeft().isEmpty() && !(node.getRight().isEmpty())) {
						node.getParent().setRight(node.getRight());
						node.getRight().setParent(node.getParent());
					
					} else if(node.getRight().isEmpty() && !(node.getLeft().isEmpty())) {
						node.getParent().setLeft(node.getLeft());
						node.getLeft().setParent(node.getParent());
					}
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] preOrder() {
		
		ArrayList<T> preOrder = new ArrayList<>();
		
		preOrder(preOrder, this.root);

		return (T[]) preOrder.toArray(new Comparable[preOrder.size()]);
	}

	private void preOrder(ArrayList<T> preOrder, BSTNode<T> root2) {
		if(!(root2.isEmpty())) {
			preOrder.add(root2.getData());
			preOrder(preOrder, (BSTNode<T>) root2.getLeft());
			preOrder(preOrder, (BSTNode<T>) root2.getRight());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] order() {
		
		ArrayList<T> order = new ArrayList<>();
		
		order(order, this.root);

		return (T[]) order.toArray(new Comparable[order.size()]);
	}

	private void order(ArrayList<T> order, BSTNode<T> root2) {
		if(!(root2.isEmpty())) {
			order(order, (BSTNode<T>) root2.getLeft());
			order.add(root2.getData());
			order(order, (BSTNode<T>) root2.getRight());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] postOrder() {
		
		ArrayList<T> posOrder = new ArrayList<>();
		
		posOrder(posOrder, this.root);

		return (T[]) posOrder.toArray(new Comparable[posOrder.size()]);
	}

	private void posOrder(ArrayList<T> posOrder, BSTNode<T> root2) {
		if(!(root2.isEmpty())) {
			posOrder(posOrder, (BSTNode<T>) root2.getLeft());
			posOrder(posOrder, (BSTNode<T>) root2.getRight());
			posOrder.add(root2.getData());
		}
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
