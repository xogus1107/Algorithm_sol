package codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class �ֻ���������_�ù� {
	static int bottom, top, up, down, left, right;
	static int map[][];
	static int N, M, K; //����, ����, ��� ����
 	static int sx, sy; // ó�� ���� x, y
	static int order[];
	static int dx[]= {0,1,-1,0,0}; //�����ϳ�
	static int dy[]= {0,0,0,-1,1}; //�����ϳ�
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sy = Integer.parseInt(st.nextToken());
		sx = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		order = new int[K];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < order.length; i++) {
			order[i]=Integer.parseInt(st.nextToken());
		}
		//System.out.println(sy+" "+sx);
		//System.out.println(top + " "+ bottom +" "+ up+" "+down+" "+left+" "+right);
		for (int i = 0; i < order.length; i++) {
			//order��� ������.
			move(order[i]);
			//System.out.println(sy+" "+sx);
			//System.out.println(top + " "+ bottom +" "+ up+" "+down+" "+left+" "+right);
		
		}

	}
	public static void move(int order) {
		int ny = sy + dy[order];
		int nx = sx + dx[order];
		//�ű� �� �� ���̸� ��� �����Ѵ�.����ġ sy, sx �� �ٲ۴�.
		if(ny<0 || nx<0 || ny>=N || nx>=M) return;
		sy= ny;
		sx= nx;
		//order�� 1, 2, 3, 4 �� ���� ������.
		if(order ==1) {// �������� ������.
			//���� ���� �ֻ��� ������ ��� �ٲ۴�.
			//���� up, down ������ ������ �װ� ��ü
			int temp = left;
			left = bottom;
			bottom = right;
			right = top;
			top = temp;
			//�Ű����� �´��� �ٴڳ��� ���� ���� �ؾ��� ���� �����Ѵ�. bottom �� map[sy][sx] ��
			if(map[sy][sx]==0) {
				map[sy][sx]=bottom;
			}else {
				bottom= map[sy][sx];
				map[sy][sx]=0;
			}
		}else if(order==2) {//����
			int temp = bottom;
			bottom = left;
			left = top;
			top = right;
			right = temp;
			if(map[sy][sx]==0) {
				map[sy][sx]=bottom;
			}else {
				bottom= map[sy][sx];
				map[sy][sx]=0;
			}
		}else if(order==3) {
			int temp = up;
			up = top;
			top = down;
			down = bottom;
			bottom = temp;
			if(map[sy][sx]==0) {
				map[sy][sx]=bottom;
			}else {
				bottom= map[sy][sx];
				map[sy][sx]=0;
			}
		}else {
			int temp = down;
			down = top;
			top = up;
			up = bottom;
			bottom = temp;
			if(map[sy][sx]==0) {
				map[sy][sx]=bottom;
			}else {
				bottom= map[sy][sx];
				map[sy][sx]=0;
			}
		}
		System.out.println(top);
		
	}
}
