package date0828;

/**
 * ��������ʽ�洢�Ķ�����
 * 
 * @author CSH
 * @date 2018��6��26������7:11:25
 */
public class LinkBinTree<T> {

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

	public LinkBinTree() {
		this.root = new TreeNode();
	}

	public LinkBinTree(T data) {
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

	public static void main(String[] args) {

		LinkBinTree<String> binTree = new LinkBinTree<String>("��");

		LinkBinTree.TreeNode node1 = binTree.addNode(binTree.getRoot(), "����", true);
		LinkBinTree.TreeNode node2 = binTree.addNode(binTree.getRoot(), "����", false);
		LinkBinTree.TreeNode node3 = binTree.addNode(node2, "������", true);
		LinkBinTree.TreeNode node4 = binTree.addNode(node2, "������", false);
		LinkBinTree.TreeNode node5 = binTree.addNode(node4, "��������", true);
		LinkBinTree.TreeNode node6 = binTree.addNode(node3, "��������", false);
		LinkBinTree.TreeNode node7 = binTree.addNode(node6, "����������", false);

		System.out.println("node2�����ӽڵ㣺" + binTree.getLeft(node2).data);
		System.out.println("node2�����ӽڵ㣺" + binTree.getRight(node2).data);

		System.out.println("������ȣ�" + binTree.getTreeDeep());
		
		binTree.preorder(binTree.getRoot());

	}

}
