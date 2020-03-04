package excercisesaffy;
/**
 * 
 * �ĵ��� ���忡�� 8 ���� ���� �𷡵��� ��� ������
 * �ű⼭ �ٴٰ� �� �𷡰� �ִٸ� ť�� ��Ƴ��� 
 * ���� ���ܿ��� ť�� �ִ� �ٴٿ� ���ؼ��� 8���� ���� �𷡸� ��´�.
 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
public class �𷡼��ױ�_teacher {
	static int Y;
	static int X;
	static int[][] map;

	
	static int dx[]= {0,0,-1,1, -1,-1,1,1};
	static int dy[] = {-1,1,0,0, 1,-1,1,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		
		for (int t = 0; t < T; t++) {
			
			StringTokenizer st = new StringTokenizer(bf.readLine());
			Y= Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			map = new int[Y][X];
			
			ArrayList<Node> arr = new ArrayList<Node>();
			
			for (int i = 0; i < map.length; i++) {
				String s = bf.readLine();
				for (int j = 0; j < map[0].length; j++) {
					if(s.charAt(j)=='.') {
						map[i][j]=0;
					}else {
						map[i][j]=Integer.parseInt(s.substring(j,j+1));
					}
				}
			}
			// �ٴٿ� ���ؼ� �ֺ� 8�濡 ���� �𷡼��� ��� ��������
			// �̰� �𷡼��� ��¥ ��°� �ƴ϶� �ֺ��� ��� �� �ٴٰ� �Ǹ� �������ٴ� ���� �ǹ���
			Queue<Node> q = new LinkedList<>();
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[0].length; j++) {
					if(map[i][j]==0) {
						for(int n=0; n<8; n++) {
							int ny = i+dy[n];
							int nx = j+dx[n];
							if(ny<0|| nx<0 || ny>=Y || nx>=X) continue;
							if(map[ny][nx]<=0) continue;
							map[ny][nx]--;
							if(map[ny][nx]==0) {
								map[ny][nx]=-1;
								q.add(new Node(ny,nx));
							}
							
						}
					}
				}
			}
			//q�� ����ִ� �� ���� 8�� Ž�� ��´�.
			//���⼭�� �Ȱ��� 0�� �Ǹ� q�� �ִ´�.
			//ť�� ����ٴ� �� 0�� �Ǵ� ���� ���ٴ� ��.
			int res = 0;
			while(!q.isEmpty()) {
				int size = q.size();
				for(int s =0; s<size; s++) {
					Node node = q.poll();
					int cy = node.y;
					int cx = node.x;
					for (int n = 0; n < 8; n++) {
						int ny = cy+dy[n];
						int nx = cx+dx[n];
						if(ny<0|| nx<0 || ny>=Y || nx>=X) continue;
						if(map[ny][nx]<=0) continue;
						map[ny][nx]--;
						if(map[ny][nx]==0) {
							map[ny][nx]=-1;
							q.add(new Node(ny,nx));
						}
					}
				}
				res++;
			}
			
			System.out.println("#"+(t+1)+" "+res);
		}
	}
	
}
