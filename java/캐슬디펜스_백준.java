package com.ssafy.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class node{
	int x;
	int y;
	public node(int y , int x) {
		this.x=x;
		this.y=y;
	}
	
}
public class 캐슬디펜스 {
	
	static int dx[] = {-1,0,1}; //좌, 상 , 우
	static int dy[] = {0,-1,0};
	static int[][] map;
	static int N, M,D, max_res;
	static int visited[];
	static int map_visited[][];
	static int CN;
	static int [][] tmap;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		M = sc.nextInt();
		D = sc.nextInt();
		map = new int[N+1][M];
	
		visited = new int[M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		max_res = -1;
		dfs(0,0);
		System.out.println(max_res);
		
	}
	public static node bfs(int y, int x) {
		Queue<node> q = new LinkedList<node>();
		
		q.add(new node(y,x));
		map_visited[y][x]=1;
		int dcount=0;
		while(!q.isEmpty()) {
			
			int length = q.size();
			for(int i=0; i<length; i++) {
				node n = q.poll();
				for(int j=0 ; j<3; j++) {
					int nx = n.x + dx[j];
					int ny = n.y + dy[j];
					//System.out.println(ny +" "+nx);
					if(nx<0 || ny<0 || nx>=M || ny>=N+1) continue;
					if(map_visited[ny][nx]==1) continue;
				
					//System.out.println(map[ny][nx]);
					if(tmap[ny][nx]==1) return new node(ny,nx);
					map_visited[ny][nx]=1;
					q.add(new node(ny,nx));
 				}
			}
			
			dcount++;
			if(dcount>=D) break;
		}
		return null;
		
	}
	public static void simulation() {
		tmap = new int[N+1][M];
		for (int i = 0; i < N+1; i++) {
			for (int j = 0; j < M; j++) {
				tmap[i][j]= map[i][j];
			}
		}
		int count=0;
		for(int loop = 0; loop<N; loop++) {
			ArrayList<node> li = new ArrayList<node>();
			for(int i=0; i<M; i++) {
				if(visited[i] ==1) {
					map_visited = new int[N+1][M];
					// y = N, x = i 에서 거리가 D 이하 인것 중 가장 가까운 것중 젤 왼쪽.
					li.add(bfs(N, i));
				}
			}
			// 3개의 점을 가져왔다. 단 null 이 끼어 있다. 또는 같은 것을 공격할 수도 있다.
	
			
			for(int i=0; i< 3; i++) {
				node n= li.get(i);
				if(n== null) continue;
				if(tmap[n.y][n.x]==1) {
					tmap[n.y][n.x]=0;
					count++;
				}
			}
		
			for(int i=N-1; i>=0; i--) {
				for(int j=0; j<M; j++) {
					if(tmap[i][j]==1) {
						tmap[i][j]=0;
						if(i+1==N) continue;
						tmap[i+1][j]=1;
					}
				}
			}
		//맵을 아래로 내린다. 
		}
		max_res = Math.max(max_res, count);
		
		
		
	}
	public static void dfs(int index, int count) {
		if(count==3) {
	
			simulation();	
			return;
		}
		
		for(int i=index; i<M; i++) {
			if(visited[i]==0) {	
				visited[i]=1;
				dfs(i+1, count+1);
				visited[i]=0;
			}
		}
	}

}
