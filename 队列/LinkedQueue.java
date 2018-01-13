package date0826;

/**
 * ��ʽ����
 * @author CSH
 * @date 2018��6��25������3:08:41
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
	
	//��ʼ����ʽ����
	public void initLinkedQueue(){
		front=new Node();
		rear=new Node();
		header=new Node();
		front=header;
		rear=header;
	}

	//���
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
	
	//����
	public int outQueue(){
		int data;
		if(rear==header){
			System.out.println("����Ϊ��");
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
	//��ӡ����
	public void print(){
		System.out.print("��ӡ���У�");
		Node temp=front;
		while(temp!=rear){
			System.out.print(temp.next.data+" ");
			temp=temp.next;
		}
	}
	//����ͷ����
	public int getHead(){
		return front.next.data;
	}
	//���п�
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
