public class Node<Type> {
		private Node<Type> NextNode;
		private Node<Type> PrevNode;
		private Type _data;
		
		public Node(Type data){
			NextNode=null;
			PrevNode=null;
			_data=data;
		}
		public Node(){
			NextNode=null;
			PrevNode=null;
			_data=null;
		}
		public Type getData()	{
			return this._data;
		}
		public void setNextNode(Node<Type> newNode)	{
			NextNode=newNode;
		}
		public Node<Type> getNextNode()	{
			return NextNode;
		}
		public void setPrevNode(Node<Type> prevNode){
			 PrevNode=prevNode;
		}
		public Node<Type> getPrevNode(){
			return PrevNode;
		}
}//class ends
