import javax.swing.JOptionPane;

public class quicksort {
    public static void sort(int[] datos, int left, int right){
        if(left<right) {
                int posPivote= particion(datos,left, right);
                System.out.println(posPivote);
                sort(datos,left, posPivote-1);
                sort(datos, posPivote+1, right);
            }
    }
    private static int particion(int[]datos, int left, int right){
		int p= datos[left];
		int i= left+1;
		for(int j= left+1; j<right ;j++) {
			if(datos[j]<p) {
				int aux=datos[i];
		        datos[i]=datos[j];
		        datos[j]=aux;
				i++;
                printArray(datos);
			}
		}
        return i-1;
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
        int left=0;
        int right=list.length-1;
		sort(list, left, right);
	}
    
}
    