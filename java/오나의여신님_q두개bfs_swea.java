package codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Node{
	int y;
	int x;
	public Node(int y, int x) {
		this.y=y;
		this.x=x;
	}
}

public class 오나의여신님_q두개bfs_swea {
	static int dx[]= {0,0,-1,1};
	static int dy[]= {-1,1,0,0};
	static int N, M;
	static int map[][];//.-> 0(빈공간),X->1(돌), S->2(수연), *->3(악마), D->4(여신)
	static Queue<Node> evil = new LinkedList();
	static Queue<Node> su = new LinkedList();
	static int evil_visit[][];
	static int su_visit[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= T; t++) {
			evil.clear();
			su.clear();
			StringTokenizer st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			evil_visit = new int[N][M];
			su_visit = new int[N][M];
			
			for (int i = 0; i < N; i++) {
				String s = bf.readLine();
				for (int j = 0; j < M; j++) {
					if(s.charAt(j)=='.') map[i][j]=0;
					else if(s.charAt(j)=='X') map[i][j]=1;
					else if(s.charAt(j)=='S') {
						map[i][j]=2;
						su.add(new Node(i,j));
						su_visit[i][j]=1;
					}else if(s.charAt(j)=='*') {
						map[i][j]=3;
						evil.add(new Node(i,j));
						evil_visit[i][j]=1;
					}else {
						map[i][j]=4;
					}
				}
			}
			
			int res = bfs();
			if (res==-1) {
				System.out.println("#"+t+" "+"GAME OVER");
			}else {
				System.out.println("#"+t+" "+res);
			}
			
		}
	}
	public static int bfs() {
		int cnt =1;
		while(!su.isEmpty()) {
			int evil_size = evil.size();
			for (int i = 0; i < evil_size; i++) {
				Node e = evil.poll();
				for (int d = 0; d < dx.length; d++) {
					int ny = e.y+dy[d];
					int nx = e.x+dx[d];
					if(ny<0||nx<0||ny>=N||nx>=M) continue;
					if(map[ny][nx]==1 || map[ny][nx]==4) continue;//여신, 돌
					if(evil_visit[ny][nx]==1) continue;
					
					map[ny][nx]=3;
					evil_visit[ny][nx]=1;
					evil.add(new Node(ny,nx));
				}
			}
			int su_size = su.size();
			for (int i = 0; i < su_size; i++) {
				Node s = su.poll();
				for (int d = 0; d < dx.length; d++) {
					int ny = s.y+dy[d];
					int nx = s.x+dx[d];
					if(ny<0||nx<0||ny>=N||nx>=M) continue;
					if(su_visit[ny][nx]==1) continue;
					if(map[ny][nx]==1 || map[ny][nx]==3) continue;//악마, 돌
					if(map[ny][nx]==4) return cnt;
					
					map[ny][nx]=2;
					su_visit[ny][nx]=1;
					su.add(new Node(ny,nx));
				}
			}
			cnt++;
		}
		
		return -1;
	}

}
