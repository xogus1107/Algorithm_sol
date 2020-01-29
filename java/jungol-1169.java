package codingtest;

import java.util.Scanner;

public class dice2 {

	public static void dfs(int count) {
		if(count==N) {
			int sum=0;
			for(int i=0; i<count; i++) {
				sum+=arr[i];
			}
			if(sum==M) {
				for(int i=0; i<count; i++) {
					System.out.print(arr[i]+" ");
				}System.out.println();
			}
			return;
		}
		for(int i=1; i<=6; i++) {
			arr[count]=i;
			dfs(count+1);
		}
	}
	public static int[] arr = new int[10];
	public static int N;
	public static int M;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);
			N= sc.nextInt();
			M = sc.nextInt();
			//중복 순열 중에서 합이 M 인 것을 고르면 되지
			
			dfs(0);
	}

}
