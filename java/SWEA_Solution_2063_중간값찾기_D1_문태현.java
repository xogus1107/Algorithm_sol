import java.util.Arrays;
import java.util.Scanner;
 
public class SWEA_Solution_2063_중간값찾기_D1_문태현 {
	  public static void main(String[] args) {
	        Scanner scan = new Scanner(System.in);  
	         
	        int N= scan.nextInt();
	        int[] array = new int[N];
	        for (int i=0; i<N; i++) {
	            array[i]=scan.nextInt();
	        }
	        Arrays.sort(array);
	        System.out.println(array[N/2]);
	         
	    }//end of main
}
