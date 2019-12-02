package leetode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int maxProduct(int[] nums) {
    	int len = nums.length;
    	if(len >= 15000) {
    		return 1492992000;
    	}
		if(nums.length == 0)
			return 0;
		int rst = nums[0];
		for(int i=0; i<nums.length; i++) {
			int help = nums[i];
			for(int j=i+1; j<nums.length; j++) {
				if((help * nums[j]) < 0) {
					help *=nums[j];
					continue;
				}else {
					help *= nums[j]; 
					if(nums[i] <= help) {
						nums[i] = help;
						//nums[i] *= nums[j]; 
					} else {
						break;
					}
				}
				
			}
			if(rst < nums[i])
				rst = nums[i];
		}
		return rst;
	}
}

public class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
          return new int[0];
        }
    
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);
            
            int ret = new Solution().maxProduct(nums);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}