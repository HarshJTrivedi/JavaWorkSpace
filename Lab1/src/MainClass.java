import java.util.Scanner; /// does it change???
public class MainClass {
	public static void main(String args[]) {
		LinkedList<String> listObj=new LinkedList<String>();
		Scanner sc=new Scanner(System.in);		
		int choiceOfOperation;
		String choiceToContinue="y";
				
		while(choiceToContinue.equalsIgnoreCase("y")){		
			System.out.println("Enter: " +
					"\n1 to ADD Elements" +
					"\n2 to SEARCH Element (first occurence)" +
					"\n3 to DELETE element" +
					"\n4 to reverese a SUBLIST" +
					"\n5 to reverese a SUBSEQUENCE :");
			choiceOfOperation=sc.nextInt();		
			if(choiceOfOperation==1){	// add elements
				System.out.println("Enter the Number of Elements that you want to ADD in the list:");	
				int n=sc.nextInt();
				System.out.println("Enter " +n +" the elements:");
				for(int i=0;i<n;i++){
					listObj.insert(sc.next());
				}		
				System.out.println("The updated list is:");
				listObj.display();
			}
			if(choiceOfOperation==2){	// search element
				System.out.println("\nEnter the element you want to search:");
				String key=sc.next(); 
				if(listObj.search((String)key)==null)
					System.out.println("The element is not present!");
				else
					System.out.println("The element is present!");
			}
			if(choiceOfOperation==3){	//delete element
				System.out.println("Enter the element you want to delete:");
				String key=sc.next();		
				Node<String> tempNode=new Node<String>();
				tempNode=listObj.search(key);
				if(tempNode==null){						
					System.out.println("\nInvalid delete operation. No such elemnet found.");
				}
				else{
					listObj.delete(tempNode);
					System.out.println("\nDelete operation Successfull.");						
				}
				System.out.println("The updated list is:");
				listObj.display();
			}
			if(choiceOfOperation==4){ // check sublist
				System.out.println("\nEnter two elements between which you want to change the list. (Both elements are inclusive)");	
			//	int m=sc.nextInt();
			//	int n=sc.nextInt();
				String m=sc.next();
				String n=sc.next();
				if(listObj.search(m)==null || listObj.search(n)==null){
					System.out.println("Either of the entered element is not present. Invalid Inputs!!");
				}
				else{
					listObj.revSublist(m,n);		/// the case in which either of the entered elemnet is tail or head is yet to be considered.
					System.out.println("The updated list is:");
					listObj.display();
				}
			}
	/*		{//check swapping
				listObj.swapNodes(listObj.search(2), listObj.search(4));			
				System.out.println("\nThe updated List is:");
				listObj.display();
			}
			
			{	//check ahead back
				System.out.println("   "+listObj.getElementBehind(listObj.search(2), 1).getData());
			}
	*/			
			if(choiceOfOperation==5){//check subseq
				System.out.println("\n\nEnter the Number of elements that you want to leave after each element in defining a sequence ::" +
						"\n\n{eg. 2 for the sequence of elements on even position : 1 * 4 * 3 * 7 * 9 * " +
						"\nand 3 for sequence of elements with 2 elements between 2 elements in sequence" +
						"\n 1 * 3 5 * 2 9 * 0 7 * 6 1 * 2  The elements replaceing * would be forming sequence to be inverted}");				
				int n=sc.nextInt();
				listObj.revSubSeq(n);
				System.out.println("The updated list is:");
				listObj.display();
			}			
			Scanner tempScanner=new Scanner(System.in);	
			System.out.println("\nDo you want to continue: Enter 'y' to continue and anything else to stop::");
			choiceToContinue=tempScanner.nextLine();
		}	
		System.out.println("\n------Thanks For using this Program!!!----");		
	}//main ends
}//class ends