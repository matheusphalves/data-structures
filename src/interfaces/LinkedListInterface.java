package interfaces;

public interface LinkedListInterface<T> {
	
	public void add(T info);
	public void remove(T info);
	public int size();
	public String print();
	public T getItem(int index);
	public int getIndexOf(T info);
}
