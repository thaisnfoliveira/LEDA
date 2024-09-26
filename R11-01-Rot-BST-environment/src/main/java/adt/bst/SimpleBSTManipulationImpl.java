package adt.bst;

/**
 * - Esta eh a unica classe que pode ser modificada 
 * @author adalbertocajueiro
 *
 * @param <T>
 */
public class SimpleBSTManipulationImpl<T extends Comparable<T>> implements SimpleBSTManipulation<T> {

	@Override
	public boolean equals(BST<T> tree1, BST<T> tree2) {
		boolean result = false;
		if(!tree1.isEmpty() && !tree2.isEmpty()){
			result = equalsRecursive((BSTNode<T>) tree1.getRoot(), (BSTNode<T>) tree2.getRoot());
		}
		return result;
	}

	private boolean equalsRecursive(BSTNode<T> node1, BSTNode<T> node2){
		
	}

	@Override
	public boolean isSimilar(BST<T> tree1, BST<T> tree2) {
		// TODO Implement this method
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T orderStatistic(BST<T> tree, int k) {
		// TODO Implement this method
		throw new UnsupportedOperationException("Not implemented yet!");
	}

}
