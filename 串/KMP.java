package date0828;

/**
 * KMP
 * 
 * @author CSH
 * @date 2018年6月26日上午10:11:46
 */
public class KMP {

	public static int kmp(String s1, String s2, int pos, int[] next) {
		int i = pos, j = 0;
		while (i < s1.length() && j < s2.length()) {
			if (j == -1) {
				i++;
				j = 0;
			} else if (s1.charAt(i) == s2.charAt(j)) {
				i++;
				j++;
			} else {
				j = next[j];
			}
		}
		if (j < s2.length()) {
			return -1;
		} else {
			return i - j;
		}

	}

	public static int[] getNext(String s) {
		char[] strKey = s.toCharArray();
		int[] next = new int[strKey.length];
		int j = 0;
		int k = -1;
		next[0] = -1;
		while (j < strKey.length - 1) {
			if (k == -1 || strKey[j] == strKey[k]) {
				next[++j] = ++k;
			} else {
				k = next[k];
			}
		}
		return next;
	}

	public static void main(String[] args) {

		System.out.println(kmp("aabaabaabaac", "aabaac", 0, getNext("aabaac")));
	}

}
