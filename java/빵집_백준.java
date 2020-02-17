package com.ssafy.algo;

import java.util.Arrays;
import java.util.Scanner;

public class 빵집 {
	static int R;
	static int C;
	static int[][] map;
	static int[][] visitedmap;
	static int[][] final_visited;
	static int count;
	static int dx[] = {1,1,1};
	static int dy[] = {-1,0,1};
	static int flag;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		count=0;
		map = new int[R][C];
		visitedmap = new int[R][C];
		for (int i = 0; i < R; i++) {
			String s = sc.next();
			for (int j = 0; j < C; j++) {
				if(s.charAt(j)=='.') {
					map[i][j] = 0;
				}
				else {
					map[i][j]=1;
				}
			}
		}
		
		for(int i=0; i< R ; i++) {
			flag =0;
			dfs(i, 0);
		}		
		System.out.println(count);
	}

	public static void dfs(int y, int x) {
		
		
		if (flag ==1) return;
		
		visitedmap[y][x]=1;
		
		if(x==C-1) {
			//if()
			flag =1;
			//끝도달
			count++;
			return;
		}
		
		for (int i=0; i<3; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny<0 || nx<0 || ny>=R || nx >=C)continue;
			if(visitedmap[ny][nx]==1) continue;
			if(map[ny][nx]==1) continue;
			dfs(ny,nx);
			
		}
		
	}
}
