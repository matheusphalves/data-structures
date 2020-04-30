package dynamics;

import interfaces.QueueInterface;

public class Queue<T> implements QueueInterface<T> {
	
	private Node<T> head;
	private int size;

	@Override
	public void enqueue(T info) {
		
		if(head==null)
			head = new Node(info);
		else {
			Node<T> aux = head;
			
			while(aux.getNext()!=null)
				aux = aux.getNext();	
			aux.setNext(new Node(info));
		}
		size++;
	}

	@Override
	public T dequeue() {
		
		T result = null;
		if(head!=null) {
			result = head.getInfo();
			this.head = head.getNext();
			size--;
		}	
		return result;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public String print() {
		Node<T> aux = head;
		String result ="Head -> ";
		while(aux!=null) {
			result+= aux.getInfo() + " -> "; 
			aux = aux.getNext();
		}
		return result + "<- End";
	}
	
	public static void main(String[] args) {
		Queue<Integer> test = new Queue<>();
		
		test.enqueue(1);
		test.enqueue(2);
		test.enqueue(3);
		
		System.out.println(test.print());
		
		System.out.println(test.dequeue());
		System.out.println(test.print());
		test.enqueue(34);
		System.out.println(test.dequeue());
		System.out.println(test.dequeue());
		System.out.println(test.dequeue());
		System.out.println(test.dequeue());
		test.enqueue(29);
		test.enqueue(54);
		System.out.println(test.print());
		
	}
	
}
