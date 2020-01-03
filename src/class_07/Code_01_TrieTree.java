package class_07;

/**
 * 前缀树
 * @author Administrator
 *
 */
public class Code_01_TrieTree {

	public static class TrieNode {
		public int path;
		public int end;
		public TrieNode[] nexts;

		public TrieNode() {
			path = 0;
			end = 0;
			nexts = new TrieNode[26];
		}
	}

	public static class Trie {
		private TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		public void insert(String word) {
			if (word == null) {
				return;
			}
			char[] chs = word.toCharArray();
			TrieNode node = root;
			int index = 0;
			for (int i = 0; i < chs.length; i++) {
				index = chs[i] - 'a';
				if (node.nexts[index] == null) {
					node.nexts[index] = new TrieNode();
				}
				node = node.nexts[index];
				node.path++;
			}
			node.end++;
		}

		public void delete(String word) {
			if (search(word) != 0) {
				char[] chs = word.toCharArray();
				TrieNode node = root;
				int index = 0;
				for (int i = 0; i < chs.length; i++) {
					index = chs[i] - 'a';
					if (--node.nexts[index].path == 0) {
						node.nexts[index] = null;
						return;
					}
					node = node.nexts[index];
				}
				node.end--;
			}
		}

		public int search(String word) {
			if (word == null) {
				return 0;
			}
			char[] chs = word.toCharArray();
			TrieNode node = root;
			int index = 0;
			for (int i = 0; i < chs.length; i++) {
				index = chs[i] - 'a';
				if (node.nexts[index] == null) {
					return 0;
				}
				node = node.nexts[index];
			}
			return node.end;
		}

		public int prefixNumber(String pre) {
			if (pre == null) {
				return 0;
			}
			char[] chs = pre.toCharArray();
			TrieNode node = root;
			int index = 0;
			for (int i = 0; i < chs.length; i++) {
				index = chs[i] - 'a';
				if (node.nexts[index] == null) {
					return 0;
				}
				node = node.nexts[index];
			}
			return node.path;
		}
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		System.out.println(trie.search("zuo"));
		trie.insert("zuo");
		System.out.println(trie.search("zuo"));
		trie.delete("zuo");
		System.out.println(trie.search("zuo"));
		trie.insert("zuo");
		trie.insert("zuo");
		trie.delete("zuo");
		System.out.println(trie.search("zuo"));
		trie.delete("zuo");
		System.out.println(trie.search("zuo"));
		trie.insert("zuoa");
		trie.insert("zuoac");
		trie.insert("zuoab");
		trie.insert("zuoad");
		trie.delete("zuoa");
		System.out.println(trie.search("zuoa"));
		System.out.println(trie.prefixNumber("zuo"));

	}
	
	class Trie2 {

	    /** Initialize your data structure here. */
		public class TrieTree{
			public int path;
			public int end;
			
			public TrieTree[] next;
			
			public TrieTree() {
				path = 0;
				end = 0;
				
				next = new TrieTree[26];
			}
		}
		
		private TrieTree root;
		
	    public Trie2() {
	    	root = new TrieTree();
	    }
	    
	    /** Inserts a word into the trie. */
	    public void insert(String word) {
	        if(word == null) {
	        	return ;
	        }
	        char[] charArray = word.toCharArray();
	        TrieTree node = root;
	        
	        for(int i=0; i<charArray.length; i++) {
	        	int index = charArray[i] - 'a' ;
	        	if(node.next[index] == null) {
	        		node.next[index] = new TrieTree();
	        	}
	        	node = node.next[index];
	        	node.path++;
	        }
	        node.end++;
	    }
	    
	    /** Returns if the word is in the trie. */
	    public boolean search(String word) {
	    	if(word == null) {
	        	return false;
	        }
	        char[] charArray = word.toCharArray();
	        TrieTree node = root;
	        
	        for(int i=0; i<charArray.length; i++) {
	        	int index = charArray[i] - 'a' ;
	        	if(node.next[index] == null) {
	        		return false;
	        	}
	        	node = node.next[index];
	        }
	        if(node.end == 0) {
	        	return false;
	        }
	        return true;
	    }
	    
	    /** Returns if there is any word in the trie that starts with the given prefix. */
	    public boolean startsWith(String prefix) {
	    	if(prefix == null) {
	        	return false;
	        }
	        char[] charArray = prefix.toCharArray();
	        TrieTree node = root;
	        
	        for(int i=0; i<charArray.length; i++) {
	        	int index = charArray[i] - 'a' ;
	        	if(node.next[index] == null) {
	        		return false;
	        	}
	        	node = node.next[index];
	        }
	        return true;
	    }
	}

	/**
	 * Your Trie object will be instantiated and called as such:
	 * Trie obj = new Trie();
	 * obj.insert(word);
	 * boolean param_2 = obj.search(word);
	 * boolean param_3 = obj.startsWith(prefix);
	 */
	class WordDictionary {

	    /** Initialize your data structure here. */
		public class TrieTree{
			public int path;
			public int end;
			
			public TrieTree[] next;
			
			public TrieTree() {
				path = 0;
				end = 0;
				
				next = new TrieTree[26];
			}
		}
		
		private TrieTree root;
		
	    public WordDictionary() {
	    	root = new TrieTree();
	    }
	    
	    /** Adds a word into the data structure. */
	    public void addWord(String word) {
	        if(word == null) {
	        	return ;
	        }
	        char[] charArray = word.toCharArray();
	        TrieTree node = root;
	        
	        for(int i=0; i<charArray.length; i++) {
	        	int index = charArray[i] - 'a' ;
	        	if(node.next[index] == null) {
	        		node.next[index] = new TrieTree();
	        	}
	        	node = node.next[index];
	        	node.path++;
	        }
	        node.end++;

	    }
	    
	    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
	    public boolean search(String word) {
	    	if(word == null) {
	        	return false;
	        }
	        char[] charArray = word.toCharArray();
	        TrieTree node = root;
	        
	        for(int i=0; i<charArray.length; i++) {
	        	if(charArray[i] == '.') {
	        		for (int j = 0; j < 26; j++) {
	        			if(node.next[j] != null) {
	        				
	        				node = node.next[j];
	        				break;
		        		}
	        			
	        		}
	        		int index = charArray[i] - 'a' ;
	        		if(node.next[index] == null) {
	        			return false;
	        		}
	        		node = node.next[index];
	        	} else {	
	        		int index = charArray[i] - 'a' ;
	        		if(node.next[index] == null) {
	        			return false;
	        		}
	        		node = node.next[index];
	        	}
	        }
	        if(node.end == 0) {
	        	return false;
	        }
	        return true;

	    }
	}

}
