package date0826;

/**
 * ˳��ѭ�����е�ʵ��
 * @author CSH
 * @date 2018��6��25������2:47:24
 */
public class ArrayQueue {

	private int maxLen;
	private int front;
	private int rear;
	private int queueList[];

	// ��ʼѭ������
	public ArrayQueue(int maxLen) {
		queueList = new int[maxLen];
		this.maxLen = maxLen;
		this.front = 0;
		this.rear = 0;
	}

	// ���п�
	public boolean isEmpty() {
		if (front == rear) {
			return true;
		}
		return false;
	}

	// ������
	public boolean isFull() {
		if (((rear + 1) % maxLen) == front) {
			return true;
		} else {
			return false;
		}
	}

	// ȡ��ͷԪ��
	public int queueFront() {
		if (!isEmpty()) {
			int getFront = queueList[(front + 1) % maxLen];
			return getFront;
		} else {
			System.out.println("ERROR:Queue is Empty");
			return -1;
		}
	}

	// ���
	public void enQueue(int enData) {
		if (isFull() == false) {
			rear = (rear + 1) % maxLen;
			this.queueList[rear] = enData;
		} else {
			System.out.println("ERROR:Queue is Full");
			return;
		}

	}

	// ����
	public void outQueue() {
		if (isEmpty() == false) {
			front = (front + 1) % maxLen;
		} else {
			System.out.println("ERROR:Queue is Empty");
			return;
		}

	}

	// ��ӡ����
	public void print() {
		for (int i = front + 1; i <= rear; i++) {
			System.out.print(queueList[i] + " ");
		}
	}

	public static void main(String[] args) {
		ArrayQueue arrayQueue = new ArrayQueue(5);
		arrayQueue.enQueue(1);
		arrayQueue.enQueue(2);
		arrayQueue.enQueue(3);
		arrayQueue.outQueue();
		arrayQueue.enQueue(5);
		System.out.println(arrayQueue.queueFront());
		arrayQueue.print();
	}

}
