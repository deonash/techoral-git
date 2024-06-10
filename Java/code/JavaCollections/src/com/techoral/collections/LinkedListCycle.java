package com.techoral.collections;

public class LinkedListCycle {

	static class Node {
		int val;
		Node next;

		public Node(int val) {
			this.val = val;
			this.next = null;
		}

	}

	static boolean hasCycle(Node head) {

		if (head == null || head.next == null) {
			return false;
		}

		Node slow = head;
		Node fast = head.next;

		while (slow != fast) {
			if ((fast == null) || (fast.next == null)) {
				return false;
			}
			slow = slow.next;
			fast = fast.next.next;

		}
		return true;
	}

	public static void main(String[] args) {
		Node head = new LinkedListCycle.Node(1);
		head.next = new LinkedListCycle.Node(2);
		head.next.next = new LinkedListCycle.Node(3);
		head.next.next.next = new LinkedListCycle.Node(4);
		head.next.next.next.next = new LinkedListCycle.Node(5);
		head.next.next.next.next.next = head.next.next;

		System.out.println("Cycle in LinkedList : " + hasCycle(head));

	}

}
