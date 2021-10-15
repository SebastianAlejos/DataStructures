import javax.swing.JOptionPane;

public class linkedList {
    Node head;
    Node tail;

    static class Node {
        int element;
        Node next;

        Node(int e){
            element=e;
            next=null;
        }
    }

    public void insertAtHead(int e) {
        Node new_Node = new Node(e);
        if (this.head==null) {
            this.head=this.tail=new_Node;
        }else{
            new_Node.next=this.head;
            this.head=new_Node;
        }
    }
    
    public void printList() {
        Node n=this.head;
        while (n!=null) {
            System.out.print(n.element+" ");
            n=n.next;
        }
    }

    public void insertAtTail(int e) {
        Node new_Node=new Node(e);
        if (this.head==null) {
            this.head=tail=new_Node;
        } else {
            this.tail.next=new_Node;
            this.tail=new_Node;
        }
    }

    public int getListSize() {
        Node n=this.head;
        int count=0;
        while (n!=null) {
            count++;
            n=n.next;
        }
        return count;
    }

    public void deleteAtHead() {
        if (getListSize()==0) {
            System.out.println("List is empty, nothing to delete!");
        } else if(this.head==this.tail) {
            this.head=this.tail=null;
        }else{
            this.head=this.head.next;
        }
    }
    public void deleteAtTail() {
        int listSize= getListSize();
        if (listSize==0) {
            System.out.println("List is empty, nothing to delete!");    
        }else if(this.head==this.tail){
            this.head=this.tail=null;
        }else{
            Node n=this.head;
            for (int i = 0; i < listSize-2; i++) {
                n=n.next;
            }
            this.tail=n;
            this.tail.next=null;
        }
    }
    public void insertAtLocation(int loc, int e) {
        Node new_Node=new Node(e);
        Node n = this.head;
        int track=0;
        if(loc>getListSize()+1){
            System.out.println("Can't insert at location. Location out of bounds.");
        }
        else if(loc==1){
            insertAtHead(e);
        }
        else if(loc == (getListSize()+1)){
            insertAtTail(e);
        }
        else{
            while(track+2<loc){
                track++;
                n=n.next;
            }
            new_Node.next=n.next;
            n.next=new_Node;
        }
    }
    public static void main(String[] args) {
        linkedList ll  = new linkedList();
		int choice=0;
		while (choice!=4) {
			choice=Integer.parseInt(JOptionPane.showInputDialog("What do you want to do? \n 1. Insert at Head \n 2. Insert at Tail \n 3. Delete at Head \n4. Delete at Tail \n5. Insert at Position \n6. Delete at Position \n7. Display List \n 8. Exit Program"));
			switch (choice) {
				case 1:
					int n=Integer.parseInt(JOptionPane.showInputDialog("What number do you want to insert?"));
					ll.insertAtHead(n);
					break;
				case 2:
                    n=Integer.parseInt(JOptionPane.showInputDialog("What number do you want to insert?"));
                    ll.insertAtTail(n);
                    break;
				case 3:
                    n=Integer.parseInt(JOptionPane.showInputDialog("What number do you want to insert?"));
                    ll.insertAtHead(n);
                    break;
				case 4:
                    ll.deleteAtHead();
                    System.out.println("Number deleted");
                    break;
                case 5:
                    int l=Integer.parseInt(JOptionPane.showInputDialog("Where do you want to insert?"));
                    n=Integer.parseInt(JOptionPane.showInputDialog("What number do you want to insert?"));
                    ll.insertAtLocation(l,n);
                    break;
			}
		}
    }
}
