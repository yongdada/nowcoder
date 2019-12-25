package class_04;


/**
 * 平衡二叉树
 * @author Administrator
 *
 */
public class Code_06_IsBalancedTree {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

	public static boolean isBalance(Node head) {
		boolean[] res = new boolean[1];
		res[0] = true;
		getHeight(head, 1, res);
		return res[0];
	}

	public static int getHeight(Node head, int level, boolean[] res) {
		if (head == null) {
			return level;
		}
		int lH = getHeight(head.left, level + 1, res);
		if (!res[0]) {
			return level;
		}
		int rH = getHeight(head.right, level + 1, res);
		if (!res[0]) {
			return level;
		}
		if (Math.abs(lH - rH) > 1) {
			res[0] = false;
		}
		return Math.max(lH, rH);
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.right.left = new Node(6);
		head.right.right = new Node(7);

		System.out.println(isBalance(head));

	}

	//========================================================
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	public boolean isBalanced(TreeNode root) {
		
		if (getHeigh(root) == -1) {
			return false;
		}
		return true;
	}

	/**
	 * @param root
	 * @return -1代表非平衡二叉树， 大于0的整型代表以root为根的树的高度
	 */
	private int getHeigh(TreeNode root) {
		// TODO Auto-generated method stub
		if (root == null) {
			return 0;
		}
		int leftH = getHeigh(root.left);
		if(leftH == -1)	return -1;
		int rightH = getHeigh(root.right);
		if (rightH == -1) return -1;
		if (Math.abs(rightH - leftH) > 1)	return -1;
		
		return Math.max(leftH, rightH)+1;
	}
}
