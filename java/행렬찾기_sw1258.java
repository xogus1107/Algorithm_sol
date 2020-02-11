package com.ssafy.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class 행렬찾기_sw1258 {
	static int dx[]= {0,0,-1,1};
	static int dy[]= {-1,1,0,0};
	static int map[][];
	static int N;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			ArrayList<Dot> dot = new ArrayList<Dot>();
			N = sc.nextInt();
			map = new int[N+2][N+2];
			for (int i = 1; i < N+1; i++) {
				for (int j = 1; j < N+1; j++) {
					map[i][j]= sc.nextInt();
				}
			}
			
			// 위왼이 0인 곳 search;
			for (int i = 1; i < N+1; i++) {
				for (int j = 1; j < N+1; j++) {
					if(map[i][j]!=0 && map[i-1][j]==0 && map[i][j-1]==0) {
						//아래로 탐색
						int y= i;
						int x= j;
						while(true) {
							y=y+dy[1];
							x=x+dx[1];
							if(map[y][x]==0) {
								y=y-dy[1];
								x=x-dx[1];
								break;
							}
						}
						//오른쪽으로 탐색
						while(true) {
							y=y+dy[3];
							x=x+dx[3];
							if(map[y][x]==0) {
								y=y-dy[3];
								x=x-dx[3];
								break;
							}
						}
						dot.add(new Dot(y-i+1,x-j+1));		
					}
				}
			}
			Collections.sort(dot, new Comparator<Dot>() {
				@Override
				public int compare(Dot o1, Dot o2) {
					// TODO Auto-generated method stub
					if(o1.x*o1.y == o2.x*o2.y) {
						return o1.y-o2.y;
					}
					else 
						return o1.x*o1.y - o2.x*o2.y;
				}
				
			});
			System.out.print("#"+(t+1)+" ");
			System.out.print(dot.size()+" ");
			for(int i=0; i<dot.size(); i++) {
				System.out.print(dot.get(i).y+" ");
				System.out.print(dot.get(i).x+" ");
			}
			System.out.println();
			
			
		}
		
	}
}
class Dot {
	int x;
	int y;
	public Dot(int y, int x) {
		this.x=x;
		this.y=y;
	}
}
