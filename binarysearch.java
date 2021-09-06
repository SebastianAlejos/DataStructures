import javax.swing.JOptionPane;

public class binarysearch {

	public static int binarySearch(int[] data, int value) {
		int min=0,
			max=data.length-1,
			avg;
		while(min<=max){
			avg=(min+max)/2;
            System.out.println("Searching in position: "+avg);
			if(value==data[avg]) {
				return avg;
			}else if(value< data[avg]) {
				max=avg-1;
			}else {
				min=avg+1;
			}
		}
		return -1;
	}
	
	
	public static void main(String[] args) {
		int data[] = { 2, 3, 4, 10, 40 };
		int value=Integer.parseInt(JOptionPane.showInputDialog("Value to seach: "));
		System.out.println("The number "+value+" is located in position: "+binarySearch(data,value));
	}

}
