package date0828;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * ���Ĵ洢�ṹjavaʵ��
 * ���ĸ��ڵ��ʾ��
 * @author CSH
 * @date 2018��6��26������12:55:32
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

	//���Ƿ�Ϊ��
	public boolean isEmpty(){
		return nodes[0]==null;
	}

	//���ĸ��ڵ�
	public Node<T> root(){
		return nodes[0];
	}
	//Ϊָ���Ľڵ���ӽڵ�
	public void addNode(T data, Node<T> parent) {
        for (int i = 0; i < treeSize; i++) {
            // �ҵ������е�һ��Ϊnull��Ԫ�أ���Ԫ�ر����½ڵ�
            if (nodes[i] == null) {
                // �����½ڵ㣬����ָ��������Ԫ�ر�����
                nodes[i] = new Node<T>(data, pos(parent));
                nodeNums++;
                return;
            }
        }
        throw new RuntimeException("�����������޷�����½ڵ�");
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
			throw new Exception("�����������޷�����½ڵ�");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//����ָ���ڵ��λ��ֵ
	public int pos(Node<T> node){
		for(int i=0;i<treeSize;i++){
			if(nodes[i]==null){
				return i;
			}
		}
		return -1;
	}
	//���ڵ�
	public Node<T> parent(Node<T> node){
		return nodes[node.parent];
	}
	//����ָ���ڵ�����к��ӽڵ�
	public ArrayList<Node<T>> children(Node<T> parent){
		ArrayList<Node<T>> list = new ArrayList<Node<T>>();
		for(int i=0;i<treeSize;i++){
			if(nodes[i]!=null&&nodes[i].parent==pos(parent)){
				list.add(nodes[i]);
			}
		}
		return list;
	}
	//�������
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
