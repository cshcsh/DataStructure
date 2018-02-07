package date0828;

import java.util.List;

/**
 * ��������
 * @author CSH
 * @date 2018��6��28������11:27:33
 */
public class HuffmanTree<T>{
	
	public class Node<T> implements Comparable<Node<T>>{

		private T data;
		private double weight;//Ȩֵ
		private Node<T> left;
		private Node<T> right;
		
		public Node(T data, double weight) {
			this.data = data;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node<T> node) {
			if(node.getWeight()>this.getWeight()){
				return 1;
			}
			if(node.getWeight()<this.getWeight()){
				return -1;
			}
			return 0;
		}
		
		@Override
		public String toString() {
			return "Node [data=" + data + ", weight=" + weight + "]";
		}
		public T getData() {
			return data;
		}
		public void setData(T data) {
			this.data = data;
		}
		public double getWeight() {
			return weight;
		}
		public void setWeight(double weight) {
			this.weight = weight;
		}
		public Node<T> getLeft() {
			return left;
		}
		public void setLeft(Node<T> left) {
			this.left = left;
		}
		public Node<T> getRight() {
			return right;
		}
		public void setRight(Node<T> right) {
			this.right = right;
		}
		
	}
	
	//������������
	public void createTree(){
		if(){
			
		}
	}
	
	//������ȱ�����������
	public List<Node<T>> breadth(){
		
		return null;
	}

	public static void main(String[] args) {

		
	}


}
