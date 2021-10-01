public class StackADT<T> implements MyADT<T>{
    private int top;
	private T[] storage;
	
	public StackADT(int size){
		top = -1;
		storage = (T[])(new Object[size]);
	}

	public void add(T element){
        if (isFull()) {
             System.out.println("Overflow. Program Terminated /n");
            System.exit(1);
        } else {
            this.storage[++top]=element;
        }  
	}

    public T pop(){
        if (isEmpty()) {
            System.out.println("Stack is empty - Program terminated");
            System.exit(1);
        }
        return storage[top--];
    }
    public T peek(){
        if (!isEmpty()) {
            return storage[top];
        } 
        System.out.println("Stack is empty");
        return(null);
        
    }

    public Boolean isEmpty(){
		return top == -1;	// or return size() == 0;
	}

    public Boolean isFull(){
		return top == storage.length - 1;	// or return size() == capacity;
	}
 
	public void display(){
		if(top==-1)
			System.out.println("Storage is empty");
		else
			for(int i = top; i > -1; i--)
				System.out.print(storage[i]+" ");
			System.out.println();    
    }
}
