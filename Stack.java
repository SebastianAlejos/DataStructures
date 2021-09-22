public class Stack {
    private int arr[];
	public int top;
	private int capacity;

	Stack(int size)
	{
		arr = new int[size];
		capacity = size;
		top = -1;
	}

	public void push(int x){
        if (isFull()) {
            System.out.println("Overflow. Program Terminated /n");
            System.exit(1);
        } else {
            this.arr[++top]=x;
        }
       
    }

	public int pop()
	{	}

	// Function to return top element in a stack
	public int peek()
	{	}

	// Function to return the size of the stack
	public int size()
	{	
		return top + 1;
	}

	// Function to check if the stack is empty or not
	public Boolean isEmpty()
	{
		return top == -1;	// or return size() == 0;
	}

	// Function to check if the stack is full or not
	public Boolean isFull()
	{
		return top == capacity - 1;	// or return size() == capacity;
	}
	
	public void display_stack()
	{
		if(isEmpty())
			System.out.println("Stack is Empty");
		else
		{
			System.out.print("Elements Inside The Stack: | ");
			for(int i = top; i > -1; i--)
				System.out.print(arr[i] + " | ");
		}
		System.out.println();
	}

	public static void main (String[] args)
	{
		Stack stack = new Stack(5);
		stack.push(5);
	}
}
