package interfaces;

import dynamics.TreeNode;

public interface BinaryTreeInterface<T> {
	
	public abstract void add(T info);
	public abstract void remove(T info);
	public abstract int size(T info);

	public abstract void nodeDepth(T info);
	public abstract int getLevel(T info);
	
	public abstract boolean isBalanceated();
}
