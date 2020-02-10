package com.ssafy.algo;

import java.util.Arrays;
import java.util.Scanner;

public class 퇴사2 {

	public static int N;
	public static int T[];
	public static int P[];
	public static int d[];
	public static int max_res = -1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		T = new int[N+10];
		P = new int[N+10];
		d = new int[N+10];
		for(int n=0; n<N; n++) {
			T[n]=sc.nextInt();
			P[n] = sc.nextInt();
		
		}
		for(int i=0; i<=N;i++) {
			for(int j=0; j<=i;j++) {
				d[i]=Math.max(d[i], d[j]);
				
				if(j+T[j]==i) {
					d[i]=Math.max(d[j]+P[j], d[i]);
				}
						
			}
		}
		System.out.println(Arrays.toString(d));
		//System.out.println(max_res);
		//부분집합 구하기 
	}
	
}
