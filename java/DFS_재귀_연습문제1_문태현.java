package homework;

public class DFS_재귀_연습문제1_문태현 {
	static boolean[] visited;
	static int[][] arr;

	public static void main(String[] args) {
		arr = new int[][] { // 그래프 저장 방법: 인접행렬
				{}, // 0번 정점
				{ 0, 0, 1, 1, 0, 0, 0, 0, }, // 1번 정점
				{ 0, 1, 0, 0, 1, 1, 0, 0, }, // 2번 정점
				{ 0, 1, 0, 0, 0, 0, 0, 1, }, // 3번 정점
				{ 0, 0, 1, 0, 0, 0, 1, 0, }, // 4번 정점
				{ 0, 0, 1, 0, 0, 0, 1, 0, }, // 5번 정점
				{ 0, 0, 0, 0, 1, 1, 0, 1, }, // 6번 정점
				{ 0, 0, 0, 1, 0, 0, 1, 0, },// 7번 정점

		};

		visited = new boolean[arr.length]; // 정점의 방문여부를 체크할 변수
		int v = 1; // 시작정점 지정
		DFS(v);

	}

	public static void DFS(int v) {

		System.out.print(v + " ");
		visited[v] = true;// 정점 방문 체크
		for (int i = 0; i < arr[v].length; i++) {
			if (arr[v][i] == 1 && !visited[i]) {
				DFS(i);

			}

		}
	}
}
