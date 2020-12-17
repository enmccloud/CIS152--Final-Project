/**
 * Node Class
 * 
 * @author Nikki McCloud
 * @version 1.0
 */
package HighScore;

public class Node<T extends Comparable<T>> {
	
	// Declaring Node Variables
	private Node<T> next;
	private T data;

	/**
	 * Default No Argument Constructor
	 */
	public Node() {
	}

	/**
	 * Parameterized Constructor
	 * 
	 * @param data
	 */
	public Node(T data) {
		this(data, null);
	}

	/**
	 * Parameterized Constructor
	 * 
	 * @param next
	 * @param data
	 */
	public Node(T data, Node<T> next) {
		this.next = next;
		this.data = data;
	}

	/**
	 * Getter for data
	 * 
	 * @return data
	 */
	public T getData() {
		return data;
	}

	/**
	 * Setter for data
	 * 
	 * @param data
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * Getter for next
	 * 
	 * @return next
	 */
	public Node<T> getNext() {
		return next;
	}

	/**
	 * Setter for next
	 * 
	 * @param next
	 */
	public void setNext(Node<T> next) {
		this.next = next;
	}

	/**
	 * Compare To Method
	 * 
	 * @param newData
	 * @return compares data
	 */
	public int compareTo(Node<T> newData) {
		T dataA = this.data;
		T dataB = newData.getData();
		return dataA.compareTo(dataB);
	}

	/**
	 * To String Method
	 * 
	 * @return dataString
	 */
	public String toString() {
		String dataString = data.toString();
		if (next != null) {
			T nextData = next.getData();
			dataString += "--> " + nextData.toString();
		}
		return dataString;
	}
}