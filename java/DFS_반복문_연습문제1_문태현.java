package homework;

import java.util.Stack;

public class DFS_반복문_연습문제1_문태현 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr ={ //그래프 저장 방법 : 인접행렬
				{},
				{0,0,1,1,0,0,0,0},
				{0,1,0,0,1,1,0,0},
				{0,1,0,0,0,0,0,1},
				{0,0,1,0,0,0,1,0},
				{0,0,1,0,0,0,0,0},
				{0,0,0,0,1,1,0,1},
				{0,0,0,1,0,0,1,0}
		};
		Stack<Integer> stack = new Stack<Integer>();
		boolean visited[] = new boolean[arr.length];
		
		int v =1; //시작 점
		stack.push(v);
		visited[v]=true;
		System.out.print(v+" ");
		
		while(!stack.isEmpty()) {
			int w= -1;
			for(int i=1; i<arr[v].length;i++) {
				if(arr[v][i]==1 && !visited[i]) {
					
					w=i;
					stack.push(i);
					visited[i]=true;
					System.out.print(w+ " ");
					v=w;
					break;
				}
			}
			if(w==-1) {
				v=stack.pop();
			}
		}
	}

}
