package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringQuestion {

	public static void main(String[] args) {
		String s = "anana";
		//System.out.println(longestPalindrome(s));
		
//		StringQuestion sq = new StringQuestion();
//		List<List<String>> partition = sq.partition(s);
//		System.out.println(partition.toString());
		s = "10#11#12";
//		System.out.println(freqAlphabets(s));
		StringQuestion sq = new StringQuestion();
		System.out.println(sq.q());
	}
	
	
	public String q(){
		String q = "class Solution {\n" + 
				"	public String q(){\n" + 
				"		String q = \"class Solution {\\n\" + \n" + 
				"				\"	public String q(){\\n\" + \n" + 
				"				\"		String q = \\\"\\\";\\n\" + \n" + 
				"				\"		return q;\\n\" + \n" + 
				"				\"	}\\n\" + \n" + 
				"				\"}\";\n" + 
				"		return q;\n" + 
				"	}\n" + 
				"}";
		return q;
	}
	
	/**
	 * 5308. 或运算的最小翻转次数
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public static int minFlips(int a, int b, int c) {
		int help = a|b;
		int help2 = a&b;
		String strHelp = Integer.toBinaryString(help);
		String strHelp2 = Integer.toBinaryString(help2);
		String strC = Integer.toBinaryString(c);
		
		int lenHelp = strHelp.length();
		int lenC = strC.length();
		if(lenHelp < lenC) {
			int sub = lenC - lenHelp;
			for(int i=0; i<sub; i++) {
				strHelp = "0"+strHelp;
			}
		} else if(lenHelp > lenC) {
			int sub = lenHelp - lenC;
			for(int i=0; i<sub; i++) {
				strC = "0"+strC;				
			}
		}
		
		int len = strHelp.length();
		if(strHelp2.length() < len) {
			int sub = len - strHelp2.length();
			for(int i=0; i<sub; i++) {
				strHelp2 = "0"+strHelp2;
			}
		}
		int res = 0;
		for(int i=0; i<len; i++) {
			if(strC.charAt(i) == strHelp.charAt(i)) {
				continue;
			} else if(strC.charAt(i) == '1'){
				res += 1;
			} else if(strHelp2.charAt(i) == '0'){
				res += 1;
			} else {
				res += 2;
			}
		}
		return res;
	}
	
	
	/**
	 * 5307. 将整数转换为两个无零整数的和
	 * @param n
	 * @return
	 */
	public int[] getNoZeroIntegers(int n) {
		int i = 1;
		int j = n-i;
		while(i <= n/2) {
			if(notZeor(i) && notZeor(j)) {
				break;
			}
			i++;
			j = n-i;
		}
		return new int[]{i,j};
	}
 
    private boolean notZeor(int i) {
		String string = Integer.toString(i, 0);
		int indexOf = string.indexOf("0");
		if(indexOf == -1) {
			return true;
		}
		return false;
	}


	public int minAdd(String string) {
		char[] str = string.toCharArray();
		int len = str.length;
		int[][] vec = new int[len][len];//用于存储字符串从i位置到j位置构成汇文串需要最少添加的字符数量
		for(int k = 1 ; k < len ; k ++) {//i位置与j位置的间隔（自字符串长度-1），一般情况下，拆分成最小子问题时，k的初始值应为0，但因java创建数组是已经对每一个节点赋予了初始值0，故k为0时可以省略
			for(int i = 0; i+k < len ; i++) {
				int j = i + k ;
				if(str[i]==str[j]) {
					vec[i][j]=vec[i+1][j-1];
				}else {
					vec[i][j]=Math.min(vec[i+1][j],vec[i][j-1])+1;
				}
			}
		}
		return vec[0][len-1];
	}

	public static String freqAlphabets(String s) {
		
		char[] chars = s.toCharArray();
		int len = chars.length;
		StringBuilder string = new StringBuilder();
		for(int i=len-1; i>=0; i--) {
			if(chars[i] == '#') {//(int)(str_data - '0')
				int a = Integer.parseInt(String.valueOf(chars[--i])) + Integer.parseInt(String.valueOf(chars[--i]))*10 - 1;
				string.append((char)('a'+a));
			} else {
				int a = Integer.parseInt(String.valueOf(chars[i])) - 1;
				string.append((char)('a'+a));
			}
		}
		return string.reverse().toString();
	}
	
	/**
	 * 168. Excel表列名称
	 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 	 * 例如，
     * 1 -> A
     * 2 -> B
     * 3 -> C
     * ...
     * 26 -> Z
     * 27 -> AA
     * 28 -> AB 
 
	 * @param n
	 * @return
	 */
    public String convertToTitle(int n) {
    	StringBuilder string = new StringBuilder();
    	while(n > 0) {    		
    		n--;
    		int a = n % 26;
    		string.insert(0, (char)(a + 'A'));
    		n /= 26;
    	}
    	return string.toString();
//        StringBuilder stringBuilder = new StringBuilder();
//        while (n != 0) {
//            n --;//这里稍作处理，因为它是从1开始
//            stringBuilder.append((char)(n % 26 + 'A'));
//            n /= 26;
//        }
//        return stringBuilder.reverse().toString();
    }
    
	/**
	 * 171. Excel表列序号
	 * 
	 * @param s
	 * @return
	 */
	public int titleToNumber(String s) {
		int res = 0;
		int len = s.length();
		for(int i=0; i<len; i++) {
			int val = s.charAt(i) - 'A' + 1;
			res = res*26 + val;
		}
		
		return res;
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
