import javax.swing.JOptionPane;
public class insertionSort {

	public static void sort(int[] list) {
		for (int i = 1; i < list.length; i++) {
		int n=list[i];
		int k=i-1;
		printArray(list);
		while (k>=0 && n<list[k]){
			list[k+1]=list[k];
			k=k-1;
		}
		list[k+1]=n;	
		}
		System.out.println("=======================================================================================================================");
		printArray(list);
	}
	private static void printArray(int[]list) {
		for ( int tmp : list) {
			System.out.print(tmp+"          ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int n=Integer.parseInt(JOptionPane.showInputDialog("How many elements are there in the array?"));
		int[] list=new int[n];
		for (int i = 0; i < list.length; i++) {
			int y=Integer.parseInt(JOptionPane.showInputDialog("Enter the next number on the list"));
			list[i]=y;
		}
		sort(list);
	}
}
