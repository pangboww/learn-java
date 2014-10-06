package piles;

public interface Pile {
	public abstract boolean empty();
	public abstract boolean full();
	public abstract Object peek();
	public abstract Object pop();
	public abstract boolean push(Object o);
	public abstract int search(Object o);
	public abstract String toString();
}
