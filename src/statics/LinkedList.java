package statics;

import interfaces.LinkedListInterface;

public class LinkedList<T> implements LinkedListInterface<T> {

	private T[] list;
	private int size;
	
	public LinkedList() {
		list = ((T[])new Object[5]);
	}
	
	public T[] resize() {
		
		T[] temp =((T[])new Object[(int) (size*1.4)]);
		
		for(int i=0; i<size; i++)
			temp[i] = this.list[i];
		
		this.list = temp;
		return list;
	}

	@Override
	public void add(T info) {
		if(this.size<this.list.length) {
			this.list[size] = info;
			this.size++;
			
		}else {
			this.resize();
			add(info);
		}
	}

	@Override
	public void remove(T info) {
		
		int index = this.getIndexOf(info);	//obtenção do indice do elemento
		if(index!=-1) {
			this.list[index] = null;
			for(int i = index; i<this.size;i++) {//se ele existir, é sobrescrito com valores consecutivos			
					T temp = this.list[i+1];
					this.list[i] = temp;
			}
			this.size--;
		}
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public String print() {
		String r = "";	
		for(int i=0; i<this.size; i++) {//obtenho os valores de toda a lista
			r += this.list[i] + " -> ";
		}
		return r;
	}

	@Override
	public T getItem(int index) {	
		T temp = null;
		if(index<this.size)//retorno o valor do indice informado como parâmetro
			temp = this.list[index];
		
		return temp;
	}

	@Override
	public int getIndexOf(T info) {
		
		int index = -1;
		
		for(int i=0; i<this.size; i++) {
			if(info.equals(this.list[i])) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	public static void main(String[] args) {
		LinkedList<Integer> temp = new LinkedList<Integer>();
		
		temp.add(1);
		temp.add(2);
		temp.add(3);
		temp.add(23);
	
		System.out.println(temp.print());
		temp.remove(23);
		temp.remove(1);
		temp.remove(2);
		temp.remove(-2);
		System.out.println(temp.print());
	}
}
