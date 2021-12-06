//Sebastian Alejos Acosta
class Node
{
	int element, color;
	Node parent, left, right;
	
	public Node() {
		left = right = null;
		color = 1; //color 0-BLACK, 1-RED
	}
	
	public Node(int n ) {
		element = n;
		left = right = null;
		color = 1;
	}
}

public class RBT {
	Node root, TNULL; 
	

	RBT() {
		TNULL = new Node();
		TNULL.color = 0;
		TNULL.left = null;
		TNULL.right = null;
		root = TNULL;
	}
	
	void RBInsert(int data) {
		Node z = new Node(data);
		Node y = TNULL;
		Node x = root;
		
		while (x != TNULL) {
			y = x;
			
			if (data < x.element)
				x = x.left;
			else 
				x = x.right;
		}
		
		z.parent = y;
		
		if (y == TNULL)
			root = z;
		else if (data < y.element)
			y.left = z;
		else
			y.right = z;
		
		z.left = TNULL;
		z.right = TNULL;
		z.color = 1;
		
		RBInsertFixUp(z);
	}

	void RBInsertFixUp(Node z) {	
		Node y;
		while (z.parent.color == 1) {
			if (z.parent == z.parent.parent.left) {
				y = z.parent.parent.right;
				
				if (y.color == 1) {
					z.parent.color = 0;
					y.color = 0;
					z.parent.parent.color = 1;
					z = z.parent.parent;
				}
				else if (z == z.parent.right) {
					z = z.parent;
					leftRotate(z);
				}
				else {
					z.parent.color = 0;
					z.parent.parent.color = 1;
					rightRotate(z.parent.parent);
				}
			}
			
			else {
				y = z.parent.parent.left;
				
				if (y.color == 1) {
					z.parent.color = 0;
					y.color = 0;
					z.parent.parent.color = 1;
					z = z.parent.parent;
				}
				else if (z == z.parent.left) {
					z = z.parent;
					rightRotate(z);
				}
				else {
					z.parent.color = 0;
					z.parent.parent.color = 1;
					leftRotate(z.parent.parent);
				}
			}
		}
		root.color = 0;
	}

	void leftRotate(Node x) {
		Node y = x.right;
		x.right = y.left;
		
		if (y.left != TNULL)
			y.left.parent = x;
		
		y.parent = x.parent;
		
		if(x.parent == TNULL)
			root = y;
		else if (x == x.parent.left)
			x.parent.left = y;
		else 
			x.parent.right = y;
		
		y.left = x;
		x.parent = y;
	}

	void rightRotate(Node x) {
		Node y = x.left;
		x.left = y.right;
		
		if (y.right != TNULL)
			y.right.parent = x;
		
		y.parent = x.parent;
		
		if (x.parent == TNULL)
			root = y;
		else if (x ==  x.parent.right)
			x.parent.right = y;	
		else
			x.parent.left = y;
		
		y.right = x;
		x.parent = y;
	}
	

	Node maximumRB(Node x) { 
		while(x.right != TNULL) 
			x = x.right;
		return x;
	}
	

	Node minimumRB(Node x) { 
		while(x.left != TNULL) 
			x = x.left;
		return x;
	}
	
	Node searchRB(Node x, int k) { 
		if (x == TNULL || k == x.element) {
			if (x ==  TNULL)
				System.out.println(k + " not found in the tree.");
			return x;
		}
		
		if (k < x.element)
			return searchRB(x.left, k);
		else
			return searchRB(x.right, k);
	}
	
	public void RBtransplant(Node u, Node v) {
		if (u.parent == TNULL)
			root = v;
		else if (u == u.parent.left)		
			u.parent.left = v;
		else
			u.parent.right = v;
	
		v.parent = u.parent;
	}
	

	public void RBdelete (int x) {
		Node n = searchRB(root, x);
		if (n != TNULL)
			RBdelete(n);
	}
	
