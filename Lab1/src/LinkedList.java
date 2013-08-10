public class LinkedList <Type>{
	Node<String> head= new Node<String>();
	Node<String> tail=new Node<String>();
	public LinkedList(){
		head=null;
		tail=null;
	}
	public void insert(String data){
	Node<String> newNode=new Node<String>(data);
	if(head==null){
		head=newNode;
		tail=newNode;
		newNode.setNextNode(null);
		newNode.setPrevNode(null);
	}
	else{/*insert at the end*/	
		newNode.setNextNode(null);
		newNode.setPrevNode(tail);
		tail.setNextNode(newNode);
		tail=newNode;		
		}
	}
	public void insert_After(Node<String> x,Node<String> A){		
		if(A==tail){
			A.setNextNode(x);
			x.setPrevNode(A);
			x.setNextNode(null);
			tail=x;
		}
		else{
			x.setNextNode(A.getNextNode());
			x.setPrevNode(A);
			(A.getNextNode()).setPrevNode(x);
			A.setNextNode(x);
		}
	}
	public Node<String> search(String data){
		Node<String> temp=new Node<String>();
		temp=head;
		while(temp!=null &&   !temp.getData().equals(data) ){
			temp=temp.getNextNode();
		}
		return temp;
	}
	public Node<String> delete(String data){
		Node<String> temp=new Node<String>();
		temp=this.search(data);
		if(temp==null)	return null;
		if(temp.getNextNode()==null){
			tail=temp.getPrevNode();
			temp.getPrevNode().setNextNode(null);
			
		}
		else if(temp.getPrevNode()==null){
			head=temp.getNextNode();
			head.getNextNode().setPrevNode(null);
		}
		else if(temp.getNextNode()==null && temp.getPrevNode()==null){
			head=null;
			tail=null;
		}
		else{
			temp.getNextNode().setPrevNode(temp.getPrevNode());
			temp.getPrevNode().setNextNode(temp.getNextNode());
		}
		return temp;
	}	
	void delete(Node<String> nodeToBeDeleted){
		if(nodeToBeDeleted==null)	return;
		if(nodeToBeDeleted.getNextNode()==null && nodeToBeDeleted.getPrevNode()==null)
		{
			head=null;
			tail=null;
		}
		else if(nodeToBeDeleted.getNextNode()==null)
		{
			tail=nodeToBeDeleted.getPrevNode();
			nodeToBeDeleted.getPrevNode().setNextNode(null);
			
		}
		else if(nodeToBeDeleted.getPrevNode()==null)
		{
			head=nodeToBeDeleted.getNextNode();
			head.getNextNode().setPrevNode(null);
		}
		else
		{
			nodeToBeDeleted.getNextNode().setPrevNode(nodeToBeDeleted.getPrevNode());
			nodeToBeDeleted.getPrevNode().setNextNode(nodeToBeDeleted.getNextNode());
		}
	}
	public void display()
	{
		Node<String> temp1=new Node<String>();
		temp1=head;
		while(temp1!=null)
		{
			System.out.print(temp1.getData() +" ");
			temp1=temp1.getNextNode();
		}
	}
	void revSublist(String key1,String key2){		
		Node<String> start=new Node<String>();
		Node<String> stop=new Node<String>();		
		Node<String> prev=new Node<String>();
		Node<String> current=new Node<String>();
		Node<String> next=new Node<String>();
			start=(this.search(key1)).getPrevNode();
			stop =(this.search(key2)).getNextNode();
			prev=start;
			current=this.search(key1);
			next=current.getNextNode();		
			while(current!=stop){	//current!=stop
					if(next==stop){			
						current.setPrevNode(start);
						current.setNextNode(prev);
						if(start==null){	
							head=current;
							break;
						}	
						else	
							start.setNextNode(current); //instead  current=head;	(if key1==head)
					}
					if(prev==start){
						current.setPrevNode(next);
						current.setNextNode(stop);
						if(stop==null)
							tail=current;
						else
							stop.setPrevNode(current);	//instead current=tail		
					}
					else{
						current.setPrevNode(next);
						current.setNextNode(prev);
						prev.setPrevNode(current);								
					}
					prev=current;
					current=next;
					if(next!=null)	next=next.getNextNode();
				}					
	}
	Node<String> getElementAhead(Node<String> node,int n){
		if(node==null) return null;
		while(n>0){
			if(node.getNextNode()==null) return null;
			node=node.getNextNode();
			n--;
		}
		return node;
	}
	Node<String> getElementBehind(Node<String> node,int n){
		if(node==null) return null;
		while(n>0){
			if(node.getPrevNode()==null) return null;
			node=node.getPrevNode();
			n--;
		}
		return node;		
	}
	void swapNodes(Node<String> node1,Node<String> node2){		
		Node<String> tempNode=new Node<String>();		
		if(node2==tail){
			tempNode=node1.getPrevNode();	
			this.delete(node1);		
			this.insert_After(node1,node2);
		
			this.delete(node2);
			this.insert_After(node2, tempNode);
		}
		else{
			tempNode=node1.getPrevNode();	
			this.delete(node1);		
			this.insert_After(node1,node2);
			this.delete(node2);
			this.insert_After(node2, tempNode);
		}
	}
	void revSubSeq(int n){
		Node<String> A=new Node<String>();	
		Node<String> B=new Node<String>();	
		Node<String> tempNode=new Node<String>();	
		A=head.getNextNode();
		tempNode=A;
		while(tempNode!=null){			
			B=tempNode;
			if(tempNode==tail){
				B=tempNode;
				break;
			}
			else{
				B=tempNode;
				tempNode=getElementAhead(tempNode, n);				
			}
		}
		while(A!=B){			
			if(getElementAhead(A, n)==B){
				swapNodes(A,B);
				tempNode=A;A=B;B=tempNode;		
				break;
			}
			swapNodes(A,B);
			tempNode=A;A=B;B=tempNode;		
			A=getElementAhead(A, n);
			B=getElementBehind(B, n);
		}
	}
}
