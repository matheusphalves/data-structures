package dynamics;

public class TreeNode<T> implements Comparable<T> {

	private T info;
	private TreeNode<T> left;
	private TreeNode<T> right;
	
	public TreeNode(T info) {
		this.info = info;
	}
	
	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	public TreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(TreeNode<T> left) {
		this.left = left;
	}

	public TreeNode<T> getRight() {
		return right;
	}

	public void setRight(TreeNode<T> right) {
		this.right = right;
	}


	@Override
	public int compareTo(T arg0) {
		// retorna -1 se info é menor, 1 se info é maior e 0 se info é igual
		int r = -1;
		if(arg0 instanceof Comparable)
			r = ((Comparable) info).compareTo(arg0);
		
		return r;
	}
	
}
