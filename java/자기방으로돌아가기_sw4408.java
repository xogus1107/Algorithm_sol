package com.ssafy.algo;

import java.util.Arrays;
import java.util.Scanner;

public class 자기방으로돌아가기 {
	public static int index(int a){
		if(a%2==0){ //짝
			return (a/2)-1;
		}
		else {
			return a/2;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int street[] = new int[201];
			int N = sc.nextInt();
			int arr[][]= new int[N][2];
			for (int i = 0; i < arr.length; i++) {
				arr[i][0]=sc.nextInt();
				arr[i][1]=sc.nextInt();
			}
			
			for(int i=0; i<N; i++) {
				for (int j = index(arr[i][0]); j<=index(arr[i][1]); j++){
					street[j]+=1;
				}
			}
			int max_res = -1;
			for(int i =0; i<street.length; i++) {
				max_res = Math.max(max_res, street[i]);
			}
			System.out.println(max_res);
			
		}
	}

}
