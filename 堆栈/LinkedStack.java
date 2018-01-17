package date0826;

/**
 * 
 * @author CSH
 * @date 2018��8��27������5:32:14
 */
public class LinkedStack {
	
	private class Node{
		public int data;
		public Node next;
		public Node() {}
		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
	private Node top;
	private int size;
	
	
	
	public LinkedStack() {
		this.size = 0;
		top=new Node();
		top.data=0;
		top.next=null;
	}
	//��ջ
	public void push(int node){
		top=new Node(node, top);
		size++;
	}
	//��ջ
	public int pop(){
		if(isEmpty()){
			System.out.println("ջ��");
			return -1;
		}
		Node temp=top;
		top=top.next;
		temp.next=null;
		size--;
		return  temp.data;
	}
	//��ջ
	public boolean isEmpty(){
		return size==0?true:false; 
	}
	
	//ջ������
	public int size(){
		return size;
	}
	//��ȡջ��Ԫ��
	public int getTop(){
		return top.data;
	}
	//����ջ
	public void display(){
		System.out.print("����ջ��");
		while(top.next!=null){
			System.out.print(top.data+" ");
			top=top.next;
		}
	}
	
	public static void main(String[] args) {
		LinkedStack linkedStack=new LinkedStack();
		linkedStack.push(1);
		linkedStack.push(2);
		System.out.println("��ջԪ�أ�"+linkedStack.pop());
		linkedStack.push(3);
		linkedStack.push(4);
		linkedStack.display();
		System.out.println();
		System.out.println("ջ�Ĵ�С��"+linkedStack.size);
	}
}
