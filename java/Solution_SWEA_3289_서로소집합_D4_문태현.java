package homework;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_SWEA_3289_서로소집합_D4_문태현 {
	public static int N;
	public static int p[];
	public static int[] rank;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=0; t<T; t++) {
			System.out.print("#"+(t+1)+" ");
			N = sc.nextInt();
			p=new int[N+1];
			rank = new int[N+1];
			for(int n=1; n<N+1; n++) {
				makeSet(n);
			}
			int M = sc.nextInt();
			for(int m=0; m<M; m++) {
				int pluscheck=sc.nextInt();
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				if(pluscheck==0) {
					union(a,b);
				}
				else {
					if(findSet(a)==findSet(b)) {
						System.out.print(1);
					}
					else System.out.print(0);
				}
				
			}
			System.out.println();
		}
		
	}
	public static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		if(x==y)return;
		p[px]=py;
	}
	public static int findSet(int x) {
		if(p[x]==x) {
			return x;
		}
		else {
			p[x]=findSet(p[x]);
			return p[x];
		}
			
		
	}
	public static void makeSet(int x) {
		p[x]=x;
	}

}
