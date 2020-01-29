package codingtest;

import java.util.Arrays;
import java.util.Scanner;


public class dice1 {
	public static void dfs1(int count) {//중복 순열
		if(count == N) {
			for(int i=0; i<count; i++) {
				System.out.print(arr[i]+" ");
			}System.out.println();
			return;
		}
		for(int i=1; i<=6; i++) {
			arr[count] = i;
			dfs1(count+1);
		}
	}
	public static void  dfs2(int count, int index) {//중복조합
		if(count==N) {
			for(int i=0; i<count; i++) {
				System.out.print(arr[i]+" ");
			}System.out.println();
			return;
		}
		for(int i=index; i<=6; i++) {
			arr[count]=i;
			dfs2(count+1, i);
		}
	}
	public static void dfs3(int count, int[] visited) {//순열
		if(count==N) {
			for(int i=0; i<count;i++) {
				System.out.print(arr[i]+" ");
			}System.out.println();
			return;
		}
			
		for(int i=1; i<=6; i++) {
			if(visited[i-1]==0) {
				arr[count]=i;
				visited[i-1]=1;
				dfs3(count+1, visited);
				visited[i-1]=0;
			}			
		}
		
	}
	public static void dfs4(int count,int[] visited, int index) {//조합
		if(count==N) {
			for(int i=0; i<count;i++) {
				System.out.print(arr[i]+" ");
			}System.out.println();
			return;
		}
		
		for(int i=index; i<=6; i++) {
			if(visited[i-1]==0) {
				arr[count]=i;
				visited[i-1]=1;
				dfs4(count+1, visited, i);
				visited[i-1]=0;
			}
		}
	}
	public static int[] arr= new int[6];
	public static int N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();
		int[] visited= new int[6];
		if(M==1) {
			dfs1(0);
		}
		else if(M==2) {
			dfs2(0, 1);
		}
		else if(M==4) {
			dfs4(0,visited,1);
		}
		else {
			dfs3(0,visited);
		}
		
	}

}
