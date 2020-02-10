import java.util.Arrays;
import java.util.Scanner;

public class SWEA_Solution_1204_최빈수구하기_D2_문태현 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N; 
			N=sc.nextInt();
			int score[] = new int[101];
			int score1[]= new int[101];
			int arr[] = new int[1000];
			for(int i=0; i<1000; i++) {
				arr[i]=sc.nextInt();
			}
			for(int i=0; i<1000; i++) {
				score[arr[i]]+=1;
				score1[arr[i]]+=1;		
			}
			
			Arrays.sort(score);
			// max score[score.lenth-1]
			int res=0;
			for(int i=0 ; i<100; i++) {
				if(score[score.length-1]==score1[i]) {
					res=i;
				}
			}
			System.out.println("#"+N+" "+res);
		}
	}
}
