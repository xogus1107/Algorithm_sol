package com.ssafy.algo;

import java.util.Scanner;

/**
 * 조합 만들기
 * 
 * @author multicampus
 *
 */
public class 로또 {
	public static int[] arr;
	public static int[] visited;
	public static int[] res = new int[6];
	public static int k;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (true) {
			k = sc.nextInt();
			if(k==0) {
				break;
			}
			visited = new int[k];
			arr = new int[k];
			
			for (int i = 0; i < k; i++) {
				arr[i] = sc.nextInt();
			}
			dfs(0, 0);
			System.out.println();
		}
	}
	public static void dfs(int count, int index) {
		
		if(count == 6) {
			for(int i =0 ; i<6; i++) {
				System.out.print(res[i]+" ");
			}System.out.println();
			return;
		}
		
		for(int i=index; i<k ;i++) {
			if(visited[i]==0) {
				//res[count]=arr[i];
				visited[i]=1;
				dfs(count+1, i);
				visited[i]=0;
			}
		}
	}

}
