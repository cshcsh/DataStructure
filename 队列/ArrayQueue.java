package date0826;

/**
 * 顺序循环队列的实现
 * @author CSH
 * @date 2018年6月25日下午2:47:24
 */
public class ArrayQueue {

	private int maxLen;
	private int front;
	private int rear;
	private int queueList[];

	// 初始循环队列
	public ArrayQueue(int maxLen) {
		queueList = new int[maxLen];
		this.maxLen = maxLen;
		this.front = 0;
		this.rear = 0;
	}

	// 队列空
	public boolean isEmpty() {
		if (front == rear) {
			return true;
		}
		return false;
	}

	// 队列满
	public boolean isFull() {
		if (((rear + 1) % maxLen) == front) {
			return true;
		} else {
			return false;
		}
	}

	// 取队头元素
	public int queueFront() {
		if (!isEmpty()) {
			int getFront = queueList[(front + 1) % maxLen];
			return getFront;
		} else {
			System.out.println("ERROR:Queue is Empty");
			return -1;
		}
	}

	// 入队
	public void enQueue(int enData) {
		if (isFull() == false) {
			rear = (rear + 1) % maxLen;
			this.queueList[rear] = enData;
		} else {
			System.out.println("ERROR:Queue is Full");
			return;
		}

	}

	// 出队
	public void outQueue() {
		if (isEmpty() == false) {
			front = (front + 1) % maxLen;
		} else {
			System.out.println("ERROR:Queue is Empty");
			return;
		}

	}

	// 打印队列
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
