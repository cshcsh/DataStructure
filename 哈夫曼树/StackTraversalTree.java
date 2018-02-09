package date0828;

import java.util.Stack;

/**
 * 中序遍历二叉树的非递归算法
 * @author CSH
 * @date 2018年6月26日下午8:35:22
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

	// 添加节点
	public TreeNode addNode(TreeNode parent, Object data, boolean isLeft) {
		if (parent == null) {
			throw new RuntimeException(parent + " 节点为空，不能添加子节点！");
		}
		if (isLeft && parent.left != null) {
			throw new RuntimeException(parent + "节点已有左子节点，不能添加左子节点！");
		}
		if (!isLeft && parent.right != null) {
			throw new RuntimeException(parent + "节点已有右子节点，不能添加右子节点！");
		}
		TreeNode newNode = new TreeNode(data);
		if (isLeft) {
			parent.left = newNode;
		} else {
			parent.right = newNode;
		}
		return newNode;
	}

	// 树是否为空
	public boolean isEmpty() {
		return root.data == null;
	}

	// 获取根节点
	public TreeNode getRoot() {
		if (isEmpty()) {
			throw new RuntimeException("树为空，无法获取根节点！");
		}
		return root;
	}

	// 获取左子节点
	public TreeNode getLeft(TreeNode parent) {
		if (parent == null) {
			throw new RuntimeException(parent + "节点为空，不能获取子节点！");
		}
		return parent.left == null ? null : parent.left;
	}

	// 获取右子节点
	public TreeNode getRight(TreeNode parent) {
		if (parent == null) {
			throw new RuntimeException(parent + "节点为空，不能获取子节点！");
		}
		return parent.right == null ? null : parent.right;
	}

	// 获取指定节点的深度
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

	// 获取树的深度
	public int getTreeDeep() {
		return this.getDeep(root);
	}

	// 先序遍历
	public void preorder(TreeNode root) {
		if (root != null) {
			System.out.print(root.data+" ");
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	//基于栈的中序非递归遍历
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

		StackTraversalTree<String> binTree = new StackTraversalTree<String>("根");

		StackTraversalTree.TreeNode node1 = binTree.addNode(binTree.getRoot(), "根左", true);
		StackTraversalTree.TreeNode node2 = binTree.addNode(binTree.getRoot(), "根右", false);
		StackTraversalTree.TreeNode node3 = binTree.addNode(node2, "根右左", true);
		StackTraversalTree.TreeNode node4 = binTree.addNode(node2, "根右右", false);
		StackTraversalTree.TreeNode node5 = binTree.addNode(node4, "根右右左", true);
		StackTraversalTree.TreeNode node6 = binTree.addNode(node3, "根右左右", false);
		StackTraversalTree.TreeNode node7 = binTree.addNode(node6, "根右左右右", false);
		System.out.println("中序非递归遍历:");
		binTree.midTraversal();
	}

}
