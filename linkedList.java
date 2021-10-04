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
    public static void main(String[] args) {
        linkedList ll=new linkedList();
        ll.insertAtHead(10);
        ll.insertAtHead(20);
        ll.printList();
    }
}
