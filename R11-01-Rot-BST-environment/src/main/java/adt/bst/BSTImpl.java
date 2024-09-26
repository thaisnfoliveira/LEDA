package adt.bst;

import java.util.ArrayList;

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
		return this.height(this.root);
	}
	
	private int height(BSTNode<T> node) {
		int height = -1;
		if (!node.isEmpty()) {
			height = 1 + Math.max(this.height((BSTNode<T>) node.getLeft()), this.height((BSTNode<T>) node.getRight()));
		}
		return height;
	
	}

	@Override
	public BSTNode<T> search(T element) {
		return search2(getRoot(), element);
	}

	private BSTNode<T> search2(BSTNode<T> node, T element){
		BSTNode<T> result = null;
		if(node.isEmpty() || node.getData().equals(element)){
			result = node;
		} else if (node.getData().compareTo(element) > 0){
			result =  search2((BSTNode<T>)node.getLeft(), element);
		} else {
			result =  search2((BSTNode<T>) node.getRight(), element);
		}
		return result;
	}

	@Override
	public void insert(T element) {
		if(element != null && search(element).isEmpty()){
			insertRecursive(this.getRoot(), element);
		}
	}

	private void insertRecursive(BSTNode<T> node, T element){
		// caso base: nó vazio -> inserimos o novo dado (sempre em um NIL)
		if(node.isEmpty()){
			node.setData(element);
			node.setLeft(new BSTNode<>());
			node.setRight(new BSTNode<>());
			node.getLeft().setParent(node);
			node.getRight().setParent(node);
		
		//caso indutivo: nó não vazio: insere no filho da esquerda ou no filho da direita
		} else {
			if(node.getData().compareTo(element) > 0){
				insertRecursive((BSTNode<T>)node.getLeft(), element);
			} else if(node.getData().compareTo(element)<0){
				insertRecursive((BSTNode<T>)node.getRight(), element);
			}
		}	
	}

	@Override
	public BSTNode<T> maximum() {
		BSTNode<T> result = null;
		if(!this.isEmpty()){
			result = this.maximumRecursive(this.getRoot());
		}
		return result;
	}

	private BSTNode<T> maximumRecursive(BSTNode<T> node){
		BSTNode<T> result = node;

		if(!node.getRight().isEmpty()){
			result = maximumRecursive((BSTNode<T>)node.getRight());
		}
		return result;
	}

	@Override
	public BSTNode<T> minimum() {
		BSTNode<T> result = null;
		if(!this.isEmpty()){
			result = this.minimumRecursive(this.getRoot());
		}
		return result;
	}

	private BSTNode<T> minimumRecursive(BSTNode<T> node){
		BSTNode<T> result = node;
		if(!node.getLeft().isEmpty()){
			result = minimumRecursive((BSTNode<T>)node.getLeft());
		}
		return result;
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> node = this.search(element);
		BSTNode<T> result = null;
		
		if(!node.isEmpty()){
			if(!node.getRight().isEmpty()){
				result = minimumRecursive((BSTNode<T>) node.getRight());
			} else {
				result = sucessorRecursive((BSTNode<T>) node, element);
			}
		}

		return result;
	}

	private BSTNode<T> sucessorRecursive(BSTNode<T> node, T element){
		BSTNode<T> result = (BSTNode<T>) node.getParent();

		if (node.getParent() != null && !result.isEmpty() && node.equals(result.getRight())) {
			result = this.sucessorRecursive((BSTNode<T>) node.getParent(), element);
		}

		return result;
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> node = this.search(element);
		BSTNode<T> result = null;

		if(!node.isEmpty()){
			if(!node.getLeft().isEmpty()){
				result = maximumRecursive((BSTNode<T>)node.getLeft());
			} else {
				result = predecessorRecursive((BSTNode<T>)node, element);
			}
		}

		return result;
	}

	private BSTNode<T> predecessorRecursive(BSTNode<T> node, T element){
		BSTNode<T> result = (BSTNode<T>) node.getParent();

		if (node.getParent() != null && !result.isEmpty() && node.equals(result.getLeft())) {
			result = this.predecessorRecursive((BSTNode<T>) node.getParent(), element);
		}
		return result;
	}

	@Override
	public void remove(T element) {
		BSTNode<T> node = search(element);
		removeRecursive(node);
	}

	private void removeRecursive(BSTNode<T> node) {
		if (node != null && !node.isEmpty()) {
			
			if (node.isLeaf()) {
				node.setData(null);

				
			} else if (hasOneChild(node)) {
				if (node.getParent() != null) {
					if (node.getParent().getData().compareTo(node.getData()) > 0) {
						if (!node.getLeft().isEmpty()) {
							node.getParent().setLeft(node.getLeft());
							node.getLeft().setParent(node.getParent());
						} else {
							node.getParent().setLeft(node.getRight());
							node.getRight().setParent(node.getParent());
						}
					} else {
						if (!node.getLeft().isEmpty()) {
							node.getParent().setRight(node.getLeft());
							node.getLeft().setParent(node.getParent());
						} else {
							node.getParent().setRight(node.getRight());
							node.getRight().setParent(node.getParent());
						}
					}
				} else {
					if (node.getLeft().isEmpty()) {
						root = (BSTNode<T>) node.getRight();
						root.setParent(null);
					} else {
						root = (BSTNode<T>) node.getLeft();
						root.setParent(null);
					}
				}

				
			} else {
				BSTNode<T> sucessor = sucessor(node.getData());
				node.setData(sucessor.getData());
				removeRecursive(sucessor);
			}
		}

	}
	

	private boolean hasOneChild(BSTNode<T> node){
		return (node.getLeft().isEmpty() && !node.getRight().isEmpty()) || (!node.getLeft().isEmpty() && node.getRight().isEmpty());
	}

	@Override
        public T[] preOrder() {
                ArrayList<T> lista = new ArrayList<>();
                preOrderRecursive(this.getRoot(), lista);
                return (T[]) lista.toArray(new Comparable[lista.size()]);

        }

	private void preOrderRecursive(BSTNode<T> node, ArrayList<T> lista){
		if(!node.isEmpty()){
			lista.add(node.getData());
			preOrderRecursive((BSTNode<T>)node.getLeft(), lista);
			preOrderRecursive((BSTNode<T>)node.getRight(), lista);
		}
		
	}

	@Override
	public T[] order() {
		ArrayList<T> lista = new ArrayList<>();
		orderRecursive(this.getRoot(), lista);
		return (T[]) lista.toArray(new Comparable[lista.size()]);
	}

	private void orderRecursive(BSTNode<T> node, ArrayList<T> lista){
		if (node != null && !node.isEmpty()) {
			orderRecursive((BSTNode<T>) node.getLeft(), lista);
			lista.add(node.getData());
			orderRecursive((BSTNode<T>) node.getRight(), lista);
		}
	}

	@Override
	public T[] postOrder() {
		ArrayList<T> lista = new ArrayList<>();
        postOrderRecursive(this.getRoot(), lista);
        return (T[]) lista.toArray(new Comparable[lista.size()]);
	}

	private void postOrderRecursive(BSTNode<T> node, ArrayList<T> lista){
		if(!node.isEmpty()){
			preOrderRecursive((BSTNode<T>)node.getLeft(), lista);
			lista.add(node.getData());
			preOrderRecursive((BSTNode<T>)node.getRight(), lista);
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
