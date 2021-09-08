/*Sebastian Alejos Acosta 
Binary Search Homework*/
import javax.swing.JOptionPane;

public class binarysearch {

	public static String binarySearch(int[] data, int value) {
		int min=0,
			max=data.length-1,
			avg,
			iterations;
	
		iterations=0;
		while(min<=max){
			iterations+=1;
			avg=(min+max)/2;
			if(value==data[avg]) {
				return "The program completed "+ iterations+ " iterations. The number exists in the position "+avg;
			}else if(value< data[avg]) {
				max=avg-1;
			}else {
				min=avg+1;
			}
		}
		return "The number does not exists on the list";
	}
	
	
	public static void main(String[] args) {
		int data[] = { 2, 3, 4, 10, 40 };
		int value=Integer.parseInt(JOptionPane.showInputDialog("Value to seach: "));
		System.out.println(binarySearch(data,value));
	}

}
