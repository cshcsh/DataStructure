package date0826;

class Node{
	private int data;
	private Node next;
	public Node(int data){
		this.data=data;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	
}

class LinkList {

	private Node head;
	private int length=0;
	
	//��ӡ
	public void print(){
		Node p=head;
		while(p!=null){
			System.out.print(p.getData()+"-->");
			p=p.getNext();
		}
		System.out.println("null");
		System.out.println("�����ȣ�"+length);
	}
	//��ӽڵ�
	public void addNode(int data){
		Node n=new Node(data);
		if(head==null){
			head=n;
			length++;
			return;
		}
		Node p=head;
		while(p.getNext()!=null){
			p=p.getNext();
		}
		p.setNext(n);
		length++;
		
	}
	//ɾ���ڵ�
	public boolean deleteNode(int index){
		if(index<1||index>length){
			return false;
		}
		int i=1;
		Node p=head;
		while(i<index-1){
			p=p.getNext();
			i++;
		}
		p.setNext(p.getNext().getNext());
		length--;
		return true;
	}
	//���ҽڵ�
	public boolean findNode(int data){
		Node p=head;
		while(p!=null){
			if(data==p.getData()){
				return true;
			}
			p=p.getNext();
		}
		return false;
	}
	//�޸Ľڵ�
	public boolean updateNode(int index,int data){
		if(index<1||index>length){
			return false;
		}
		Node p=head;
		int i=1;
		while(i<index){
			p=p.getNext();
			i++;
		}
		p.setData(data);
		return true;
	}
	//�ж������Ƿ�Ϊ��
	public boolean isEmpty(){
		if(head==null){
			return true;
		}
		return false;
	}
	//����ð������
	public void sortLinkList(){
		for(int i=0;i<length-1;i++){
			Node p=head;
			for(int j=0;j<length-1-i;j++){
				if(p.getData()>p.getNext().getData()){
					int temp=p.getData();
					p.setData(p.getNext().getData());
					p.getNext().setData(temp);
				}
				p=p.getNext();
			}
		}
	}
	public Node getHead() {
		return head;
	}
	public void setHead(Node head) {
		this.head = head;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	
}
public class LinkListTest{
	
	public static void main(String[] args) {
		
		LinkList linkList=new LinkList();
		linkList.addNode(1);
		linkList.addNode(2);
		linkList.addNode(3);
		linkList.addNode(4);
		linkList.addNode(5);
		linkList.print();
		linkList.deleteNode(3);
		linkList.print();
		System.out.println(linkList.findNode(9));
		System.out.println(linkList.isEmpty());
		linkList.updateNode(1, 12);
		linkList.print();
		linkList.sortLinkList();
		linkList.print();
	}
}
