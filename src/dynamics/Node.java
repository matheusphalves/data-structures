package dynamics;


public class Node<T> implements Comparable<T>{
	
	private T info; //informação a ser armazenada
	private Node<T> next; //ponteiro para o próximo nó
	public T getInfo() {
		return info;
	}
	
	
	public Node(T info) {
		super();
		this.info = info;
	}



	public void setInfo(T info) {
		this.info = info;
	}
	public Node<T> getNext() {
		return next;
	}
	public void setNext(Node<T> next) {
		this.next = next;
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
