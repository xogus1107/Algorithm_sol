package com.ssafy.algo;

import java.util.Arrays;
import java.util.Scanner;

public class 상호의벽돌 {
	public static int dx[]= {0,0,-1,1};
	public static int dy[]= {-1,1,0,0};
	public static int y;
	public static int x;
	public static int H;
	public static int W;
	public static char map[][];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			H = sc.nextInt();
			W = sc.nextInt();
			map = new char[H][W];
			
			for(int i=0; i<H; i++) {
				String s =sc.next();
				for(int j=0; j<W; j++) {
					map[i][j]=s.charAt(j);
				}
			}
			int C= sc.nextInt();
			char command[]=new char[C];
			String s=sc.next();
			sol(s);	
			
			System.out.print("#"+(t+1)+" ");
			for(int i=0; i<H;i++) {
				for(int j=0; j<W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
		
	}
	public static int direction(char d) {
		if(d=='^')
			return 0;
		else if(d=='v')
			return 1;
		else if(d=='<')
			return 2;
		else 
			return 3;
	}
	public static void move(int c) {
		if (c=='U') {
			map[y][x]='^';
		}else if(c=='D') {
			map[y][x]='v';
		}else if(c=='L') {
			map[y][x]='<';
		}else if(c=='R') {
			map[y][x]='>';
		}
		int dir = direction(map[y][x]);
		int ny = y+dy[dir];
		int nx = x+dx[dir];
		if(ny<0||nx<0||nx>=W ||ny>=H) return;
		if(map[ny][nx]=='.') {//  갈 수 있으면 스왑
			char temp=map[y][x];
			map[y][x]=map[ny][nx];
			map[ny][nx]=temp;
			y=ny;
			x=nx;
		}
		
	}
	
	public static void shoot() {
		int dir = direction(map[y][x]);
		int cy = y;
		int cx =x;
		while(true) {
			cy=cy+dy[dir];
			cx=cx+dx[dir];
			if(cy<0||cx<0||cy>=H||cx>=W) break;
			if(map[cy][cx]=='#') break;
			if(map[cy][cx]=='*') {
				map[cy][cx]='.';
				break;
			}
			
		}
	}
	
	public static void sol(String s) {
		
		int dir;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if(map[i][j]=='^' || map[i][j]=='v' ||map[i][j]=='<' ||map[i][j]=='>' )
				{
					y=i;
					x=j;
				}
			}
		}
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i)=='S') {
				shoot();
				
				}
			else 
				move(s.charAt(i));
		}
	}

}
