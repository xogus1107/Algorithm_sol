package excercisesaffy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
class memo{
	int s;
	int l;
	int num;
	public memo(int s, int l, int num) {
		this.s=s;
		this.l=l;
		this.num=num;
	}
}
public class 햄스터 {
	static int N;
	static int X;
	static int M;
	static int wall[];
	static int tc;
	static memo[] memos;
	static int flag = -1;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		StringTokenizer st;
		for (int t = 0; t < T; t++) {
			tc=t+1;
			st = new StringTokenizer(bf.readLine());
			N= Integer.parseInt(st.nextToken());
			X= Integer.parseInt(st.nextToken());
			M= Integer.parseInt(st.nextToken());
			memos = new memo[M];
			wall = new int[N];
			flag =-1;
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(bf.readLine());
				memos[m]= new memo(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
		
			dfs(N-1);
			if (flag==-1) {
				System.out.println("#"+(t+1)+ " "+ -1);
			}
		}
	}
	public static void dfs(int index) {
		if(flag==1) return;
		if(index ==-1) {
			check();
			return;
		}
		for (int i = X; i >=0; i--) {
			wall[index]=i;
			dfs(index-1);
		}
	}
	public static void check() {
		for (int i = 0; i < memos.length; i++) {
			int s = memos[i].s;
			int l = memos[i].l;
			int size = memos[i].num;
			int test=0;
			for(int j=s-1; j<=l-1;j++) {
				test+=wall[j];
			}
			if(test!=size) {
				return;
			}
		}
		//메모 모두 통과.
		flag =1;
		System.out.print("#"+tc+" ");
		for (int i = 0; i < wall.length; i++) {
			System.out.print(wall[i]+" ");
		}
		System.out.println();
		
	}

}
