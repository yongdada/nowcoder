package class_05_Hash_UnionFind;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * 并查集结构
 * @author Administrator
 *
 */
public class Code_04_UnionFind {

	public static class Node {
		// whatever you like
	}

	public static class UnionFindSet {
		public HashMap<Node, Node> fatherMap;
		public HashMap<Node, Integer> sizeMap;

		public UnionFindSet(List<Node> nodes) {
			makeSets(nodes);
		}

		private void makeSets(List<Node> nodes) {
			fatherMap = new HashMap<Node, Node>();
			sizeMap = new HashMap<Node, Integer>();
			
			fatherMap.clear();
			sizeMap.clear();
			for (Node node : nodes) {
				fatherMap.put(node, node);
				sizeMap.put(node, 1);
			}
		}

		/**
		 * 递归版本,自己实现
		 * @param node
		 * @return
		 */
		private Node findHead(Node node) {
			//Stack<Node> stack = new Stack<Node>();
			Node cur = node;
			Node father = fatherMap.get(node);
			while(father != cur) {
				father = findHead(father);
			}
			fatherMap.put(cur, father);
			return father;
		}
		/**
		 * 非递归版本,左神实现
		 * @param node
		 * @return
		 */
		@SuppressWarnings("unused")
		private Node findHead2(Node node) {
			Stack<Node> stack = new Stack<Node>();
			Node cur = node;
			Node father = fatherMap.get(node);
			while(father != cur) {
				stack.push(cur);
				cur = father;
				father = fatherMap.get(cur);
			}
			while( !stack.isEmpty() ) {
				fatherMap.put(stack.pop(), father);
			}
			return father;
		}
		
		/**
		 * 递归实现查找和修改结构
		 * @param node
		 * @return
		 */
		@SuppressWarnings("unused")
		private Node findHead1(Node node) {
			Node father = fatherMap.get(node);
			if (father != node) {
				father = findHead1(father);
			}
			fatherMap.put(node, father);
			return father;
		}
		
		public boolean isSameSet(Node a, Node b) {
			return findHead(a) == findHead(b);
		}

		/**
		 * 合并操作
		 * @param a
		 * @param b
		 */
		public void union(Node a, Node b) {
			if (a == null || b == null) {
				return;
			}
			Node aHead = findHead(a);
			Node bHead = findHead(b);
			if (aHead != bHead) {
				int aSetSize= sizeMap.get(aHead);
				int bSetSize = sizeMap.get(bHead);
				if (aSetSize <= bSetSize) {
					fatherMap.put(aHead, bHead);
					sizeMap.put(bHead, aSetSize + bSetSize);
				} else {
					fatherMap.put(bHead, aHead);
					sizeMap.put(aHead, aSetSize + bSetSize);
				}
			}
		}

	}

	public static void main(String[] args) {

	}

}
