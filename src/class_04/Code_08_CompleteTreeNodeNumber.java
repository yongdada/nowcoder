package class_04;

/**
 * 完全二叉树的节点数
 * @author Administrator
 *
 */
public class Code_08_CompleteTreeNodeNumber {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

	/**
	 * 222. 完全二叉树的节点个数
	 * @param head
	 * @return
	 */
	public static int nodeNum(Node head) {
		if (head == null) {
			return 0;
		}
		return bs(head, 1, mostLeftLevel(head, 1));
	}

	/**
	 * 
	 * @param node 当前节点
	 * @param level 当前节点所在树的底几层
	 * @param heigh	二叉树的总高度
	 * @return	以当前节点为根的二叉树的节点个数
	 */
	public static int bs(Node node, int level, int heigh) {
		if (level == heigh) {
			return 1;
		}
		if (mostLeftLevel(node.right, level + 1) == heigh) {
			return (1 << (heigh - level)) + bs(node.right, level + 1, heigh);
		} else {
			return (1 << (heigh - level - 1)) + bs(node.left, level + 1, heigh);
		}
	}

	public static int mostLeftLevel(Node node, int level) {
		while (node != null) {
			level++;
			node = node.left;
		}
		return level - 1;
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.right.left = new Node(6);
		System.out.println(nodeNum(head));

	}

}
