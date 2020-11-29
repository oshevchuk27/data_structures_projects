package polling.treesheaps;

/**
 * Interface for BinaryTrees.
 * @param <E> the type of data in the tree
 */
public interface BinaryTree<E extends Comparable<E>> {
	
	LinkedBinaryTree<E> getRight();
	
	boolean isLeaf();
	
	int height();

	void insert(E element);
	
	E getRootElement();
	
	int size();
	
	boolean isEmpty();
	
	String toStringInOrder();
	
	String toStringPreOrder();
	
	String toStringPostOrder();	
}
