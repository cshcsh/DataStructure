package date0826;

/**
 * 
 * @author CSH
 * @date 2018年8月27日下午5:32:14
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
	//入栈
	public void push(int node){
		top=new Node(node, top);
		size++;
	}
	//出栈
	public int pop(){
		if(isEmpty()){
			System.out.println("栈空");
			return -1;
		}
		Node temp=top;
		top=top.next;
		temp.next=null;
		size--;
		return  temp.data;
	}
	//空栈
	public boolean isEmpty(){
		return size==0?true:false; 
	}
	
	//栈的容量
	public int size(){
		return size;
	}
	//获取栈顶元素
	public int getTop(){
		return top.data;
	}
	//遍历栈
	public void display(){
		System.out.print("遍历栈：");
		while(top.next!=null){
			System.out.print(top.data+" ");
			top=top.next;
		}
	}
	
	public static void main(String[] args) {
		LinkedStack linkedStack=new LinkedStack();
		linkedStack.push(1);
		linkedStack.push(2);
		System.out.println("出栈元素："+linkedStack.pop());
		linkedStack.push(3);
		linkedStack.push(4);
		linkedStack.display();
		System.out.println();
		System.out.println("栈的大小："+linkedStack.size);
	}
}
