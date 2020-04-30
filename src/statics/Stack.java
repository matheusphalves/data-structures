package statics;

import interfaces.StackInterface;

public class Stack<T> implements StackInterface<T> {

	private T[] stack;
	private int size;
	
	
	public Stack() {
		this.stack = (T[]) new Object[5];
	}
	
	public T[] resize() {
		
		T[] temp =((T[])new Object[(int) (size*1.4)]);
		
		for(int i=0; i<size; i++)
			temp[i] = this.stack[i];
		
		this.stack = temp;
		return stack;
	}
	
	@Override
	public void push(T info) {
		
		if(this.stack[0]==null)
			this.stack[0] = info;
		
		else if(this.size<this.stack.length) {
			T temp;	
			for(int i=size-1; i>=0; i--) {
					temp = this.stack[i];
					this.stack[i+1] = temp;
			}
			stack[0] = info;
			
		}else {
			resize();
			push(info);
		}
		size++;
	}

	@Override
	public T pop() {
		T r = null;
		
		if(this.stack[0]!=null) {
		
			r = this.stack[0];	
			for(int i=0; i<size; i++) {
				if(i+1<size) {
					T temp = this.stack[i+1];
					this.stack[i] = temp;
				}
			}
			size--;
		}else
			size=0;
		return r;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}

	@Override
	public String print() {
		String r = "";
		for(int i=0; i<this.size; i++)
			r += this.stack[i] + " -> ";
		return r;
	}
	
	public static void main(String[] args) {
		Stack<Integer> temp = new Stack();
		temp.push(1);
		temp.push(2);
		temp.push(3);
		temp.push(40);
		temp.push(45);
		temp.push(321);
		temp.push(-2);
		
		System.out.println(temp.pop());
		System.out.println(temp.pop());
		System.out.println(temp.pop());
		System.out.println(temp.pop());
		System.out.println(temp.pop());
		System.out.println(temp.pop());
		System.out.println(temp.pop());
		System.out.println(temp.pop());
		
		System.out.println(temp.print());
	
	}

}
