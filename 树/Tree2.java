package date0828;

import java.util.ArrayList;
import java.util.List;

/**
 * �ӽڵ�����ʾ��
 * 
 * @author CSH
 * @date 2018��6��26������3:29:44
 * @param <E>
 */
public class Tree2<E> {

	private static class SonNode {
		// ��¼��ǰ�ڵ��λ��
		private int pos;
		private SonNode next;

		public SonNode(int pos, SonNode next) {
			this.pos = pos;
			this.next = next;
		}
	}

	public static class Node<T> {
		T data;
		// ��¼��һ���ӽڵ�
		SonNode first;

		public Node(T data) {
			this.data = data;
			this.first = null;
		}

		public String toString() {
			if (first != null) {
				return "TreeChild$Node[data=" + data + ", first=" + first.pos + "]";
			} else {
				return "TreeChild$Node[data=" + data + ", first=-1]";
			}
		}
	}

	private final int DEFAULT_TREE_SIZE = 100;
	private int treeSize = 0;
	// ʹ��һ��Node[]��������¼����������нڵ�
	private Node<E>[] nodes;
	// ��¼�ڵ���
	private int nodeNums;

	// ��ָ�����ڵ㴴����
	public Tree2(E data) {
		treeSize = DEFAULT_TREE_SIZE;
		nodes = new Node[treeSize];
		nodes[0] = new Node<E>(data);
		nodeNums++;
	}

	// ��ָ�����ڵ㡢ָ��treeSize������
	public Tree2(E data, int treeSize) {
		this.treeSize = treeSize;
		nodes = new Node[treeSize];
		nodes[0] = new Node<E>(data);
		nodeNums++;
	}

	// Ϊָ���ڵ�����ӽڵ�
	public void addNode(E data, Node parent) {
		for (int i = 0; i < treeSize; i++) {
			// �ҵ������е�һ��Ϊnull��Ԫ�أ���Ԫ�ر����½ڵ�
			if (nodes[i] == null) {
				// �����½ڵ㣬����ָ������Ԫ�ر�����
				nodes[i] = new Node(data);
				if (parent.first == null) {
					parent.first = new SonNode(i, null);
				} else {
					SonNode next = parent.first;
					while (next.next != null) {
						next = next.next;
					}
					next.next = new SonNode(i, null);
				}
				nodeNums++;
				return;
			}
		}
		throw new RuntimeException("�����������޷�����½ڵ�");
	}

	// �ж����Ƿ�Ϊ��
	public boolean empty() {
		// ������Ƿ�Ϊnull
		return nodes[0] == null;
	}

	// ���ظ��ڵ�
	public Node<E> root() {
		// ���ظ��ڵ�
		return nodes[0];
	}

	// ����ָ���ڵ㣨��Ҷ�ӽڵ㣩�������ӽڵ�
	public List<Node<E>> children(Node parent) {

		List<Node<E>> list = new ArrayList<Node<E>>();
		// ��ȡparent�ڵ�ĵ�һ���ӽڵ�
		SonNode next = parent.first;
		// ���ź���������������һ�����ӽڵ�
		while (next != null) {
			// ��Ӻ������еĽڵ�
			list.add(nodes[next.pos]);
			next = next.next;
		}
		return list;

	}

	// ����ָ���ڵ㣨��Ҷ�ӽڵ㣩�ĵ�index���ӽڵ�
	public Node<E> child(Node parent, int index) {
		// ��ȡparent�ڵ�ĵ�һ���ӽڵ�
		SonNode next = parent.first;
		// ���ź���������������һ�����ӽڵ�
		for (int i = 0; next != null; i++) {
			if (index == i) {
				return nodes[next.pos];
			}
			next = next.next;
		}
		return null;
	}

	// ���ظ��������
	public int deep() {
		// ��ȡ���������
		return deep(root());
	}

	// ����һ���ݹ鷽����ÿ�����������Ϊ������������������ + 1
	private int deep(Node node) {
		if (node.first == null) {
			return 1;
		} else {
			// ��¼������������������
			int max = 0;
			SonNode next = node.first;
			// ���ź���������������һ�����ӽڵ�
			while (next != null) {
				// ��ȡ�����ӽڵ�Ϊ�������������
				int tmp = deep(nodes[next.pos]);
				if (tmp > max) {
					max = tmp;
				}
				next = next.next;
			}
			// ��󣬷��������������������� + 1
			return max + 1;
		}
	}

	// ���ذ���ָ��ֵ�ýڵ�
	public int pos(Node node) {
		for (int i = 0; i < treeSize; i++) {
			// �ҵ�ָ���ڵ�
			if (nodes[i] == node) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {

		Tree2<String> tp = new Tree2<String>("root");
		Tree2.Node root = tp.root();
		System.out.println(root);
		tp.addNode("�ڵ�1", root);
		tp.addNode("�ڵ�2", root);
		tp.addNode("�ڵ�3", root);
		System.out.println("����ӽڵ��ĸ���㣺" + root);
		System.out.println("��������ȣ�" + tp.deep());
		// ��ȡ���ڵ�������ӽڵ�
		List<Tree2.Node<String>> nodes = tp.children(root);
		System.out.println("���ڵ�ĵ�һ���ӽڵ㣺" + nodes.get(0));
		// Ϊ���ڵ�ĵ�һ���ӽڵ�����һ���ӽڵ�
		tp.addNode("�ڵ�4", nodes.get(0));
		System.out.println("������һ���ӽڵ㣺" + nodes.get(0));
		System.out.println("��������ȣ�" + tp.deep());

	}

}