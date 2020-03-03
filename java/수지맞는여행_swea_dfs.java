package excercisesaffy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수지맞는여행 {
	static int Y;
	static int X;
	static char[][] map;
	static int[][] visited;
	static int[] alphabet;
	static int dx[]= {0,0,-1,1};
	static int dy[]= {-1,1,0,0};
	static int max_res = -1;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for (int t = 0; t < T; t++) {
			
			StringTokenizer st = new StringTokenizer(bf.readLine());
			Y = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			map = new char[Y][X];
			visited = new int[Y][X];
			alphabet = new int[40];
			
			for (int i = 0; i < Y; i++) {
				String s = bf.readLine();
				for (int j = 0; j < X; j++) {
					map[i][j]=s.charAt(j);
				}
			}
			visited[0][0]=1;
			int alphanum=map[0][0]-'A';
			alphabet[alphanum]=1;
			max_res=-1;
			dfs(0,0, 1);
			
			
			System.out.println("#"+(t+1)+" "+max_res);
		}
	}
	public static void dfs(int y, int x, int cnt) {
        max_res = Math.max(max_res, cnt);
		for(int i=0; i< 4; i++) {
			int ny = y+dy[i];
			int nx = x+dx[i];
			
			if(nx<0||ny<0||nx>=X||ny>=Y) continue;
			if(visited[ny][nx]==1) continue;
			int alphanum = map[ny][nx]-'A';
			if(alphabet[alphanum]==1) continue;
			
			alphabet[alphanum]=1;
			visited[ny][nx]=1;
			dfs(ny,nx,cnt+1);
			visited[ny][nx]=0;
			alphabet[alphanum]=0;
		}
	}

}
