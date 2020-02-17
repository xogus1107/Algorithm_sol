import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int H;
	static int map[][][];
	
	static int dx[] = {0,0,-1,1,0,0};
	static int dy[] = {-1,1,0,0,0,0};
	static int dz[] = {0,0,0,0,-1,1};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N= sc.nextInt();
		H= sc.nextInt();
		map = new int[H][N][M];
		int m = N*M*H;
	
		Queue<tomato> q = new LinkedList<tomato>();
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					map[i][j][k] = sc.nextInt();
					if(map[i][j][k]==1) {
						q.add(new tomato(i,j,k));
					}
				}
			}
		}
		int count =0;
		while(!q.isEmpty()) {
			
			int length = q.size();
			for(int i=0; i<length; i++) {
				tomato node = q.poll();
				
				for(int j=0; j<6; j++){
					int nz= node.z+dz[j];
					int ny= node.y +dy[j];
					int nx =node.x +dx[j];
					if(nx<0 ||ny<0|| nz<0 || nx>=M || ny>=N|| nz>=H) continue;
					if(map[nz][ny][nx]==1 || map[nz][ny][nx]==-1) continue;
					
					map[nz][ny][nx]=1;
					q.add(new tomato(nz,ny,nx));
				}
			}
			count++;
		
		}
		
		int flag=0;
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if(map[i][j][k]==0) {
						flag = 1;
					}
						
				}
			}
		}
		
		if(flag==1) {
			System.out.println(-1);
		}
		else {

			System.out.println(count-1);
		}
		
			
	}
}
class tomato{
	int y;
	int x;
	int z;
	public tomato(int z, int y, int x) {
		this.x = x;
		this.y = y;
		this.z = z;
		
	}
	
}