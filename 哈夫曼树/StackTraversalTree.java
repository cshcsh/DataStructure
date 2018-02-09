package date0828;

import java.util.Stack;

/**
 * ��������������ķǵݹ��㷨
 * @author CSH
 * @date 2018��6��26������8:35:22
 */
public class StackTraversalTree<T> {
	
	public static class TreeNode {

		Object data;
		TreeNode left;
		TreeNode right;

		public TreeNode() {
		}

		public TreeNode(Object data) {
			this.data = data;
		}

		public TreeNode(Object data, TreeNode left, TreeNode right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}

	}

	private TreeNode root;

	public StackTraversalTree() {
		this.root = new TreeNode();
	}

	public StackTraversalTree(T data) {
		this.root = new TreeNode(data);
	}

	// ��ӽڵ�
	public TreeNode addNode(TreeNode parent, Object data, boolean isLeft) {
		if (parent == null) {
			throw new RuntimeException(parent + " �ڵ�Ϊ�գ���������ӽڵ㣡");
		}
		if (isLeft && parent.left != null) {
			throw new RuntimeException(parent + "�ڵ��������ӽڵ㣬����������ӽڵ㣡");
		}
		if (!isLeft && parent.right != null) {
			throw new RuntimeException(parent + "�ڵ��������ӽڵ㣬����������ӽڵ㣡");
		}
		TreeNode newNode = new TreeNode(data);
		if (isLeft) {
			parent.left = newNode;
		} else {
			parent.right = newNode;
		}
		return newNode;
	}

	// ���Ƿ�Ϊ��
	public boolean isEmpty() {
		return root.data == null;
	}

	// ��ȡ���ڵ�
	public TreeNode getRoot() {
		if (isEmpty()) {
			throw new RuntimeException("��Ϊ�գ��޷���ȡ���ڵ㣡");
		}
		return root;
	}

	// ��ȡ���ӽڵ�
	public TreeNode getLeft(TreeNode parent) {
		if (parent == null) {
			throw new RuntimeException(parent + "�ڵ�Ϊ�գ����ܻ�ȡ�ӽڵ㣡");
		}
		return parent.left == null ? null : parent.left;
	}

	// ��ȡ���ӽڵ�
	public TreeNode getRight(TreeNode parent) {
		if (parent == null) {
			throw new RuntimeException(parent + "�ڵ�Ϊ�գ����ܻ�ȡ�ӽڵ㣡");
		}
		return parent.right == null ? null : parent.right;
	}

	// ��ȡָ���ڵ�����
	private int getDeep(TreeNode node) {
		if (node == null) {
			return 0;
		}
		if (node.left == null && node.right == null) {
			return 1;
		} else {
			int l = getDeep(node.left);
			int r = getDeep(node.right);
			int max = l > r ? l : r;
			return max + 1;
		}
	}

	// ��ȡ�������
	public int getTreeDeep() {
		return this.getDeep(root);
	}

	// �������
	public void preorder(TreeNode root) {
		if (root != null) {
			System.out.print(root.data+" ");
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	//����ջ������ǵݹ����
	public void midTraversal(){

		Stack<TreeNode> stack=new Stack<>();
		TreeNode treeNode=root;
        while( treeNode!=null || !stack.isEmpty() ){
            while(treeNode!=null){
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            treeNode = stack.pop();
            System.out.print(treeNode.data+" ");
            treeNode= treeNode.right;
        }
    }

	public static void main(String[] args) {

		StackTraversalTree<String> binTree = new StackTraversalTree<String>("��");

		StackTraversalTree.TreeNode node1 = binTree.addNode(binTree.getRoot(), "����", true);
		StackTraversalTree.TreeNode node2 = binTree.addNode(binTree.getRoot(), "����", false);
		StackTraversalTree.TreeNode node3 = binTree.addNode(node2, "������", true);
		StackTraversalTree.TreeNode node4 = binTree.addNode(node2, "������", false);
		StackTraversalTree.TreeNode node5 = binTree.addNode(node4, "��������", true);
		StackTraversalTree.TreeNode node6 = binTree.addNode(node3, "��������", false);
		StackTraversalTree.TreeNode node7 = binTree.addNode(node6, "����������", false);
		System.out.println("����ǵݹ����:");
		binTree.midTraversal();
	}

}
