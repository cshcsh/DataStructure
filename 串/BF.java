package date0828;

/**
 * 布鲁特-福斯 算法
 * 
 * @author CSH
 * @date 2018年6月26日上午9:31:57
 */
public class BF {

	public static int bf(int pos, String s1, String s2) {
		if (s2.length() == 0) {
			return 0;
		}
		int i = 0, j = 0, start = pos;
		i = start;
		while (i < s1.length() && j < s2.length()) {
			if (s1.charAt(i) == s2.charAt(j)) {
				i++;
				j++;
			} else {
				start++;
				i = start;
				j = 0;
			}
		}
		if (j >= s2.length()) {
			return start;
		} else {
			return -1;
		}
	}

	public static void main(String[] args) {

		System.out.println(bf(4, "12345678", "456"));
	}

}
