package date0826;

/**
 * 链式队列
 * @author CSH
 * @date 2018年6月25日下午3:08:41
 */
public class LinkedQueue {
	
	private class Node{
		private int data;
		private Node next;
		public Node() {
		}
		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
	
	private Node front;
	private Node rear;
	private Node header;
	
	//初始化链式队列
	public void initLinkedQueue(){
		front=new Node();
		rear=new Node();
		header=new Node();
		front=header;
		rear=header;
	}

	//入队
	public void enQueue(int data){
		Node node=new Node();
		node.data=data;
		if(rear==header){
			rear=node;
			header.next=node;
			front.next=node;
		}else{
			rear.next=node;
			rear=node;
		}
	}
	
	//出队
	public int outQueue(){
		int data;
		if(rear==header){
			System.out.println("队列为空");
			return -1;
		}else{
			data=front.next.data;
			if(rear==front.next){
				front.next=header;
				rear=front;
			}else{
				front.next=front.next.next;
			}
			return data;
		}
	}
	//打印队列
	public void print(){
		System.out.print("打印队列：");
		Node temp=front;
		while(temp!=rear){
			System.out.print(temp.next.data+" ");
			temp=temp.next;
		}
	}
	//队列头数据
	public int getHead(){
		return front.next.data;
	}
	//队列空
	public boolean isEmpty(){
		if(rear==front){
			return true;
		}
		return false;
	}
	public static void main(String[] args) {

		LinkedQueue linkedQueue=new LinkedQueue();
		linkedQueue.initLinkedQueue();
		linkedQueue.enQueue(1);
		linkedQueue.enQueue(2);
		linkedQueue.enQueue(3);
		linkedQueue.outQueue();
		linkedQueue.enQueue(4);
		linkedQueue.print();
	}

}
