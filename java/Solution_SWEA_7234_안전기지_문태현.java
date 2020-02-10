package homework;

import java.util.Scanner;

public class Solution_SWEA_7234_안전기지_문태현 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int dx[]= {0,0,-1,1};
		int dy[]= {-1,1,0,0};
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int map[][]= new int[N+1][N+1];
			int B = sc.nextInt();
			Node[] node = new Node[B];
			for (int b = 0; b < B; b++) {
				int y= sc.nextInt();
				int x = sc.nextInt();
				map[y][x]+=1;
				node[b]= new Node(x, y);
			}
			
			for(int i=0; i<B; i++) {
				int cx = node[i].x;
				int cy = node[i].y;
				
				for(int j=1; j<3; j++) {
					for(int n=0; n<4; n++) {
						int nx = cx+dx[n]*j;
						int ny = cy+dy[n]*j;
						if (nx<1 || ny<1|| nx>N || ny>N) continue;
						map[ny][nx]+=1;
					}
				}
			}
			int max_res =-1;
			for (int i = 1; i < N+1; i++) {
				for (int j = 1; j < N+1; j++) {
					max_res = Math.max(max_res, map[i][j]);
				}
			}
			System.out.println("#"+(t+1)+" "+max_res);
			
		}
		
	}
}
class Node{
	int x;
	int y;
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
