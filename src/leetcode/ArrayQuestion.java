package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ArrayQuestion {
	public static void main(String[] args) {
		
		int[] arr = { 2, 3, 234, 234, 3, 5, 32, 2 };
		int len = arr.length;
		System.out.println(len);
		for (int i = 0; i < 9; i++) {
			int x = (int) (Math.random() * len);
			int y = (int) (Math.random() * len);
			System.out.println(x + " " + y);
		}
//		sortColors(arr);
//		System.out.println(arr[0]);
//		ArrayQuestion arrayQuestion = new ArrayQuestion();
//		int[] nums = {1,2,3,1};
//		boolean containsDuplicate = arrayQuestion.containsNearbyAlmostDuplicate(nums, 3, 0);
//		System.out.println(containsDuplicate);

	}

	/**
	 * 5309. 连通网络的操作次数
	 * 
	 * <b>err</b>
	 * 
	 * @param n
	 * @param connections
	 * @return
	 */
	public int makeConnected(int n, int[][] connections) {
		// TODO: 此解错误，待完成
		int count = connections.length;
		if(count+1 <n) {
			return -1;
		}
		HashSet<Integer> hash = new HashSet<Integer>();
		for(int i = 0; i < count; i++) {
			for(int j = 0; j < 2; j++) {
				//connections[i][j]
				hash.add(connections[i][j]);
			}
		}
		int res = 0;
		for(int i=0; i<n; i++) {
			if(! hash.contains((Integer)i)) {
				res++;
			}
		}
		return res;
	}
	public int[] xorQueries(int[] arr, int[][] queries) {
		int[] res = new int[queries.length];
		for(int i=0; i<queries.length; i++) {
			if(queries[i][0] == queries[i][1]) {
				res[i] = arr[queries[i][0]];
			} else {
				for(int j=queries[i][0]; j<=queries[i][1]; j++) {
					res[i] ^= arr[j];
				}
			}
		}
		return res;
	}
	
	//===================================================
	/**
	 * 303. 区域和检索 - 数组不可变	
	 * 辣鸡解法
	 * @author Administrator
	 *
	 */
	class NumArray {
		class Help{
			int i;
			int j;
			public Help(int i, int j) {
				super();
				this.i = i;
				this.j = j;
			}
			@Override
			public int hashCode() {
				int result = 17;
		        result = 31 * result + i;
		        result = 31 * result + j;
		        return result;
			}
			@Override
			public boolean equals(Object obj) {
				if (this == obj) {
		            return true;
		        }
		        if (obj == null || getClass() != obj.getClass()) {
		            return false;
		        }
		        Help help = (Help) obj;
		        return i==help.i && j==help.j;
			}
		}

		private int[] arr ;
		private HashMap<int[], Integer> hash ;
	    public NumArray(int[] nums) {
	        arr = nums;
	        hash = new HashMap<int[], Integer>();
	    }
	    
	    public int sumRange(int i, int j) {
	    	if(hash.containsKey(new int[]{i,j})) {
	    		return hash.get(new int[]{i,j});
	    	}
	        int sum = 0;
	        for(int k=i; k<=j; k++) {
	        	sum += arr[k];
	        }
	        hash.put(new int[]{i,j}, sum);
	        return sum;
	    }
	}

	/**
	 * Your NumArray object will be instantiated and called as such:
	 * NumArray obj = new NumArray(nums);
	 * int param_1 = obj.sumRange(i,j);
	 */
    
	//=====================================================================
	
	/**
	 * 440. 字典序的第K小数字
	 * 给定整数 n 和 k，找到 1 到 n 中字典序第 k 小的数字。
	 * @param n
	 * @param k
	 * @return
	 */
	public int findK = 0;
	public int findKthNumber(int n, int k) {
		findK = k;
		List<Integer> list = lexicalOrder(n);
		return list.get(k-1);
	}
	
	/**
	 * 386. 字典序排数
	 * 给定一个整数 n, 返回从 1 到 n 的字典顺序。
	 * @param n
	 * @return
	 */
	public List<Integer> lexicalOrder(int n) {
		List<Integer> res = new ArrayList<Integer>();
		if(n < 1)	return res;
		for(int i=1; i<=9; i++) {
			if(i > n)	break;
			lexicalOrderHelp(i, n, res);
		}
		
		return res;
	}
	private void lexicalOrderHelp(int i, int n, List<Integer> res) {
		if(res.size() == findK) {
			return ;
		}
		res.add(i);
			
		for(int j=0; j<=9; j++) {
			if(i*10 + j>n)	break;
			lexicalOrderHelp(i*10 + j, n, res);
		}
	}

	/**
	 * 1300. 转变数组后最接近目标值的数组和
	 * 给你一个整数数组 arr 和一个目标值 target ，
	 * 请你返回一个整数 value ，使得将数组中所有大于 value 的值变成 value 后，
	 * 数组的和最接近  target （最接近表示两者之差的绝对值最小）。
	 * @param arr
	 * @param target
	 * @return
	 */
	public int findBestValue(int[] arr, int target) {
        int left = 0;
        int right = 10_0000;

        while (left < right) {
            int mid = (left + right) >>> 1;
            int sum = calculateSum(arr, mid);
            // 计算第 1 个大于等于 target 的阈值
            if (sum < target) {
                // 严格小于的一定不是解
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // 比较阈值线分别定在 left - 1 和 left 的时候与 target 的接近程度
        int sum1 = calculateSum(arr, left - 1);
        int sum2 = calculateSum(arr, left);
        if (target - sum1 <= sum2 - target) {
            return left - 1;
        }
        return left;
    }

    private int calculateSum(int[] arr, int best) {
        int sum = 0;
        for (int num : arr) {
            sum += Math.min(num, best);
        }
        return sum;
    }
	
    /**
     * 1299. 将每个元素替换为右侧最大元素
     * @param n
     * @return
     */
	public int[] sumZero(int n) {
		if(n == 0)	return null;
		int[] res = new int[n];
		if(n%2 == 0) {
			int temp = n/2;
			for(int i=0; i<temp; i++) {
				res[i] = i - temp;
			}
			for(int i=temp; i<n; i++) {
				res[i] = i - temp +1;
			}
		} else {
			int temp = n/2;
			for(int i=0; i<n; i++) {
				res[i] = i - temp;
			}
		}
		return res;
	}
	
	/**
	 * 5134. 将每个元素替换为右侧最大元素
	 * @param arr
	 * @return
	 */
	public int[] replaceElements(int[] arr) {
		if(arr == null || arr.length == 0) {
			return arr;
		}
		int len = arr.length;
		int last = arr[len-1];
		arr[len-1] = -1;
		if(arr.length < 2) {
			return arr;
		}
		int max = Integer.MIN_VALUE;
		for(int i=len-1; i>0; i--) {
			if(last>max) {
				max = last;
			}
			last = arr[i-1];
			arr[i-1] = max;
		}
		return arr;
	}
	
	
	
	/**
	 * 80. 删除排序数组中的重复项 II
	 * 给定一个排序数组，你需要在原地删除重复出现的元素，
	 * 使得每个元素<b>最多出现两次</b>，返回移除后数组的新长度。
	 * 不要使用额外的数组空间，你必须在原地修改输入数组
	 * 并在使用 O(1)额外空间的条件下完成。
	 * 
	 * @param nums	排序数组
	 * @return	返回移除后数组的新长度
	 */
    public int removeDuplicates2(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int count = 0;
        boolean flag = false;
        for(int i=1; i<nums.length; i++){
            if(nums[count] == nums[i] && !flag){
                flag = true;
                nums[++count] = nums[i];
                continue;
            }
            if(nums[count] == nums[i] && flag){
                continue;
            } else {
                flag = false;
            	nums[++count] = nums[i];
            }
        }
        return count += 1;
    }
    
	/**
	 * 26. 删除排序数组中的重复项
	 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
	 * @param nums	排序数组
	 * @return	返回移除后数组的新长度。
	 */
    public int removeDuplicates1(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int count = 0;
        for(int i=1; i<nums.length; i++){
            if(nums[count] == nums[i]){
            	continue;
            } else {
            	nums[++count] = nums[i];
            }
        }
        return ++count;
    }
    
	/**
	 * 1295. 统计位数为偶数的数字
	 * @param nums
	 * @return
	 */
	public int findNumbers(int[] nums) {
        int res = 0;
        for(int n :nums){
        	String stringN = String.valueOf(n);
            int len = stringN.length();
            if(len%2 == 0) {
            	res++;
            }
            
        }
        return res;
    }
	
	/**
	 * 867. 转置矩阵
	 * @param A
	 * @return
	 */
	public int[][] transpose(int[][] A) {
		if(A == null || A.length == 0) return new int[0][0];
		
		int row = A.length;
		int cloumn = A[0].length;
		int[][] rst = new int[cloumn][row];
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < cloumn; j++) {
				rst[j][i] = A[i][j];
			}
		}
		return rst;
	}
	/**
	 * 334. 递增的三元子序列
	 * @param nums
	 * @return
	 */
	public boolean increasingTriplet(int[] nums) {
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        
        for(int i=0; i<nums.length; i++) {
        	if(nums[i] < a)	{
        		a = nums[i];
        	} else if(nums[i] > a && nums[i] < b) {
        		b = nums[i];
        	} else if(nums[i] > b){
        		return true;
        	}
        }
        
        return false;
    }
	
	/**
	 * 238. 除自身以外数组的乘积
	 *  采用 左边乘积 × 右边乘积
	 * @param nums
	 * @return
	 */
	public int[] productExceptSelf(int[] nums) {
		int len = nums.length;
		int[] rst = new int[nums.length];
		int k = 1;
		for(int i=0; i<len; i++) {
			rst[i] = k;
			k *= nums[i];
		}
		
		k = 1;
		for(int i=len-1; i>=0; i--) {
			rst[i] *= k;
			k *= nums[i];
		}
		return rst;
	}

	/**
	 * 随机打乱数组
	 * 
	 * @author add
	 *
	 */
	class Solution {

		private int[] numsCopy;
		private int[] nums;
		private int len;

		public Solution(int[] nums) {
			this.nums = nums;
			this.numsCopy = nums.clone();
			this.len = nums.length;
		}

		/** Resets the array to its original configuration and return it. */
		public int[] reset() {
			return numsCopy;
		}

		/** Returns a random shuffling of the array. */
		public int[] shuffle() {
			for (int i = 0; i < len; i++) {
				int x = (int) (Math.random() * len);
				int y = (int) (Math.random() * len);
				swap(nums, x, y);
			}
			return nums;
		}

		private void swap(int[] nums, int x, int y) {
			int tmp = nums[x];
			nums[x] = nums[y];
			nums[y] = tmp;
		}
	}

	/**
	 * Your Solution object will be instantiated and called as such: Solution obj =
	 * new Solution(nums); int[] param_1 = obj.reset(); int[] param_2 =
	 * obj.shuffle();
	 */
	/**
	 * 存在重复元素（三）
	 * 
	 * @param nums
	 * @return
	 */
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (k <= 0)
			return false;
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			Iterator<Integer> iterator = set.iterator();
			if (set.isEmpty()) {
				set.add(nums[i]);
				continue;
			}
			int max = Integer.MIN_VALUE;
			while (iterator.hasNext()) {
				int tmp = nums[i] - iterator.next();
				tmp = tmp > 0 ? tmp : -tmp;
				max = Math.max(max, tmp);
			}
			if (max <= t)
				return true;
			set.add(nums[i]);
			if (set.size() > k)
				set.remove(nums[i - k]);
		}
		return false;
	}

	/**
	 * 存在重复元素（二）
	 * 
	 * @param nums
	 * @return
	 */
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i]))
				return true;
			set.add(nums[i]);
			if (set.size() > k)
				set.remove(nums[i - k]);
		}
		return false;
	}

	/**
	 * 存在重复元素
	 * 
	 * @param nums
	 * @return
	 */
	public boolean containsDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i : nums) {
			set.add(i);
		}
		return nums.length > set.size() ? true : false;
	}

	/**
	 * 旋转数组
	 * 
	 * @param nums
	 * @param k
	 */
	public void rotate(int[] nums, int k) {
		int temp, previous;
		for (int i = 0; i < k; i++) {
			previous = nums[nums.length - 1];
			for (int j = 0; j < nums.length; j++) {
				temp = nums[j];
				nums[j] = previous;
				previous = temp;
			}
		}
	}

	public static void exchange(int[] arr, int i, int j) {
		arr[i] = arr[i] ^ arr[j];
		arr[j] = arr[i] ^ arr[j];
		arr[i] = arr[i] ^ arr[j];
	}

	/**
	 * 乘积最大子序列
	 * 
	 * @param nums
	 * @return
	 */
	public int maxProduct(int[] nums) {
		int max = Integer.MIN_VALUE, imax = 1, imin = 1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < 0) {
				int tmp = imax;
				imax = imin;
				imin = tmp;
			}
			imax = Math.max(imax * nums[i], nums[i]);
			imin = Math.min(imin * nums[i], nums[i]);

			max = Math.max(max, imax);
		}
		return max;
	}

	public int maxProduct1(int[] nums) {
		if (nums.length == 0)
			return 0;
		int rst = nums[0];
		for (int i = 0; i < nums.length; i++) {
			int help = nums[i];
			for (int j = i + 1; j < nums.length; j++) {
				if ((help * nums[j]) < 0) {
					help *= nums[j];
					continue;
				} else {
					help *= nums[j];
					if (nums[i] <= help) {
						nums[i] = help;
						// nums[i] *= nums[j];
					} else {
						break;
					}
				}

			}
			if (rst < nums[i])
				rst = nums[i];
		}
		return rst;
	}

	/**
	 * 荷兰国旗问题
	 * 
	 * @param nums
	 */
	public static void sortColors(int[] nums) {
		if (nums.length == 0) {
			return;
		}
		short red = -1, blue = (short) nums.length, index = 0;
		while (index < blue) {
			if (nums[index] == 0) {
				exchange(nums, index++, ++red);
			} else if (nums[index] == 1) {
				index++;
			} else {
				exchange(nums, index, --blue);
			}
		}
	}

}
