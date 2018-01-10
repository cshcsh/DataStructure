package date0826;

/**
 * 顺序表的实现
 * 
 * @author CSH
 * @date 2018年8月26日下午4:13:46
 */
public class ArrayList<E> {
	
	private Object[] data = null; // data: 用来保存此线性表数据的数组
	private int capacity; // capacity： 线性表的容量
	private int current; // current： 当前数据的下标

	/**
	 * 初始化为声明大小，则设置为10。
	 */
	ArrayList() {
		this(10);
	}

	/**
	 * 初始化线性表，声明保存数据的数组大小。
	 * 
	 * @param initialSize
	 *            顺序表的初始化大小
	 */
	ArrayList(int initialSize) {
		if (initialSize >= 0) {
			this.capacity = initialSize;
			data = new Object[initialSize];
			current = 0;
		} else {
			throw new RuntimeException("初始化大小不能小于0：" + initialSize);
		}
	}

	/**
	 * 在线性表的末尾添加元素，添加之前确认线性表是否已满
	 * 
	 * @param e
	 *            待加入的元素
	 * @return
	 */
	public boolean AddElement(E e) {
		ensureCapacity();
		data[current] = e;
		++current;
		return true;
	}

	/**
	 * 检查存储数据的数组容量，如果数组已经满，则扩充容量；否则不操作。
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
	 * 返回下标为index的元素
	 * 
	 * @param index
	 *            欲取得元素的下标
	 * @return
	 */
	public E get(int index) {
		validateIndex(index);
		return (E) data[index];
	}

	/**
	 * 
	 * @param index
	 *            待插入的位置
	 * @param e
	 *            待插入的元素
	 * @return
	 */
	public boolean set(int index, E e) {
		validateIndex(index);
		data[index] = e;
		return true;
	}

	/**
	 * 验证下标值是否合法，非法时抛出异常
	 * 
	 * @param index
	 *            待验证的下标值
	 */
	private void validateIndex(int index) {
		if (index < 0 || index > current) {
			throw new RuntimeException("无效的下标：" + index);
		}
	}

	/**
	 * 返回当前顺序表的大小
	 * 
	 * @return
	 */
	public int size() {
		return current;
	}

	/**
	 * 在指定位置插入指定元素
	 * 
	 * @param index
	 *            待插入的位置
	 * @param e
	 *            待插入的元素
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
	 * 删除下标为index元素
	 * 
	 * @param index
	 *            待删除元素的下标
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
