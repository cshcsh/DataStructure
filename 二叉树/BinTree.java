package date0828;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树
 * 
 * @author CSH
 * @date 2018年6月26日下午4:38:23
 */
public class BinTree {

	private BinTree lChild;
	private BinTree rChild;
	private BinTree root;
	private Object data;
	private List<BinTree> datas;

	private int count = 0;

	public BinTree() {
	}

	public BinTree(Object data) {
		this.data = data;
	}

	public BinTree(BinTree lChild, BinTree rChild, Object data) {
		this.lChild = lChild;
		this.rChild = rChild;
		this.data = data;
	}

	// 创建二叉树
	public void createTree(Object[] objects) {
		datas = new ArrayList<>();
		for (Object o : objects) {
			datas.add(new BinTree(o));
		}
		root = datas.get(0);
		for (int i = 0; i < objects.length / 2; i++) {
			datas.get(i).lChild = datas.get(i * 2 + 1);
			if (i * 2 + 2 < datas.size()) {
				datas.get(i).rChild = datas.get(i * 2 + 2);
			}
		}
	}

	// 先序遍历
	public void preorder(BinTree root) {
		if (root != null) {
			if (root.lChild == null && root.rChild == null) {
				print(root.getData());
				count++;
			}
			preorder(root.lChild);
			preorder(root.rChild);
		}
	}

	// 获取节点数据
	public void print(Object object) {
		System.out.print(object + "-->");
	}

	public BinTree getRoot() {
		return root;
	}

	public Object getData() {
		return data;
	}

	// 采用递归算法
	public int leaf(BinTree root) {
		int LeafCount;
		if (root == null){
			LeafCount = 0;
		}else if ((root.lChild == null) && (root.rChild == null))
			LeafCount = 1;
		else{
			/* 叶子数为左右子树的叶子数目之和 */
			LeafCount = leaf(root.lChild) + leaf(root.rChild);
		}
		return LeafCount;
	}

	public static void main(String[] args) {

		BinTree binTree = new BinTree();
		Object[] objects = { 1, 2, 3, 4, 5, 6, 7 };
		binTree.createTree(objects);
		binTree.preorder(binTree.getRoot());
		//System.out.println("\n叶子结点数目:" + binTree.count);
		System.out.println("\n叶子结点数目:"+binTree.leaf(binTree.getRoot()));
	}

}
