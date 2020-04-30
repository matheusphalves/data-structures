package dynamics;

import interfaces.StackInterface;

public class Stack<T> implements StackInterface<T> {
	
	private Node<T> top;
	private int size;
	@Override
	public void push(T info) {
		
		if(top==null)
			top = new Node(info);
		else {
			Node<T> aux = new Node(info);
			aux.setNext(top);
			top = aux;	
		}
		size++;
		
	}
	@Override
	public T pop() {
		T aux = null;
		if(top!=null) {
			aux = top.getInfo();
			top = top.getNext();
			size--;
		}	
		return aux;
	}
	@Override
	public int size() {
		return size;
	}
	@Override
	public String print() {
		String r ="top -> ";
		Node<T> aux = top;
		
		while(aux!=null) {
			r += aux.getInfo() + " -> ";
			aux = aux.getNext();	
		}	
		return r + "null";
	}
	
	public static void main(String[] args) {
		Stack<Integer> teste = new Stack<>();
		
		teste.push(1);
		teste.push(2);
		teste.push(3);
		
		System.out.println(teste.print());
		System.out.println(teste.pop());
		System.out.println(teste.pop());
		System.out.println(teste.pop());
		System.out.println(teste.pop());
		System.out.println(teste.print());
		
	}
	
}
