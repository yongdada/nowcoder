package leeCode;

import java.util.Arrays;
import java.util.TreeSet;

public class Array {
	public static void main(String[] args) {
		
	}
	
	
	public void moveZeroes(int[] nums) {
		int end = nums.length;
		int start = 0;
		int[] help = Arrays.copyOf(nums, end);
        for (int i=0; i<help.length; i++) {
        	if(help[i] == 0) {
        		nums[--end] = 0;
        	}else {
        		nums[start++] = help[i];
        	}
        }
    }
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		TreeSet<Integer> set = new TreeSet<Integer>();
		for(int i=0; i<nums.length ; i++) {
			Integer s = set.ceiling(nums[i]);
		    if (s != null && s <= nums[i] + t) return true;

		    Integer g = set.floor(nums[i]);
		    if (g != null && nums[i] <= g + t) return true;
			set.add(nums[i]);
			if(set.size() > k)
				set.remove(nums[i-k]);
		}
		return false;
	}
}
