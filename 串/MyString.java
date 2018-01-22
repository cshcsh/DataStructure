package date0828;

/**
 * 顺序存储结构实现串
 * 
 * @author CSH
 * @date 2018年6月25日下午8:01:14
 */
public class MyString {
	private char[] value;
	private int len;

	public MyString() {
		this.value = new char[0];
		this.len = 0;
	}

	public MyString(String string) {
		this.value = string.toCharArray();
		this.len = value.length;
	}

	public MyString(char[] cs) {
		this.value = cs;// 遍历
		this.len = value.length;
	}

	// 扩容
	public void allocate(int capacity) {
		char[] temp = value;
		value = new char[capacity];
		for (int i = 0; i < temp.length; i++) {
			value[i] = temp[i];
		}
	}

	// 插入
	public MyString insert(int offset, MyString myString) {
		if (offset < 0 || offset > this.len) {
			try {
				throw new Exception("插入位置不合法");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		int l = myString.length();
		int length = l + len;
		if (length > value.length) {
			allocate(length);
		}
		// 精辟小算法
		for (int i = len - 1; i >= offset; i--) {
			value[l + i] = value[i];
		}
		for (int j = 0; j < l; j++) {
			value[j + offset] = myString.charAt(j);
		}
		len = length;
		return this;
	}

	// 删除
	public MyString delete(int begin, int end) {
		// 精辟小算法
		for (int i = 0; i < len - end; i++) {
			value[begin + i] = value[end + i];
		}
		len = len - (end - begin);
		return this;
	}

	// 复制
	public MyString copy() {
		/*MyString myString = new MyString();
		myString.len = this.len;
		for (int i = 0; i < this.len; i++) {
			myString.value[i] = this.value[i];
		}*/
		return this;
	}

	// 判空
	public boolean isEmpty() {
		if (len == 0) {
			return true;
		}
		return false;
	}

	// 比较
	public int compare(MyString str) {
		int len1 = len;
		int len2 = str.length();
		int n = Math.min(len1, len2);
		char[] s1 = value;
		char[] s2 = new char[str.length()];
		for (int i = 0; i < str.length(); i++)
			s2[i] = str.charAt(i);
		int k = 0;
		while (k < n) {
			char ch1 = s1[k];
			char ch2 = s2[k];
			if (ch1 != ch2) {
				return ch1 - ch2;
			}
			k++;
		}
		return len1 - len2;
	}

	// 求串长
	public int length() {
		return len;
	}

	// 清空
	public void clear() {
		this.len = 0;
	}

	// 串连接
	public MyString concat(MyString myString) {
		return insert(len, myString);
	}

	// 求子串
	public MyString sub(int begin, int end) {
		if (begin < 0) {
			try {
				throw new Exception("起始位置不能小于0");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (end > len) {
			try {
				throw new Exception("结束位置大于串当前的长度");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (begin > end) {
			try {
				throw new Exception("起始位置大于结束位置");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (begin == 0 && end == len) {
			return this;
		} else {
			char[] sub = new char[end - begin];
			for (int i = 0; i < sub.length; i++) {
				sub[i] = value[begin + i];
			}
			return new MyString(sub);
		}
	}

	// 打印
	public void print() {
		for (int i = 0; i < len; i++) {
			System.out.print(value[i]);
		}
		System.out.println();
	}

	// 获取字符
	public char charAt(int index) {
		if (index < 0 || index > value.length) {
			try {
				throw new Exception("index不合法");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return value[index];
	}

	public static void main(String[] args) {

		MyString myString=new MyString("123456");
		myString.delete(2, 3).print();
		myString.copy().print();
		myString.insert(3, new MyString("hhh"));
		myString.print();
		System.out.println(myString.charAt(3));
		myString.sub(1, 3).print();
		myString.concat(new MyString("www")).print();
		myString.clear();
		myString.print();
		System.out.println(myString.length());
		System.out.println(myString.isEmpty());
	}

}
