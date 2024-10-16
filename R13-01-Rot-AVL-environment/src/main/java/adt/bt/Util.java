package adt.bt;

import adt.bst.BSTNode;

public class Util {


	/**
	 * A rotacao a esquerda em node deve subir e retornar seu filho a direita
	 * @param node
	 * @return - noh que se tornou a nova raiz
	 */
	public static <T extends Comparable<T>> BSTNode<T> leftRotation(BSTNode<T> node) {
		BSTNode<T> pivot = (BSTNode<T>) node.getRight();

		node.setRight(node.getParent());
		node.setParent(pivot);

		node.getRight().setParent(node);

		if(pivot.getParent() != null){
			if(pivot.getRight().getParent().equals(node)){
				pivot.getRight().setParent(pivot);
			}
			else{
				pivot.getLeft().setParent(pivot);
			}
		}

		return pivot;
	}

	/**
	 * A rotacao a direita em node deve subir e retornar seu filho a esquerda
	 * @param node
	 * @return noh que se tornou a nova raiz
	 */
	public static <T extends Comparable<T>> BSTNode<T> rightRotation(BSTNode<T> node) {
		//TODO Implemente sua rotacao a esquerda aqui
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	public static <T extends Comparable<T>> T[] makeArrayOfComparable(int size) {
		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Comparable[size];
		return array;
	}
}
