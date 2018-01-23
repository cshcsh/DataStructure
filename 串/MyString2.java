package date0828;

/**
 * ����ʽ�洢�ṹʵ�ִ�
 * 
 * @author CSH
 * @date 2018��6��25������8:01:14
 */
public class MyString2 {
	
	class Node{
		private char[] value;
		private Node next;
		public Node() {
		}
		public Node(String string) {
			for(int i=0;i<string.length();i++){
				value[i]=string.charAt(i);
			}
			this.next=null;
		}
		
	}
	
	private Node head;
	private Node tail;
	private int length;

	public MyString2() {
		this.head = new Node();
		this.tail=new Node();
		this.length = 0;
	}
	
	public MyString2(String string) {
		this.head = new Node(string);
		this.tail=new Node();
		this.length = 1;
	}

	// ����
	/*public void allocate(int capacity) {
		char[] temp = value;
		value = new char[capacity];
		for (int i = 0; i < temp.length; i++) {
			value[i] = temp[i];
		}
	}*/

	// ����
	/*public MyString2 insert(int offset, MyString2 myString) {
		if (offset < 0 || offset > this.len) {
			try {
				throw new Exception("����λ�ò��Ϸ�");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		int l = myString.length();
		int length = l + len;
		if (length > value.length) {
			allocate(length);
		}
		// ����С�㷨
		for (int i = len - 1; i >= offset; i--) {
			value[l + i] = value[i];
		}
		for (int j = 0; j < l; j++) {
			value[j + offset] = myString.charAt(j);
		}
		len = length;
		return this;
	}

	// ɾ��
	public MyString2 delete(int begin, int end) {
		// ����С�㷨
		for (int i = 0; i < len - end; i++) {
			value[begin + i] = value[end + i];
		}
		len = len - (end - begin);
		return this;
	}

	// ����
	public MyString2 copy() {
		MyString myString = new MyString();
		myString.len = this.len;
		for (int i = 0; i < this.len; i++) {
			myString.value[i] = this.value[i];
		}
		return this;
	}

	// �п�
	public boolean isEmpty() {
		if (len == 0) {
			return true;
		}
		return false;
	}

	// �Ƚ�
	public int compare(MyString2 str) {
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

	// �󴮳�
	public int length() {
		return len;
	}

	// ���
	public void clear() {
		this.len = 0;
	}

	// ������
	public MyString2 concat(MyString2 myString) {
		return insert(len, myString);
	}

	// ���Ӵ�
	public MyString2 sub(int begin, int end) {
		if (begin < 0) {
			try {
				throw new Exception("��ʼλ�ò���С��0");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (end > len) {
			try {
				throw new Exception("����λ�ô��ڴ���ǰ�ĳ���");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (begin > end) {
			try {
				throw new Exception("��ʼλ�ô��ڽ���λ��");
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
			return new MyString2(sub);
		}
	}

	// ��ӡ
	public void print() {
		for (int i = 0; i < len; i++) {
			System.out.print(value[i]);
		}
		System.out.println();
	}

	// ��ȡ�ַ�
	public char charAt(int index) {
		if (index < 0 || index > value.length) {
			try {
				throw new Exception("index���Ϸ�");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return value[index];
	}*/

	public static void main(String[] args) {

		/*MyString2 myString=new MyString2("123456");
		myString.delete(2, 3).print();
		myString.copy().print();
		myString.insert(3, new MyString2("hhh"));
		myString.print();
		System.out.println(myString.charAt(3));
		myString.sub(1, 3).print();
		myString.concat(new MyString2("www")).print();
		myString.clear();
		myString.print();
		System.out.println(myString.length());
		System.out.println(myString.isEmpty());*/
	}

}
