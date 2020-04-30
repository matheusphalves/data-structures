package dynamics;

import interfaces.BinaryTreeInterface;

public class BinaryTree<T> implements BinaryTreeInterface<T>{

	private TreeNode root;
	private int size;
	
	@Override
	public void add(T info) {
		
		if(root==null) {
			root = new TreeNode<T>(info);
			size++;
		}else {
			TreeNode aux = this.root;
			while(aux!=null) {//binary query!
				if(aux.compareTo(info)>0) {
					if(aux.getLeft()==null) {
						aux.setLeft(new TreeNode<>(info));
						break;
					}
					aux = aux.getLeft();
				}else if(aux.compareTo(info)<0) {
					if(aux.getRight()==null) {
						aux.setRight(new TreeNode<>(info));
						break;
					}
					aux = aux.getRight();
				}else
					break;//valor já adicionado!
			}
			size++;
		}	
	}

	@Override
	public void remove(T info) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int size(T info) {
		return this.size;
		
	}

	@Override
	public void nodeDepth(T info) {
		// TODO Auto-generated method stub
	}

	@Override
	public int getLevel(T info) {
		return this.getLevelAux(root,info, 0);
	}
	
	public String getElementsByLevel() {
		int counter = this.size;
		String r = "";
		while(counter>0) {
			SimpleLinkedList<T> aux = this.getElementByLevel(counter);
			r+= aux!=null? "Level " + counter + " ->" +  aux.print()+ "\n":"";
			counter--;
		}
		return r;
	}
	
	public SimpleLinkedList<T> getElementByLevel(int level) {
		SimpleLinkedList<T> aux = this.getAllElements(root, new SimpleLinkedList<T>());
		SimpleLinkedList<T> r=null;
		if (aux!=null){
			r = new SimpleLinkedList<T>();
			int index = aux.size();
			while(index>0) {
				T element = aux.getItem(index);
				int levelValue = this.getLevel(element);
				if(levelValue==level)
					r.add(element);
				
				aux.remove(element);
				index--;
			}
		}	
		return r;
	}
	
	
	public int getLevelAux(TreeNode node, T info, int index) {
		int r = -1;	
		if(node!=null) {
			if(node.compareTo(info)==0)
				return index;
			else if(node.compareTo(info)>0) {
				r = this.getLevelAux(node.getLeft(), info, index+1);
			}else {
				r = this.getLevelAux(node.getRight(), info, index+1);
			}
		}	
		return r;	
	}
	
	public TreeNode getNode(TreeNode node, T info) {
		TreeNode r = null;	
		if(node!=null) {
			if(node.compareTo(info)==0)
				return node;
			else if(node.compareTo(info)>0) {
				r = this.getNode(node.getLeft(), info);
			}else {
				r = this.getNode(node.getRight(), info);
			}
		}	
		return r;	
	}
	
	
	public SimpleLinkedList<T> getAllElements(TreeNode node, SimpleLinkedList<T> list) {
		if(node!=null) {
				list.add((T) node.getInfo());
				this.getAllElements(node.getLeft(), list);
				this.getAllElements(node.getRight(), list);
		}
		return list.size()!=0? list:null;			
	}
	

	public int heightNode(T info) {
		return this.heightNodeAux(getNode(root, info))-1;
	}
	
	public int heightNodeAux(TreeNode node) {
		int var = 0;
		if(node!=null) {
				int a = heightNodeAux(node.getLeft()) + 1;
				int b = heightNodeAux(node.getRight()) + 1;
				var =  a>b? a:b;
		}
		return var; //sheet!
	}

	@Override
	public boolean isBalanceated() {
		
		
		
		return false;
	}
	
	//PRINT METHODS and main method
	
	public String inOrder(TreeNode root) {
		String r = "";
		if(root!=null)
			r = inOrder(root.getLeft()) + " > " + root.getInfo().toString() + " > " + inOrder(root.getRight());
		return r;
	}
	
	public String preOrder(TreeNode root) {
		String r = "";
		if(root!=null)
			r = root.getInfo().toString() + " > "   + inOrder(root.getLeft())+ " > " + inOrder(root.getRight());;
		return r;
	}
	
	public String postOrder(TreeNode root) {
		String r = "";
		if(root!=null)
			r = inOrder(root.getLeft()) + " > " + inOrder(root.getRight()) + " > " + root.getInfo().toString() ;
		return r;
	}
	
	public static void main(String[] args) {
		BinaryTree<Integer> test = new BinaryTree<>();
		
		test.add(12);
		test.add(20);
		test.add(6);
		test.add(14);
		test.add(8);
		test.add(5);
		test.add(-2);
		
		
		System.out.println(test.inOrder(test.root));
		
		System.out.println(test.getElementsByLevel());
		System.out.println(test.heightNode(30));
	}

}
