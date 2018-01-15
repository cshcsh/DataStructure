package date0826;

import java.util.Arrays;

class Stack{
	private int maxSize;
	private int top;
	private int[] arr;
	
	public Stack(int size){
		maxSize=size;
		top=-1;
		arr=new int[maxSize];
	}
	//��ջ
	public int pop(){
		return arr[top--];
	}
	//��ջ
	public void push(int value){
		arr[++top]=value;
	}
	//�õ�ջ��Ԫ��
	public int getTop(){
		return arr[top];
	}
	//ջ��
	public boolean isFull(){
		return maxSize-1==top;
	}
	//ջ��
	public boolean isEmpty(){
		return top==-1;
	}
	//ջ������
	public int size(){
		return maxSize;
	}
	@Override
	public String toString() {
		return "Stack [maxSize=" + maxSize + ", top=" + top + ", arr=" + Arrays.toString(arr) + "]";
	}
	
}
class Reverse {
	private String input;

	public Reverse(String input) {
		this.input = input;
	}
	public void doReverse(){
		Stack stack=new Stack(input.length());
		System.out.println(stack);
		for(int i=0;i<stack.size();i++){
			stack.push(Integer.parseInt(String.valueOf(input.charAt(i))));
		}
		System.out.println(stack.getTop());
		while(!stack.isEmpty()){
			System.out.print(stack.pop()+" ");
		}
	}
	
}

public class StackTest {
	
	public static void main(String[] args) {
		Reverse reverse=new Reverse("456789");
		reverse.doReverse();
	}
}
