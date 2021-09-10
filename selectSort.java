//Sebastian Alejos Acosta
//Selection Sort 
import javax.swing.JOptionPane;
public class selectSort {
    public static void sort(int[] data) {
        int n = data.length;
        for (int i = 0; i < n-1; i++){
            printArray(data);
            int min_idx = i;
            for (int j = i+1; j < n; j++){
                if (data[j] < data[min_idx]){
                    min_idx = j;
                }
            }
            int temp = data[min_idx];
            data[min_idx] = data[i];
            data[i] = temp;
        }
        System.out.println("=======================================================================================================================");
        printArray(data);
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
