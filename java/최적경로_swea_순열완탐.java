package excercisesaffy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
class node{
	int y;
	int x;
	public node(int y,int x) {
		this.y= y;
		this.x=x;
	}
}
public class 최적경로 {
	static int N;
	static node company;
	static node home;
	static node[] togo;
	static int[] visited;
	static int min_res;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for(int t=0; t<T; t++) {
			N = Integer.parseInt(bf.readLine());
			StringTokenizer st = new StringTokenizer(bf.readLine());
			company= new node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			home = new node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			togo = new node[N];
			visited = new int[N];
			min_res = 100000;
			for(int n=0; n<N; n++) {
				visited[n]=n;
			}
			for(int n=0; n<N; n++) {
				togo[n]=new node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				
			}
			permutation(0, N); // 순열로 경로 탐색
			System.out.println("#"+(t+1)+" " +min_res);
		}
	}
	public static void calculate() {
		int distance =0;
		distance= Math.abs(company.y-togo[visited[0]].y)+Math.abs(company.x-togo[visited[0]].x);
		for(int i=0; i<N-1; i++) {
			distance+= Math.abs(togo[visited[i]].y-togo[visited[i+1]].y)+Math.abs(togo[visited[i]].x-togo[visited[i+1]].x);
		}
		distance+= Math.abs(togo[visited[N-1]].y-home.y)+Math.abs(togo[visited[N-1]].x-home.x);
		min_res = Math.min(min_res, distance);
	}
	public static void permutation(int index, int size) {
		if(index==size) {
			//calculate
			calculate();
			return;
		}
		for(int i=index; i<N; i++) {
			int temp = visited[index];
			visited[index]=visited[i];
			visited[i]=temp;
			permutation(index+1, size);
			temp=visited[index];
			visited[index]=visited[i];
			visited[i]=temp;
			
		}
		
	}

}
