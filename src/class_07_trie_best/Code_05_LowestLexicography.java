package class_07_trie_best;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一个字符串类型的数组strs，找到一种拼接方式，
 * 使得把所有字符串拼起来之后形成的字符串具有最低的字典序。
 * @author Administrator
 *
 */
public class Code_05_LowestLexicography {

	public static class MyComparator implements Comparator<String> {
		@Override
		public int compare(String a, String b) {
			return (a + b).compareTo(b + a);
		}
	}

	public static String lowestString(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		Arrays.sort(strs, new MyComparator());
		String res = "";
		for (int i = 0; i < strs.length; i++) {
			res += strs[i];
		}
		return res;
	}

	public static void main(String[] args) {
		String[] strs1 = { "jibw", "ji", "jp", "bw", "jibw" };
		System.out.println(lowestString(strs1));

		String[] strs2 = { "ba", "b" };
		System.out.println(lowestString(strs2));//bab

	}

}
