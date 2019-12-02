package leetode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringQuestion {

	public static void main(String[] args) {
		String s = "anana";
		//System.out.println(longestPalindrome(s));
		
		StringQuestion sq = new StringQuestion();
		List<List<String>> partition = sq.partition(s);
		System.out.println(partition.toString());
	}

	/**
	 * 分割回文串
	 * @param s
	 * @return
	 */
	public List<List<String>> partition(String s) {
		int len = s.length();
		boolean[][] isp = new boolean[len][len];
		
		for(int i=len-1; i>=0; i--) {
			for(int j=i; j<len;j++) {
				isp[i][j] = (s.charAt(i)==s.charAt(j)) && (j-i<3 || isp[i+1][j-1]);
			}
		}
		return helper(s,isp,0);
	}
	private List<List<String>> helper(String s, boolean[][] isp, int start) {
		//递归退出条件
		if(start == s.length() ) {
			List<List<String>> ans = new ArrayList<List<String>>();
			ans.add(new ArrayList<String>());
			return ans;
		}
		List<List<String>> res = new ArrayList<List<String>>();
		for(int i=start; i<s.length();i++) {
			if(isp[start][i]) {
				String left = s.substring(start,i+1);
				for(List<String> list : helper(s, isp, i+1)) {
					list.add(0, left);
					res.add(list);
				}
			}
		}
		return res;
	}

	/**
	 * 最长回文子串
	 * @param s
	 * @return
	 */
	public static String longestPalindrome(String s) {
		int length = s.length();
		boolean[] isp = new boolean[length];
		String res = "" ;
		for(int i=length-1;i>=0;i--) {
			for(int j=length-1; j>=i;j--) {		//s.substring(i, j);
				isp[j] = (s.charAt(i) == s.charAt(j) && ( j-i<3 ||isp[j-1]));
				if(isp[j] && j-i+1>res.length())
					res = s.substring(i, j+1);
			}
		}
		return res;
	}
	

	/**
	 * 有效的字母异位词
	 * 
	 * @param s
	 * @param t
	 * @return
	 */
	public static boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		int[] table = new int[32];
		for (int i = 0; i < s.length(); i++) {
			table[s.charAt(i) - 'a']++;
		}
		for (int j = 0; j < t.length(); j++) {
			table[t.charAt(j) - 'a']--;
			if (table[t.charAt(j) - 'a'] < 0)
				return false;
		}
		return true;

	}

	/**
	 * 字符串中的第一个唯一字符
	 * 
	 * @param s
	 * @return
	 */
	public static int firstUniqChar(String s) {
		if (s.isEmpty())
			return -1;
		Map<Character, Integer> hm = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
//			if(hm.containsKey(s.charAt(i))) {
//				hm.put(s.charAt(i), hm.get(s.charAt(i))+1);
//			} else {
//				hm.put(s.charAt(i), 1);
//			}
		}
		for (int i = 0; i < s.length(); i++) {
			if (hm.get(s.charAt(i)) == 1)
				return i;
		}
		return -1;

	}

	/**
	 * 字符串中的第一个唯一字符
	 * 
	 * @param s
	 * @return
	 */
	public static int firstUniqChar1(String s) {
		if (s.isEmpty())
			return -1;
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			boolean flag = false;
			for (int j = 0; j < chars.length; j++) {
				if (i == j)
					continue;
				if (chars[i] == chars[j]) {
					flag = true;
					break;
				}
			}
			if (!flag)
				return i;
		}
		return -1;
	}

	public static int firstUniqChar2(String s) {
		if (s == null)
			return -1;
		if (s.length() == 1)
			return 0;

		int start = -1;
		int end = -1;
		int result = s.length();
		for (char c = 'a'; c <= 'z'; c++) {
			start = s.indexOf(c);
			end = s.lastIndexOf(c);
			if (start == end && start != -1) {
				result = Math.min(result, start);
			}
		}
		return result;// == s.length() ? -1 : result;
	}

	public int firstUniqChar_one(String s) {
		if (s == null)
			return -1;
		if (s.length() == 1)
			return 0;

		char[] chars = s.toCharArray();
		HashMap<String, Integer> nums = new HashMap<String, Integer>();
		for (int i = 0; i < chars.length; i++) {
			String key = String.valueOf(chars[i]);
			nums.put(key, nums.getOrDefault(key, 0) + 1);
		}
		for (int i = 0; i < chars.length; i++) {
			String key = String.valueOf(chars[i]);
			if (nums.get(key) == 1) {
				return i;
			}
		}
		return -1;
	}
}
