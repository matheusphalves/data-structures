package dynamics;

import interfaces.LinkedListInterface;

public class SimpleLinkedList<T> implements LinkedListInterface<T> {
	
	private int size;
	private Node<T> first;
	@Override
	public void add(T info) {
		
		if(first==null) {
			first = new Node(info);
		}else {
			Node<T> aux = new Node(info);	
			aux.setNext(first);
			first = aux;
		}		
		size++;
	}
	@Override
	public void remove(T info) {
		
		if(this.getIndexOf(info)!=-1) {// not necessary! 
			
			if(first.getInfo().equals(info)) {
				first = first.getNext();
			}else {
				Node<T> aux = first;
				while(aux.getNext()!=null) {
					
					if(aux.getNext().getInfo().equals(info)) {
						aux.setNext(aux.getNext().getNext());
						break;
					}
					aux = aux.getNext();
				}	
			}	
			size--;
		}		
	}
	@Override
	public int size() {
		return size;
	}
	@Override
	public String print() {
		String value = "";
		Node<T> aux = first;
		
		while(aux!=null) {
			value += aux.getInfo() + " -> ";
			aux = aux.getNext();
		}
		value += "null";
		return value;
	}
	@Override
	public T getItem(int index) {

		Node<T> aux = first;
		int counter = 0;
		
		while(aux!=null&&index>=0) {
			if(counter==index)
				return aux.getInfo();
			counter++;
			aux = aux.getNext();
		}
		return null;
	}
	@Override
	public int getIndexOf(T info) {
		
		int counter = 0;
		int result = -1;
		Node<T> aux = first;
		
		while(aux!=null) {
			if(aux.getInfo().equals(info)) {
				result = counter;
				break;
			}
			counter++;	
			aux = aux.getNext();
		}
		return result;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public Node<T> getFirst() {
		return first;
	}
	public void setFirst(Node<T> first) {
		this.first = first;
	}
	
	
}
