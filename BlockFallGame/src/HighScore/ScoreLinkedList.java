/**
 * Score Linked List Class
 * 
 * @author Nikki McCloud
 * @version 1.0
 */
package HighScore;

public class ScoreLinkedList<T extends Comparable<T>> {

	// Linked List Variables
	private Node<T> head;

	/**
	 * Default No Argument Constructor
	 */
	public ScoreLinkedList() {
		head = null;
	}

	/**
	 * Getter for head
	 * 
	 * @return head
	 */
	public Node<T> getHead() {
		return head;
	}

	/**
	 * Setter for head
	 * 
	 * @param head
	 */
	public void setHead(Node<T> head) {
		this.head = head;
	}

	/**
	 * Insert Head Method
	 * 
	 * @param newData
	 * 
	 * @return add data to the head of linked list.
	 */
	public void insertHead(T newData) {
		Node<T> toInsert = new Node<>(newData);

		if (head == null) {
			head = toInsert;
			return;
		}
		Node<T> cur = head;
		while (cur.getNext() != null) {
			cur = cur.getNext();
		}
		cur.setNext(toInsert);
	}

	/**
	 * Reverse Order Method
	 * 
	 * @param newData
	 * 
	 * @return add data in reverse order
	 */
	public void reverseOrder(T newData) {
		if (checkDataValues(newData)) {
			return;
		}
		Node<T> data = new Node<>(newData);
		Node<T> currentData = head;

		while (currentData.getNext() != null && currentData.getNext().compareTo(data) > 0) {
			currentData = currentData.getNext();
		}
		insertNewNode(data, currentData);
	}

	/**
	 * Check Data Values Method
	 * 
	 * @param newData
	 * 
	 * @return check if list has values if not add data, if so add data to front of
	 *         list.
	 */
	private boolean checkDataValues(T newData) {
		if (head == null) {
			this.insertHead(newData);
			return true;
		}
		Node<T> addData = new Node<>(newData);
		if (addData.compareTo(head) > 0) {
			addData.setNext(head);
			head = addData;
			return true;
		}
		return false;

	}

	/**
	 * Insert Node Method
	 * 
	 * @param storedData
	 * @param newData
	 * 
	 * @return adds node to the list
	 */
	public void insertNode(T newData, T storedData) {
		Node<T> currentData = head;
		boolean isMatch = currentData.getData().equals(storedData);

		while (currentData != null && !isMatch) {
			currentData = currentData.getNext();
			isMatch = currentData.getData().equals(storedData);

		}
		if (currentData == null) {
			throw new IllegalArgumentException("Data not found in linked List!");
		}
		Node<T> newNode = new Node<T>(newData);
		insertNewNode(newNode, currentData);
	}

	/**
	 * Insert New Node Method
	 * 
	 * @param newNode
	 * @param currentData
	 */
	private void insertNewNode(Node<T> newNode, Node<T> currentData) {
		Node<T> tempNode = currentData.getNext();
		currentData.setNext(newNode);
		newNode.setNext(tempNode);

	}

	/**
	 * To String Method
	 * 
	 * @return linked list in rows
	 */
	public String toString() {
		return toString("--> ");
	}

	/**
	 * To String Method Expanded
	 * 
	 * @param separateData
	 * @return prints separated linked list
	 */
	public String toString(String separateData) {
		String output = "";
		Node<T> currentData = head;
		// If the current is null, return
		if (currentData == null) {
			return output;
		}
		output += currentData.getData();
		while (currentData.getNext() != null) {
			output += separateData;
			currentData = currentData.getNext();
			output += currentData.getData();

		}
		return output;

	}
}
