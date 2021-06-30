package com.abe.data.structures;

public class LinkedList {

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	Node head = null;
	private int size = 0;

	public void add(int data) {
		Node n = new Node(data);
		Node temp = head;
		if(head == null) {
			head = n;
			size++;
			return;
		}

		while(temp != null) {
			if(temp.next == null) {
				temp.next = n;
				return;
			}
			temp = temp.next;
			size++;
		}
	}

	public void add(int index, int data) {
		if(index >= size || index < 0) {
			System.out.println("Sorry, this is not a valid index");
			return;
		}
		Node n = new Node(data);
		Node temp = head;

		if(index == 0) {
			n.next = head;
			head = n;
		}

		for(int i = 1; i < index; i++) {
			temp = temp.next;
		}
		n.next = temp.next;
		temp.next = n;
		size++;

	}

	public void addAtBeginning(int data) {
		Node n = new Node(data);
		if(head == null) {
			head = n;
		}
		else {
			n.next = head;
			head = n;
		}
		size++;
	}

	public void removeFirstOccurrence(int data) {

		if(head == null) {
			System.out.println("Received a request to remove " + data + " from the list, but the list is empty");
			return;
		}
		if(head.data == data) {
			head = head.next;
			size--;
			return;
		}
		
		Node temp = head;
		while(temp.next != null) {
			if(temp.next.data == data) {
				temp.next = temp.next.next;
				size--;
				return;
			}
			temp = temp.next;	
		}
		System.out.println("Received a request to remove " + data + " from the list, but it was not found");
	}

	public void removeAtEnd() {
		if(size == 1) {
			head = null;
		}

		if(size > 1) {
			Node temp = head;
			while (temp.next != null) {
				if(temp.next.next == null) {
					temp.next = null;
					return;
				}
				temp = temp.next;
			}
		}
		size--;
	}

	public void removeAtIndex(int index) {
		if(index >= size || index < 0) {
			System.out.println("Sorry, this is not a valid index");
			return;
		}
		Node temp = head;

		for(int i = 1; i < index; i++) {
			temp = temp.next;
		}
		temp.next = temp.next.next;

	}

	public void removeAtBeginning() {
		if(size == 1) {
			head = null;
		}
		if(size > 1) {
			head = head.next;
		}
	}

	public void removeAll() {
		head = null;
	}

	public void replaceAtIndex(int index, int data) {
		if(index >= size || index < 0) {
			System.out.println("Sorry, this is not a valid index");
			return;
		}
		Node temp = head;
		for(int i = 0; i < index; i++) {
			temp = temp.next;
		}
		temp.data = data;
	}

	public void replaceAll(int data) {
		Node temp = head;
		for(int i = 0; i < size; i++) {
			temp.data = data;
			temp = temp.next;
		}

	}

	public boolean exists(int num) {
		Node temp = head;
		while(temp.next != null) {
			if(temp.data == num) {
				return true;
			}
			temp = temp.next;
		}
		return false;
	}

	public int firstIndexOf(int num) {
		Node temp = head;
		for(int i = 0; i < size - 1; i++) {
			if(temp.data == num) {
				return i;
			}
			temp = temp.next;
		}
		return -1;
	}

	public int lastIndexOf(int num) {
		Node temp = head;
		int index = -1;
		for(int i = 0; i < size - 1; i++) {
			if(temp.data == num) {
				index = i;
			}
			temp = temp.next;
		}
		return index;
	}

	public void print() {
		if(head == null) {
			System.out.println("This linked list is empty");
			return;
		}

		Node temp = head;
		do {
			System.out.println(temp.data);
			temp = temp.next;
		} while (temp != null);
	}

	public int size() {
		return size;
	}

	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		linkedList.print();
	}
}
