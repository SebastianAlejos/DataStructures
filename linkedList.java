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

    public void instertAtTail(int e) {
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
    public static void main(String[] args) {
        linkedList ll=new linkedList();
        ll.insertAtHead(10);
        ll.insertAtHead(20);
        ll.printList();
    }
}
