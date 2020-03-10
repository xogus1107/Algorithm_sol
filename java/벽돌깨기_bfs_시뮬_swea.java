package codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class block{
	int y;
	int x;
	int val;
	public block(int y, int x, int val) {
		this.y= y;
		this.x=x;
		this.val=val;
	}
}
public class 벽돌깨기_bfs_시뮬_swea {
	static int dx[]= {0,0,-1,1};
	static int dy[]= {-1,1,0,0};
	static int N, W, H;
	static int map[][];
	static int copymap[][];

	static int toshoot[];
	static int min_res = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(bf.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			copymap = new int[H][W];
		
			min_res = Integer.MAX_VALUE;
			
			for (int i = 0; i < map.length; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < map[0].length; j++) {
					copymap[i][j]=map[i][j]= Integer.parseInt(st.nextToken());
				}
			}
			/*for (int i = 0; i < map.length; i++) {
				System.out.println(Arrays.toString(map[i]));
			}*/
			//중복 순열로 쏠곳을 정함.
			toshoot = new int[N];
			dfs(0);
	
			System.out.println("#"+(t+1)+" "+min_res);
		}
	}
	
	//queue 에 넣는건 여기서 최악의 경우에 너무 비효율 적이었음...
	
	public static void shoot(int idx) {
		int cnt = 0;
		Queue<block> q = new LinkedList();
		//0 아닌곳 찾기
		for (int i = 0; i < copymap.length; i++) {
			if (map[i][idx]==1) {
				map[i][idx]=0;
				break;
			}
			else if(map[i][idx]>1) {
				q.add(new block(i, idx, map[i][idx]));
				map[i][idx]=0;
				break;
			}
		}
		
		
		//boom
		while(!q.isEmpty()){
			block b = q.poll();
		
			for (int i = 1; i < b.val; i++) {
				for (int d = 0; d < dx.length; d++) {
					int ny = b.y+dy[d]*i;
					int nx = b.x+dx[d]*i;
					if(ny<0||nx<0||ny>=H||nx>=W) continue;
					if(map[ny][nx]>1) {
						q.add(new block(ny, nx, map[ny][nx]));
					}
					map[ny][nx]=0;
				}
			}
			
		}
		
		
	}
	
	public static void gravity() {
		Queue<Integer> q = new LinkedList();
		for (int i = 0; i < copymap[0].length; i++) {
			for (int j = H-1; j >=0; j--) {

				if(map[j][i]!=0) {
					
					q.add(map[j][i]);
					map[j][i]=0;
				}
			}
			int size = q.size();

			for (int j=H-1; j>=H-(size); j--) {
				map[j][i]=q.poll();
			}
		}
		
	}
	
	public static void sol() {
		for (int i = 0; i < copymap.length; i++) {
			for (int j = 0; j < copymap[0].length; j++) {
				map[i][j]=copymap[i][j];
			}
		}//매 중복 순열 마다 map 초기화 해주고 총 쏘기
		
		//toshoot에 저장된 곳에 쏘기
		for (int i = 0; i < N; i++) {
			shoot(toshoot[i]);
			gravity();
		}
		
	
		
		//남음것 숫자 세기
		int cnt =0;
		for (int i = 0; i < copymap.length; i++) {
			for (int j = 0; j < copymap[0].length; j++) {
				if(map[i][j]!=0) 
					cnt++;
			}
		}
		
		min_res = Math.min(cnt, min_res);
	}
	
	public static void dfs(int cnt) {
		if(cnt==N) {
			//toshoot 에 쏠곳이 저장된 상태
			sol();
			return;
		}
		for (int i = 0; i < W; i++) {
			toshoot[cnt]=i;
			dfs(cnt+1);
		}
	}
}
