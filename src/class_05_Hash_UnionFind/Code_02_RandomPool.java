package class_05_Hash_UnionFind;

import java.util.HashMap;
/**
 * 设计一个支持在平均 时间复杂度 O(1) 下，执行以下操作的数据结构。
 * 
 * insert(val)：当元素 val 不存在时，向集合中插入该项。
 * remove(val)：元素 val 存在时，从集合中移除该项。
 * getRandom：随机返回现有集合中的一项。每个元素应该有相同的概率被返回。
 * 
 * @author Administrator
 *
 */
public class Code_02_RandomPool {

	public static class Pool<K> {
		private HashMap<K, Integer> keyIndexMap;
		private HashMap<Integer, K> indexKeyMap;
		private int size;

		public Pool() {
			this.keyIndexMap = new HashMap<K, Integer>();
			this.indexKeyMap = new HashMap<Integer, K>();
			this.size = 0;
		}

		public void insert(K key) {
			if (!this.keyIndexMap.containsKey(key)) {
				this.keyIndexMap.put(key, this.size);
				this.indexKeyMap.put(this.size++, key);
			}
		}

		public void delete(K key) {
			if (this.keyIndexMap.containsKey(key)) {
				int deleteIndex = this.keyIndexMap.get(key);
				int lastIndex = --this.size;
				K lastKey = this.indexKeyMap.get(lastIndex);
				this.keyIndexMap.put(lastKey, deleteIndex);
				this.indexKeyMap.put(deleteIndex, lastKey);
				this.keyIndexMap.remove(key);
				this.indexKeyMap.remove(lastIndex);
			}
		}

		public K getRandom() {
			if (this.size == 0) {
				return null;
			}
			int randomIndex = (int) (Math.random() * this.size); // 0 ~ size -1
			return this.indexKeyMap.get(randomIndex);
		}

	}

	public static void main(String[] args) {
		Pool<String> pool = new Pool<String>();
		pool.insert("zuo");
		pool.insert("cheng");
		pool.insert("yun");
		System.out.println(pool.getRandom());
		System.out.println(pool.getRandom());
		System.out.println(pool.getRandom());
		System.out.println(pool.getRandom());
		System.out.println(pool.getRandom());
		System.out.println(pool.getRandom());

	}
	
	/**
	 * 380. 常数时间插入、删除和获取随机元素
	 * @author Administrator
	 *
	 */
	class RandomizedSet {

	    /** Initialize your data structure here. */
		private HashMap<Integer, Integer> keyIndexMap;
		private HashMap<Integer, Integer> indexKeyMap;
		private int size;
		
	    public RandomizedSet() {
	    	this.indexKeyMap = new HashMap<Integer, Integer>();
	    	this.keyIndexMap = new HashMap<Integer, Integer>();
	    	this.size = 0;
	    }
	    
	    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	    public boolean insert(int val) {
	        if(!keyIndexMap.containsKey(val)) {
	        	keyIndexMap.put(val, size);
	        	indexKeyMap.put(size++, val);
	        	return true;
	        }else {
	        	return false;
	        }
	    }
	    
	    /** Removes a value from the set. Returns true if the set contained the specified element. */
	    public boolean remove(int val) {
	        if(keyIndexMap.containsKey(val)) {
	        	int index = keyIndexMap.get(val);
	        	int lastkey = indexKeyMap.get(size-1);
	        	indexKeyMap.replace(index, lastkey);
	        	keyIndexMap.replace(lastkey, index);
	        	keyIndexMap.remove(val);
	        	indexKeyMap.remove(--size);
	        	return true;
	        } else {
	        	return false;
	        }
	    }
	    
	    /** Get a random element from the set. */
	    @SuppressWarnings("null")
		public int getRandom() {
	        if(size == 0) {
	        	return (Integer) null;
	        }
	        int randomIndex = (int) (Math.random() * size);
	        return indexKeyMap.get(randomIndex);
	    }
	}

	/**
	 * Your RandomizedSet object will be instantiated and called as such:
	 * RandomizedSet obj = new RandomizedSet();
	 * boolean param_1 = obj.insert(val);
	 * boolean param_2 = obj.remove(val);
	 * int param_3 = obj.getRandom();
	 */

}
