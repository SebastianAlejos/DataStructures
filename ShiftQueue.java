import javax.swing.JOptionPane;

public class ShiftQueue {
    private int arr[];
	private int front,
               rear, 
               capacity;

	public ShiftQueue(int size){
		this.arr = new int[size];
		this.capacity = size;
		this.front=this.rear=0;
	}

	public void enQueue(int x){
        if (isFull()) {
            System.out.println("Overflow. Program Terminated /n");
            System.exit(1);
        } else {
            this.arr[rear++]=x;
        }
    }

	public int deQueue(){
        int n=this.arr[front];
        if (isEmpty()) {
            System.out.println("Queue is empty - Program terminated");
            System.exit(1);
        } else {
            for (int i = 0; i < rear - 1; i++) {
                arr[i] = arr[i + 1];
            }if (rear < capacity){
                arr[rear] = 0;
            }
            rear--;
        }
        return n;
    }


	// Function to check if the stack is empty or not
	public Boolean isEmpty(){
		return front == rear;	// or return size() == 0;
	}

	// Function to check if the stack is full or not
	public Boolean isFull(){
		return rear == capacity - 1;	// or return size() == capacity;
	}
	
	public void display_queue()
	{
		if(isEmpty())
			System.out.println("Queue is Empty");
		else{
			System.out.print("Elements Inside The Queue: | ");
			for (int i = front; i < rear; i++) {
				System.out.printf(" ", arr[i]);
			}
		}
	}

	public static void main (String[] args)
	{
		Queue queue = new Queue(5);
		int choice=0;
		while (choice!=4) {
			choice=Integer.parseInt(JOptionPane.showInputDialog("What do you want to do? \n 1. enQueue \n 2. deQueue \n 3. Display \n 4. Exit"));
			switch (choice) {
				case 1:
					int n=Integer.parseInt(JOptionPane.showInputDialog("What number do you want to queue?"));
					queue.enQueue(n);
					break;
				case 2:
					n=Integer.parseInt(JOptionPane.showInputDialog("What number do you want to dequeue?"));
					queue.deQueue();
					break;
				case 3:
					queue.display_queue();
					break;
				case 4:
					System.exit(4);
			}
		}
	}
}

