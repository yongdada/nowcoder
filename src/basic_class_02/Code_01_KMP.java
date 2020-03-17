package basic_class_02;

/**
 * str2在str1中的匹配位置
 * 	KMP算法
 * @author Administrator
 *
 */
public class Code_01_KMP {

	public static int getIndexOf(String s, String m) {
		if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
			return -1;
		}
		char[] ss = s.toCharArray();
		char[] ms = m.toCharArray();
		int si = 0;
		int mi = 0;
		int[] next = getNextArray(ms);
		while (si < ss.length && mi < ms.length) {
			if (ss[si] == ms[mi]) {
				si++;
				mi++;
			} else if (next[mi] == -1) {
				si++;
			} else {
				mi = next[mi];
			}
		}
		return mi == ms.length ? si - mi : -1;
	}

	/**
	 * str2的next数组
	 * @param ms
	 * @return
	 */
	public static int[] getNextArray(char[] ms) {
		if (ms.length == 1) {
			return new int[] { -1 };
		}
		int[] next = new int[ms.length];
		next[0] = -1;
		next[1] = 0;
		int pos = 2;
		int cn = 0;
		while (pos < next.length) {
			if (ms[pos - 1] == ms[cn]) {
				next[pos++] = ++cn;
			} else if (cn > 0) {
				cn = next[cn];
			} else {
				next[pos++] = 0;
			}
		}
		return next;
	}

	public static void main(String[] args) {
		String str = "abcabcababaccc";
		String match = "ababa";
//		System.out.println(getIndexOf(str, match));

		String s = "aa";
		System.out.println(repeatedSubstringPattern(s));
	}

	//=====================================================================
	
	/**
	 * 459. 重复的子字符串
	 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。
	 * 给定的字符串只含有小写英文字母，并且长度不超过10000
	 * @param s
	 * @return
	 */
	public static boolean repeatedSubstringPattern(String s) {
		int len = s.length();
		if(len == 1) {
			return false;
		}
		int[] next = getNext(s);
		int k = next[len-1];
		if(len%(len-k) == 0 && k != 0) {
			return true;
		}
		return false;
		
	}

	private static int[] getNext(String s) {
		int len = s.length();
		int[] next = new int[len];
		next[0] = 0;
		int pre = 0, cur = 1;
		
		while(cur < len) {
			if(s.charAt(cur) == s.charAt(pre)) {
				next[cur++] = ++pre;
			} else if(pre > 0){
				pre = next[pre-1];
			} else {
				next[cur++] = 0;
			}
		}
		return next;
	}
	
	
}
