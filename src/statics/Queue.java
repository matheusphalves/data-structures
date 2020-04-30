package statics;

import interfaces.QueueInterface;

public class Queue<T> implements QueueInterface<T> {

	private T[] queue;
	private int size;
	
	public Queue() {
		this.queue = (T[]) new Object[5];
	}
	
	public T[] resize() {
		
		T[] temp =((T[])new Object[(int) (size*1.4)]);
		
		for(int i=0; i<size; i++)
			temp[i] = this.queue[i];
		
		this.queue = temp;
		return queue;
	}
	
	@Override
	public void enqueue(T info) {
		
		if(this.size<this.queue.length) {
			this.queue[size] = info;
			this.size++;
		}else {
			this.resize();
			enqueue(info);
		}
		
	}

	@Override
	public T dequeue() {
		
		T r = null;
		
		if(this.queue[0]!=null) {
		
			r = this.queue[0];	
			for(int i=0; i<size; i++) {
				if(i+1<size) {
					T temp = this.queue[i+1];
					this.queue[i] = temp;
				}
			}
			size--;
		}	
		return r;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public String print() {
		String r = "";
		for(int i=0; i<this.size; i++)
			r += this.queue[i] + " -> ";
		
		return r;
	}
	
	public static void main(String[] args) {
		Queue<Integer> temp = new Queue<>();
		
		temp.enqueue(1);
		temp.enqueue(2);
		temp.enqueue(3);
		temp.enqueue(40);
		temp.enqueue(-2);
		temp.enqueue(-1);
		
		System.out.println(temp.print());
		
		System.out.println(temp.dequeue());
		System.out.println(temp.dequeue());
		//System.out.println(temp.dequeue());
		
		System.out.println(temp.print());
	}

}
