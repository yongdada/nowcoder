package class_03;

public class Code_07_ReverseList {

	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}

	public static Node reverseList(Node head) {
		Node pre = null;
		Node next = null;
		while (head != null) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		
		
		
		return pre;
	}

	public static class DoubleNode {
		public int value;
		public DoubleNode last;
		public DoubleNode next;

		public DoubleNode(int data) {
			this.value = data;
		}
	}

	public static DoubleNode reverseList(DoubleNode head) {
		DoubleNode pre = null;
		DoubleNode next = null;
		while (head != null) {
			next = head.next;
			head.next = pre;
			head.last = next;
			pre = head;
			head = next;
		}
		return pre;
	}

	public static void printLinkedList(Node head) {
		System.out.print("Linked List: ");
		while (head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
		System.out.println();
	}

	public static void printDoubleLinkedList(DoubleNode head) {
		System.out.print("Double Linked List: ");
		DoubleNode end = null;
		while (head != null) {
			System.out.print(head.value + " ");
			end = head;
			head = head.next;
		}
		System.out.print("| ");
		while (end != null) {
			System.out.print(end.value + " ");
			end = end.last;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Node head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		printLinkedList(head1);
		head1 = reverseList(head1);
		printLinkedList(head1);

		DoubleNode head2 = new DoubleNode(1);
		head2.next = new DoubleNode(2);
		head2.next.last = head2;
		head2.next.next = new DoubleNode(3);
		head2.next.next.last = head2.next;
		head2.next.next.next = new DoubleNode(4);
		head2.next.next.next.last = head2.next.next;
		printDoubleLinkedList(head2);
		printDoubleLinkedList(reverseList(head2));

	}
	
	//===============================================================
	public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	/**
	 * 206. 反转链表
	 * 迭代方式
	 * @param head
	 * @return
	 */
	public ListNode reverseList(ListNode head) {
		ListNode pre = null;
		ListNode next = null;
		while(head != null) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}
	/**
	 * 206. 反转链表
	 * 递归方式
	 * @param head
	 * @return
	 */
	public ListNode reverseList2(ListNode head) {
		if(head == null || head.next == null) return head;
		ListNode p = reverseList2(head.next);
		head.next.next = head;
		head.next = null;
		return p;
	}
	/**
	 * 92. 反转链表 II
	 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
	 * 	输入: 1->2->3->4->5->NULL, m = 2, n = 4
	 *	输出: 1->4->3->2->5->NULL
	 * @param head
	 * @param m
	 * @param n
	 * @return
	 */
	public ListNode reverseBetween(ListNode head, int m, int n) {
		
		ListNode first = new ListNode(0);
		first.next = head;
		ListNode node = first;
		for (int i = 1; i < m; i++) {
			node = node.next;
		}
		ListNode bgnhead = node.next;
		ListNode pre = null;
		ListNode next = null;
		for(int i = m; i <= n; i++) {
			next = bgnhead.next;
			bgnhead.next = pre;
			pre = bgnhead;
			bgnhead = next;
		}
		node.next.next = next;
		node.next = pre;
		return first.next;
	}
	
	public ListNode reverseBetween2(ListNode head, int m, int n) {
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode node = res;
        //找到需要反转的那一段的上一个节点。
        for (int i = 1; i < m; i++) {
            node = node.next;
        }
        //node.next就是需要反转的这段的起点。
        ListNode nextHead = node.next;
        ListNode next = null;
        ListNode pre = null;
        //反转m到n这一段
        for (int i = m; i <= n; i++) {
            next = nextHead.next;
            nextHead.next = pre;
            pre = nextHead;
            nextHead = next;
        }
        //将反转的起点的next指向next。
        node.next.next = next;
        //需要反转的那一段的上一个节点的next节点指向反转后链表的头结点
        node.next = pre;
        return res.next;
    }
}
