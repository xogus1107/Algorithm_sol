package excercisesaffy;
/**
 * 
 * �� ����ó�� ��� �Լ��� ���� �������� ���� ���ϸ��ϸ������� �����ͼ�
 * �������� ���ϴ� ���� memoization�� ������ ���ɼ��� ������
 * ����Լ��ǳ����� ���� �ű⼭ ���� ���ϴ� ���� �����ؾ� �ɵ�.
 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ���ݸ�������my {
	static int n, m;
	static int map[][];
	static int res;
	static int dp[][][][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			n= Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			map = new int[n][m];
			int min_res = Integer.MAX_VALUE;
			for (int i = 0; i < map.length; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < map[0].length; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			dp = new int[n+1][m+1][n+1][m+1];
			for (int i = 0; i < n+1; i++) {
				for (int j = 0; j < m+1; j++) {
					for (int j2 = 0; j2 < n+1; j2++) {
						for (int k = 0; k < m+1; k++) {
							dp[i][j][j2][k]=Integer.MAX_VALUE;
						}
					}
				}
			}
			res= dfs(0,0,n,m);
			
			System.out.println("#"+(t+1)+" "+res);
			
		}
	}
	public static int dfs(int y, int x, int h, int w) {
		//����
		if(h==1 && w==1) return 0;
		if(dp[y][x][h][w]!=Integer.MAX_VALUE)
			return dp[y][x][h][w];
		//��� �ڸ� �� �� ����� value���� �����ؾ���.
		int sum=0;
		for (int i = y; i < y+h; i++) {
			for (int j = x; j < x+w; j++) {
				sum+= map[i][j];
			}
		}
		
		//���� ���� ��� ���� �߶󺸸� �ּҰ��� ��ȯ
		for (int i = 1; i < w; i++) {
			//����
			if(dp[y][x][h][i]==Integer.MAX_VALUE) {
				dp[y][x][h][i] = dfs(y,x,h,i);
			}
			if(dp[y][x+i][h][w-i]==Integer.MAX_VALUE) {
				dp[y][x+i][h][w-i]=dfs(y,x+i, h, w-i);
			}
			int sum3 = sum+dp[y][x][h][i]+dp[y][x+i][h][w-i];
			 dp[y][x][h][w] = Math.min( dp[y][x][h][w], sum3);
		}
		for (int i = 1; i < h; i++) {
			//����
			if(dp[y][x][i][w]==Integer.MAX_VALUE) {
				dp[y][x][i][w] = dfs(y,x,i,w);
			}
			if(dp[y+i][x][h-i][w]==Integer.MAX_VALUE) {
				dp[y+i][x][h-i][w]=dfs(y+i,x, h-i, w);
			}
			int sum3 = sum+dp[y][x][i][w]+dp[y+i][x][h-i][w];
			 dp[y][x][h][w] = Math.min( dp[y][x][h][w], sum3);
		}
		
		
		return dp[y][x][h][w];
	}

}
