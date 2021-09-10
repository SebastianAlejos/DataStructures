/*Sebastian Alejos Acosta
Bubble Sort Exercise*/
import javax.swing.JOptionPane;

public class bubbleSort {
    public static void sort(int[] data){
		for (int i = 0; i < data.length; i++){
			for (int j = 0; j<data.length-1-i; j++){
                printArray(data);
				if(data[j]>data[j+1]) {
					int aux=data[j+1];
		            data[j+1]=data[j];
		            data[j]=aux;
				}
			}
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
