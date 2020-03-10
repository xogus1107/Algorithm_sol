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
public class ��������_bfs_�ù�_swea {
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
			//�ߺ� ������ ����� ����.
			toshoot = new int[N];
			dfs(0);
	
			System.out.println("#"+(t+1)+" "+min_res);
		}
	}
	
	//queue �� �ִ°� ���⼭ �־��� ��쿡 �ʹ� ��ȿ�� ���̾���...
	
	public static void shoot(int idx) {
		int cnt = 0;
		Queue<block> q = new LinkedList();
		//0 �ƴѰ� ã��
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
		}//�� �ߺ� ���� ���� map �ʱ�ȭ ���ְ� �� ���
		
		//toshoot�� ����� ���� ���
		for (int i = 0; i < N; i++) {
			shoot(toshoot[i]);
			gravity();
		}
		
	
		
		//������ ���� ����
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
			//toshoot �� ����� ����� ����
			sol();
			return;
		}
		for (int i = 0; i < W; i++) {
			toshoot[cnt]=i;
			dfs(cnt+1);
		}
	}
}
