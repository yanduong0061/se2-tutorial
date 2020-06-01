package hackerrank_03;
public class Stack {
	private int maxSize;
	private String[] array;
	private int top;
	public Stack(int s) {
		this.maxSize= s;
		array = new String[maxSize];
		top = -1;
	}
	public void push(String newItem) {
		array[++top] = newItem;
	}
	public String pop() {	
		return array[top--];
	}
	public String peek() {
		return array[top];	
	}
	public boolean isEmpty() {
		return top == -1;
	}
	public boolean isFull() {
		return top == maxSize - 1;
	}
	public int size() {
		return top + 1;
	}
	
	
	
}
	
	

		

