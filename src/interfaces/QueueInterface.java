package interfaces;

public interface QueueInterface<T> {
	
	public abstract void enqueue(T info);
	public abstract T dequeue();
	public abstract int size();
	public abstract String print();
	
	
	

}
