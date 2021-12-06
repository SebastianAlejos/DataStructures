import java.util.NoSuchElementException;

public class BinaryTree{
	private Node root;
	private int size;
	
    static class Node {
        int element;
        Node right, left;

        Node(int e){
            element=e;
            this.right=null;
            this.left=null;


        }
    }
    
	
	public int size() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return this.size==0;
	}
	
	public int search(int value) {
		Node current=this.root;
		while(current!=null) {
			if (value == (current.element)) {
				return current.element;
			}else if (value<current.element) {
				current=current.left;
			}else {
				current=current.right;
			}
		}
		throw new NoSuchElementException("Element not in tree");
	}
	
	public void insert(int value) {
		if(this.isEmpty()) {
			this.root=new Node(value);
			System.out.println(this.root);
		}else {
			Node current=this.root,
						  prev;
			while(current!=null) {
				prev=current;
				if (value<current.element) {
					current=current.left;
					System.out.println(current);
				}else {
					current=current.right;
					System.out.println(current);
				}
				if (value<prev.element) {
					prev.left=new Node(value);
					System.out.println(current);
				}else {
					prev.right=new Node(value);
					System.out.println(current);
				}
			}
		}
		this.size++;
	}
	
    public static Node deleteNode(Node root, int value) {
        if (root == null)
            return null;
        if (root.element > value) {
            root.left = deleteNode(root.left, value);
        } else if (root.element < value) {
            root.right = deleteNode(root.right, value);
 
        } else {
            // if nodeToBeDeleted have both children
            if (root.left != null && root.right != null) {
                Node temp = root;
                Node minNodeForRight = minimumElement(temp.right);
                root.element = minNodeForRight.element;
                root.right = deleteNode(root.right, minNodeForRight.element);
 
            }
            else if (root.left != null) {
                root = root.left;
            }
            else if (root.right != null) {
                root = root.right;
            }
            else
                root = null;
        }
        return root;
    }
	
	private void preorden() {
		this.preorden(this.root);
		System.out.println();
	}
	
	private void preorden(Node current){
		if(current!=null) {
			System.out.print(current.element+",");
			preorden(current.left);
			preorden(current.right);
		}
	}
	
	private void inorden() {
		this.inorden(this.root);
		System.out.println();
	}
	
	private void inorden(Node current) {
		if(current!=null) {
			inorden(current.left);
			System.out.print(current.element+",");
			inorden(current.right);
		}
	}
    private void postorder() {
		this.postorder(root);
		System.out.println();
	}

    public void postorder(Node root) {
        if(root !=  null) {
            postorder(root.left);
            postorder(root.right);
        }
    }
    public static Node minimumElement(Node root) {
        if (root.left == null)
            return root;
        else {
            return minimumElement(root.left);
        }
    }

    static int maxElement(Node node){ 
    Node current = node;
    while (current.right != null) 
        current = current.right;
      
    return (current.element);
    }
}