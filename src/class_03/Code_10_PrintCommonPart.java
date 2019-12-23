package class_03;

import java.util.HashSet;

/**
 * 
 * 打印两个有序链表的公共部分
 *	【题目】 给定两个有序链表的头指针head1和head2，打印两个链表的公共部分。
 * @author Administrator
 *
 */
public class Code_10_PrintCommonPart {

	public static class Node {
		public int value;
		public Node next;
		public Node(int data) {
			this.value = data;
		}
	}

	public static void printCommonPart(Node head1, Node head2) {
		System.out.print("Common Part: ");
		while (head1 != null && head2 != null) {
			if (head1.value < head2.value) {
				head1 = head1.next;
			} else if (head1.value > head2.value) {
				head2 = head2.next;
			} else {
				System.out.print(head1.value + " ");
				head1 = head1.next;
				head2 = head2.next;
			}
		}
		System.out.println();
	}

	public static void printLinkedList(Node node) {
		System.out.print("Linked List: ");
		while (node != null) {
			System.out.print(node.value + " ");
			node = node.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Node node1 = new Node(2);
		node1.next = new Node(3);
		node1.next.next = new Node(5);
		node1.next.next.next = new Node(6);

		Node node2 = new Node(1);
		node2.next = new Node(2);
		node2.next.next = new Node(5);
		node2.next.next.next = new Node(7);
		node2.next.next.next.next = new Node(8);

		printLinkedList(node1);
		printLinkedList(node2);
		printCommonPart(node1, node2);

	}
	
	//=====================================================
	public class ListNode {
		int val;
		ListNode next;
	    ListNode(int x) { val = x; }
	}
	/**
	 * 160. 相交链表
	 *  Hash表 法
	 * @param headA
	 * @param headB
	 * @return
	 */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		HashSet<ListNode> hashSet = new HashSet<ListNode>();
		while(headA != null) {
			hashSet.add(headA);
			headA = headA.next;
		}
		while(headB != null) {
			if(hashSet.contains(headB)) return headB;
			headB = headB.next;
		}
		return null;
	}

	/**
	 * 160. 相交链表
	 * 双指针判别法
	 * @param headA
	 * @param headB
	 * @return
	 */
	public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
		ListNode head1 = headA;
		ListNode head2 = headB;
		
		while(head1 != head2) {
			if(head1 == null) {
				head1 = headB;
			} else {
                head1 = head1.next;
            }
			if(head2 == null) {
				head2 = headA;
			} else {
                head2 = head2.next;
            }
		}
		return head1;
	}
}