	public void RBdelete (Node n) {
		Node y = n;
		Node x;
		int y_og_color = y.color;
		
		if (n.left == TNULL) {
			x = n.right;
			RBtransplant(n, n.right);
		}
		else if (n.right == TNULL) {
			x = n.left;
			RBtransplant(n, n.left);
		}
		else {
			y = minimumRB(n.right);
			y_og_color = y.color;
			x = y.right;
			
			if (y.parent == n) x.parent = y;
			else {
				RBtransplant(y, y.right);
				y.right = n.right;
				y.right.parent = y;
			}
			RBtransplant(n, y);
			y.left = n.left;
			y.left.parent = y;
			y.color = n.color;
		}
		
		if (y_og_color == 0) RBdeleteFixUp(x);
	}
	
	public void RBdeleteFixUp(Node x){
		Node w;
		
		while (x != root && x.color == 0) {
			if (x == x.parent.left) {
				w = x.parent.right;
				
				if (w.color == 1) {
					w.color = 0;
					x.parent.color = 1;
					leftRotate(x.parent);
					w = x.parent.right;
				}
				
				if (w.left.color == 0 && w.right.color == 0) {
					w.color = 1;
					x = x.parent;
				}
				else if (w.right.color == 0) {
					w.left.color = 0;
					w.color = 1;
					rightRotate(w);
					w = x.parent.right;
				}
				else {
					w.color = x.parent.color;
					x.parent.color = 0;
					w.right.color = 0;
					leftRotate(x.parent);
					x = root;
				}
			}
			else {
				w = x.parent.left;
				
				if (w.color == 1) {
					w.color = 0;
					x.parent.color = 1;
					rightRotate(x.parent);
					w = x.parent.left;
				}
				
				if (w.right.color == 0 && w.left.color == 0) {
					w.color = 1;
					x = x.parent;
				}
				else if (w.left.color == 0) {
					w.right.color = 0;
					w.color = 1;
					leftRotate(w);
					w = x.parent.left;
				}
				else {
					w.color = x.parent.color;
					x.parent.color = 0;
					w.left.color = 0;
					rightRotate(x.parent);
					x = root;
				}
			}
		}
		x.color = 0;
	}

	void displayInOrder() {
		displayInOrder(root);
	}
	

	void displayInOrder(Node Node) {
		if(Node == TNULL)
			return;
		
		displayInOrder(Node.left);
		System.out.print(Node.element + "  ");
		displayInOrder(Node.right);
	}
	
	void displayPreOrder() {
		displayPreOrder(root);
	}
	

	void displayPreOrder(Node Node) {
		if(Node == TNULL )
			return;
		
		displayPreOrder(Node.left);
		displayPreOrder(Node.right);
		System.out.print(Node.element + "  ");
	}
	
	void displayPostOrder() {
		displayPostOrder(root);
	}

	void displayPostOrder(Node Node) {
		if(Node == TNULL )
			return;
		
		System.out.print(Node.element + "  ");
		displayPreOrder(Node.left);
		displayPreOrder(Node.right);
	}
	
	public void printTree() {
		printTree(this.root, "", true);
	}
	

	private void printTree(Node Node, String indent, boolean last) {
	   	if (Node == TNULL)
	   		return;
	   	
		   System.out.print(indent);
		   if (last) {
		      System.out.print("R-------");
		      indent += "\t";
		   } else {
		      System.out.print("L-------");
		      indent += "|\t";
		   }
            
           String strColor = Node.color == 1?"red":"black";
		   System.out.println(Node.element + "(" + strColor + ")");
		   printTree(Node.left, indent, false);
		   printTree(Node.right, indent, true);
	}
	
	boolean isEmpty(Node root) {
		if (root != TNULL) return false;
		
		System.out.println("The tree is empty.");
		return true;
	}
		
	public static void main(String[] args)
	{
		RBT B = new RBT();
	
		
		int arr[] = {1,2,3,4,5,6,7,8};
		
		for(int i = 0; i<arr.length; i++){
			B.RBInsert(arr[i]);
			System.out.println("INSERT: "+arr[i]);
			System.out.print("Preorder: ");
			B.displayPreOrder();
			System.out.println();
			System.out.print("Inorder: ");
			B.displayInOrder();
			System.out.println();
			System.out.print("Postorder: ");
			B.displayPostOrder();
			System.out.println();
			System.out.println();
			B.printTree();
			System.out.println("\n");
		}
	}
}