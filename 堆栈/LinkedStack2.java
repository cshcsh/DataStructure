package date0826;

/**
 * 
 * @author CSH
 * @date 2018年8月27日下午5:32:14
 */
public class LinkedStack2 {
	
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
	
	
	
	public LinkedStack2() {
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
		LinkedStack2 linkedStack=new LinkedStack2();
		int n=1356;
		int m=8;
		while(n!=0){
			int l=n%m;
			n=n/m;
			linkedStack.push(l);
		}
		while(!linkedStack.isEmpty()){
			System.out.print(linkedStack.pop()+" ");
		}
		
	}
}
