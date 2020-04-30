package interfaces;

public interface StackInterface<T> {
	
	public abstract void push(T info);
	public abstract T pop();
	public abstract int size();
	public abstract String print();

}
