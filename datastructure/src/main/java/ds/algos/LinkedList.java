package ds.algos;

import java.util.NoSuchElementException;

public class LinkedList {
	private class Node {
		private int value;
		private Node next;

		public Node(int value) {
			this.value = value;
		}
	}

	private Node first;
	private Node last;

	public void addLast(int item) {
		var node = new Node(item);
		if (isEmpty()) {
			first = last = node;
		} else {
			last.next = node;
			last = node;
		}
	}
	
	public void addFirst(int item)
	{
		var node = new Node(item);
		if(isEmpty()) {
			first=last=node;
		}else {
			node.next = first;
			first = node;
		}
		
	}
	public int indexOf(int item) {
		int index = 0;
		var current = first;
		while(current !=null) {
			if(current.value == item) return index;
			current = current.next;
			index++;
		}
		return -1;
	}
	
	public boolean contains(int item)
	{
//		var current = first;
//		while(current !=null)
//		{
//			if(current.value==item) return true;
//			current = current.next;
//		}
		return indexOf(item) != -1;
	}
	
	public void removeFirst() {
		
		if(isEmpty())
			throw new NoSuchElementException();
		
		if(first == last)
		{
			first = last = null;
			return;
		}
		var second = first.next;
		first.next = null;
		first = second;
	}
	
	public void removeLast() {
		
		if(isEmpty())
			throw new NoSuchElementException();
		
		if(first == last)
		{
			first = last = null;
			return;
		}
		
		var current = first;
		while(current !=null)
		{
			if(current.next == last)break;
			current = current.next;
		}
		
		last = current;
		last.next = null;
	}
	
	private boolean isEmpty() {
		return first == null;
	}
	
	public static void main(String[] args)
	{
		var list = new LinkedList();
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		list.removeFirst();

		System.out.println(list.indexOf(20));
		System.out.println(list.contains(10));
		
	}

}
