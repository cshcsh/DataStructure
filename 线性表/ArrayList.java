package date0826;

/**
 * ˳����ʵ��
 * 
 * @author CSH
 * @date 2018��8��26������4:13:46
 */
public class ArrayList<E> {
	
	private Object[] data = null; // data: ������������Ա����ݵ�����
	private int capacity; // capacity�� ���Ա������
	private int current; // current�� ��ǰ���ݵ��±�

	/**
	 * ��ʼ��Ϊ������С��������Ϊ10��
	 */
	ArrayList() {
		this(10);
	}

	/**
	 * ��ʼ�����Ա������������ݵ������С��
	 * 
	 * @param initialSize
	 *            ˳���ĳ�ʼ����С
	 */
	ArrayList(int initialSize) {
		if (initialSize >= 0) {
			this.capacity = initialSize;
			data = new Object[initialSize];
			current = 0;
		} else {
			throw new RuntimeException("��ʼ����С����С��0��" + initialSize);
		}
	}

	/**
	 * �����Ա��ĩβ���Ԫ�أ����֮ǰȷ�����Ա��Ƿ�����
	 * 
	 * @param e
	 *            �������Ԫ��
	 * @return
	 */
	public boolean AddElement(E e) {
		ensureCapacity();
		data[current] = e;
		++current;
		return true;
	}

	/**
	 * ���洢���ݵ�������������������Ѿ��������������������򲻲�����
	 */
	private void ensureCapacity() {
		int index;
		if (current == capacity) {
			capacity *= 2;
			Object[] newData = new Object[capacity];
			for (index = 0; index < current; ++index) {
				newData[index] = data[index];
			}
			data = newData;
		}
	}

	/**
	 * �����±�Ϊindex��Ԫ��
	 * 
	 * @param index
	 *            ��ȡ��Ԫ�ص��±�
	 * @return
	 */
	public E get(int index) {
		validateIndex(index);
		return (E) data[index];
	}

	/**
	 * 
	 * @param index
	 *            �������λ��
	 * @param e
	 *            �������Ԫ��
	 * @return
	 */
	public boolean set(int index, E e) {
		validateIndex(index);
		data[index] = e;
		return true;
	}

	/**
	 * ��֤�±�ֵ�Ƿ�Ϸ����Ƿ�ʱ�׳��쳣
	 * 
	 * @param index
	 *            ����֤���±�ֵ
	 */
	private void validateIndex(int index) {
		if (index < 0 || index > current) {
			throw new RuntimeException("��Ч���±꣺" + index);
		}
	}

	/**
	 * ���ص�ǰ˳���Ĵ�С
	 * 
	 * @return
	 */
	public int size() {
		return current;
	}

	/**
	 * ��ָ��λ�ò���ָ��Ԫ��
	 * 
	 * @param index
	 *            �������λ��
	 * @param e
	 *            �������Ԫ��
	 * @return
	 */
	public boolean insert(int index, E e) {
		validateIndex(index);
		ensureCapacity();
		for (int temp = current; temp > index; --temp) {
			data[temp] = data[temp - 1];
		}
		data[index] = e;
		return true;
	}

	/**
	 * ɾ���±�ΪindexԪ��
	 * 
	 * @param index
	 *            ��ɾ��Ԫ�ص��±�
	 * @return
	 */
	public boolean delete(int index) {
		validateIndex(index);
		for (; index < current - 1; ++index) {
			data[index] = data[index + 1];
		}
		data[current - 1] = null;
		--current;
		return true;
	}

	@Override
	public String toString() {
		String str = "[ ";
		for (Object o : data) {
			if (o != null) {
				str += o + " ";
			}
		}
		str += "]";
		return str;
	}
}
