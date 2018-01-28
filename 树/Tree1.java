package date0828;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 树的存储结构java实现
 * 树的父节点表示法
 * @author CSH
 * @date 2018年6月26日下午12:55:32
 */
public class Tree1<T> {

	public static class Node<T>{
		T data;
		int parent;
		public Node() {
		}
		public Node(T data) {
			this.data = data;
		}
		public Node(T data, int parent) {
			this.data = data;
			this.parent = parent;
		}
		@Override
		public String toString() {
			return "Node [data=" + data + ", parent=" + parent + "]";
		}
	}
	
	private static final int DEFAULT_TREE_SIZE=100;
	private int treeSize=0;
	private Node<T>[] nodes;
	private int nodeNums=0;
	
	public Tree1(T data) {
		treeSize=DEFAULT_TREE_SIZE;
		this.nodes=new Node[treeSize];
		nodes[0]=new Node<T>(data,-1);
		nodeNums++;
	}

	public Tree1(int treeSize, T data) {
		this.treeSize=treeSize;
		this.nodes=new Node[treeSize];
		nodes[0]=new Node<T>(data,-1);
		nodeNums++;
	}

	//树是否为空
	public boolean isEmpty(){
		return nodes[0]==null;
	}

	//树的根节点
	public Node<T> root(){
		return nodes[0];
	}
	//为指定的节点添加节点
	public void addNode(T data, Node<T> parent) {
        for (int i = 0; i < treeSize; i++) {
            // 找到数组中第一个为null的元素，该元素保存新节点
            if (nodes[i] == null) {
                // 创建新节点，并用指定的数组元素保存它
                nodes[i] = new Node<T>(data, pos(parent));
                nodeNums++;
                return;
            }
        }
        throw new RuntimeException("该树已满，无法添加新节点");
    }
	
	
	public void addNode2(T data,Node parent){
		for(int i=0;i<treeSize;i++){
			if(nodes[i]==null){
				nodes[i]=new Node(data, pos(parent));
				nodeNums++;
				return;
			}
		}
		try {
			throw new Exception("该树已满，无法添加新节点");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//返回指定节点的位置值
	public int pos(Node<T> node){
		for(int i=0;i<treeSize;i++){
			if(nodes[i]==null){
				return i;
			}
		}
		return -1;
	}
	//父节点
	public Node<T> parent(Node<T> node){
		return nodes[node.parent];
	}
	//返回指定节点的所有孩子节点
	public ArrayList<Node<T>> children(Node<T> parent){
		ArrayList<Node<T>> list = new ArrayList<Node<T>>();
		for(int i=0;i<treeSize;i++){
			if(nodes[i]!=null&&nodes[i].parent==pos(parent)){
				list.add(nodes[i]);
			}
		}
		return list;
	}
	//树的深度
	public int deep(){
		int max=0;
		for(int i=0;i<treeSize&&nodes[i]!=null;i++){
			int def=1;
			int m=nodes[i].parent;
			while(m!=-1&&nodes[m]!=null){
				m=nodes[m].parent;
				def++;
			}
			if(max<def){
				max=def;
			}
		}
		return max;
	}
	public static void main(String[] args) {

		Tree1<String> tree1=new Tree1<String>("root");
		Node root=tree1.root();
		System.out.println(root);
		//tree1.addNode("t1", root);
		System.out.println(tree1.deep());
		System.out.println(tree1.isEmpty());
		//tree1.addNode("t2", root);
		//tree1.addNode("t3", root);
		ArrayList<Node<String>> list=tree1.children(root);
		Iterator<Node<String>> iterator=list.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}

}
