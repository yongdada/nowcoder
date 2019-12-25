package class_04;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的遍历
 * 
 * @author Administrator
 *
 */
public class Code_01_PreInPosTraversal {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

	/**
	 * 递归实现 先序遍历
	 * 
	 * @param head
	 */
	public static void preOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		System.out.print(head.value + " ");
		preOrderRecur(head.left);
		preOrderRecur(head.right);
	}

	/**
	 * 中序遍历
	 * 
	 * @param head
	 */
	public static void inOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		inOrderRecur(head.left);
		System.out.print(head.value + " ");
		inOrderRecur(head.right);
	}

	/**
	 * 后续遍历
	 * 
	 * @param head
	 */
	public static void posOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		posOrderRecur(head.left);
		posOrderRecur(head.right);
		System.out.print(head.value + " ");
	}

	// =========================非递归实现========================
	public static void preOrderUnRecur(Node head) {
		System.out.print("pre-order: ");
		if (head != null) {
			Stack<Node> stack = new Stack<Node>();
			stack.push(head);
			while (!stack.isEmpty()) {
				head = stack.pop();
				System.out.print(head.value + " ");
				// 先压入右，在压入左节点， 则先弹出左，再弹出右
				if (head.right != null) {
					stack.push(head.right);
				}
				if (head.left != null) {
					stack.push(head.left);
				}
			}
		}
		System.out.println();
	}

	public static void inOrderUnRecur(Node head) {
		System.out.print("in-order: ");
		if (head != null) {
			Stack<Node> stack = new Stack<Node>();
			while (!stack.isEmpty() || head != null) {
				if (head != null) {
					stack.push(head);
					head = head.left;
				} else {
					head = stack.pop();
					System.out.print(head.value + " ");
					head = head.right;
				}
			}
		}
		System.out.println();
	}

	public static void posOrderUnRecur1(Node head) {
		System.out.print("pos-order: ");
		if (head != null) {
			Stack<Node> s1 = new Stack<Node>();
			Stack<Node> s2 = new Stack<Node>();
			s1.push(head);
			// 对比先序遍历， 需要一个额外的栈，反转出栈顺序 为 打印顺序
			while (!s1.isEmpty()) {
				head = s1.pop();
				s2.push(head);
				if (head.left != null) {
					s1.push(head.left);
				}
				if (head.right != null) {
					s1.push(head.right);
				}
			}
			while (!s2.isEmpty()) {
				System.out.print(s2.pop().value + " ");
			}
		}
		System.out.println();
	}

	public static void posOrderUnRecur2(Node h) {
		System.out.print("pos-order: ");
		if (h != null) {
			Stack<Node> stack = new Stack<Node>();
			stack.push(h);
			Node c = null;
			while (!stack.isEmpty()) {
				c = stack.peek();
				if (c.left != null && h != c.left && h != c.right) {
					stack.push(c.left);
				} else if (c.right != null && h != c.right) {
					stack.push(c.right);
				} else {
					System.out.print(stack.pop().value + " ");
					h = c;
				}
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Node head = new Node(5);
		head.left = new Node(3);
		head.right = new Node(8);
		head.left.left = new Node(2);
		head.left.right = new Node(4);
		head.left.left.left = new Node(1);
		head.right.left = new Node(7);
		head.right.left.left = new Node(6);
		head.right.right = new Node(10);
		head.right.right.left = new Node(9);
		head.right.right.right = new Node(11);

		// recursive
		System.out.println("==============recursive递归实现==============");
		System.out.print("pre-order: ");
		preOrderRecur(head);
		System.out.println();
		System.out.print("in-order: ");
		inOrderRecur(head);
		System.out.println();
		System.out.print("pos-order: ");
		posOrderRecur(head);
		System.out.println();

		// unrecursive
		System.out.println("============unrecursive非递归实现=============");
		preOrderUnRecur(head);
		inOrderUnRecur(head);
		posOrderUnRecur1(head);
		posOrderUnRecur2(head);

	}

	// ================================================================
	/**
	 * Definition for a binary tree node.
	 */
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	class Solution {
		// ==============先序遍历====================
		List<Integer> rst = new ArrayList<Integer>();

		public List<Integer> preorderTraversal1(TreeNode root) {
			preorder(root);
			return rst;

		}

		private void preorder(TreeNode root) {
			if (root == null) {
				return;
			}
			rst.add(root.val);
			preorder(root.left);
			preorder(root.right);
		}

		// 非递归
		public List<Integer> preorderTraversal2(TreeNode root) {
			List<Integer> list = new ArrayList<Integer>();
			if (root != null) {
				Stack<TreeNode> stack = new Stack<TreeNode>();
				stack.push(root);
				while (!stack.isEmpty()) {
					root = stack.pop();
					list.add(root.val);
					if (root.right != null) {
						stack.push(root.right);
					}
					if (root.left != null) {
						stack.push(root.left);
					}
				}
			}
			return list;
		}
		//==================中序遍历=========================
		/**
		 * 非递归实现
		 * @param root
		 * @return
		 */
	    public List<Integer> inorderTraversal(TreeNode root) {
	    	List<Integer> list = new ArrayList<Integer>();
			if (root != null) {
				Stack<TreeNode> stack = new Stack<TreeNode>();
				while (!stack.isEmpty() || root !=null ) {
					if (root != null) {
						stack.push(root);
						root = root.left;
					} else {
						root = stack.pop();
						list.add(root.val);
						root = root.right;
					}
				}
			}
			return list;
	    }
		/**
		 * 后续遍历，非递归
		 * @param root
		 * @return
		 */
	    public List<Integer> postorderTraversal(TreeNode root) {
			List<Integer> list = new ArrayList<Integer>();
			if (root != null) {
				Stack<TreeNode> stack = new Stack<TreeNode>();
				Stack<TreeNode> help = new Stack<TreeNode>();
				stack.push(root);
				while (!stack.isEmpty()) {
					root = stack.pop();
					help.push(root);
					if (root.left != null) {
						stack.push(root.left);
					}
					if (root.right != null) {
						stack.push(root.right);
					}
				}
				while(!help.isEmpty()) {
					list.add(help.pop().val);
				}
			}
			return list;
	    }
	    
	    /**
	     * 先序遍历：莫里斯遍历
	     * 算法不会使用额外空间，只需要保存最终的输出结果。如果实时输出结果，那么空间复杂度是 O(1)。
	     * @param root
	     * @return
	     */
	    public List<Integer> preorderTraversal(TreeNode root) {
		    LinkedList<Integer> output = new LinkedList<>();

		    TreeNode node = root;
		    while (node != null) {
		      if (node.left == null) {
		        output.add(node.val);
		        node = node.right;
		      }
		      else {
		        TreeNode predecessor = node.left;
		        while ((predecessor.right != null) && (predecessor.right != node)) {
		          predecessor = predecessor.right;
		        }

		        if (predecessor.right == null) {
		          output.add(node.val);
		          predecessor.right = node;
		          node = node.left;
		        }
		        else{
		          predecessor.right = null;
		          node = node.right;
		        }
		      }
		    }
		    return output;
		  }
	    //===========================层次遍历==================================
	    /**
	     * 102. 二叉树的层次遍历
	     * 二叉树的层次遍历，递归实现
	     * @param root
	     * @return
	     */
	    public List<List<Integer>> levelOrder(TreeNode root) {
	    	List<List<Integer>> lists = new ArrayList<List<Integer>>();
	    	if(root == null)	return lists;
	    	levelOrderHelp(root, 0, lists);
	    	return lists;
	    }
	    private void levelOrderHelp(TreeNode root, int level, List<List<Integer>> lists) {
	    	
	    	if(root != null) {
	    		//构造层
		    	if(lists.size() == level) {
		    		lists.add(new ArrayList<Integer>());
		    	}
	    		lists.get(level).add(root.val);
	    		
	    		levelOrderHelp(root.left, level+1, lists);
	    		levelOrderHelp(root.right, level+1, lists);
	    	}
	    }
	    
	    /**
	     * 107. 二叉树的层次遍历 II
	     * @param root
	     * @return
	     */
	    public List<List<Integer>> levelOrderBottom(TreeNode root) {
	    	List<List<Integer>> lists = new ArrayList<List<Integer>>();
	    	if(root == null)	return lists;
	    	levelOrderHelp(root, 0, lists);
	    	//同102题，下面代码将lists中值顺序反转
	    	for (int i = 0, j = lists.size() - 1; i < j; i++, j--) {
	            List<Integer> temp = lists.get(i);
	            lists.set(i, lists.get(j));
	            lists.set(j, temp);
	        }
	    	return lists;
	    }
	}

}
