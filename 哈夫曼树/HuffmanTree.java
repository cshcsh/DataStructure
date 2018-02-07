package date0828;

import java.util.List;

/**
 * 哈夫曼树
 * @author CSH
 * @date 2018年6月28日上午11:27:33
 */
public class HuffmanTree<T>{
	
	public class Node<T> implements Comparable<Node<T>>{

		private T data;
		private double weight;//权值
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
	
	//创建哈夫曼树
	public void createTree(){
		if(){
			
		}
	}
	
	//广度优先遍历哈夫曼树
	public List<Node<T>> breadth(){
		
		return null;
	}

	public static void main(String[] args) {

		
	}


}
