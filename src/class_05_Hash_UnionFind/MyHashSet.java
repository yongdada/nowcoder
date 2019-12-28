package class_05_Hash_UnionFind;

import java.util.ArrayList;
import java.util.List;

/**
 * 705. 设计哈希集合
 * @author Administrator
 *
 */
public class MyHashSet {

    /** Initialize your data structure here. */
	List<List<Integer>> list;
	int length = 50; //桶的个数
    public MyHashSet() {
    	list = new ArrayList<List<Integer>>();
    	for(int i=0; i<length; i++) {
    		list.add(i, new ArrayList<Integer>());
    	}
    }
    
    public void add(int key) {
    	if (!contains(key)) {    		
    		list.get(key%length).add(key);
    	}
    }
    
    public void remove(int key) {
    	list.get(key%length).remove((Integer)key);
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return list.get(key%length).contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */