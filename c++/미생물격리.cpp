#include <iostream>
#include <algorithm>
#include<queue>
#include<vector>

using namespace std;
int T;
int N;
int M;
int K;
int dx[4] = { 0,0,-1,1 };
int dy[4] = { -1,1,0,0 };

vector<int> map[101][101];

typedef struct goon {
	int y;
	int x;
	int num;
	int dir;
}goon;

vector<goon> v;


void mergegoon(int y, int x) {
	int size = map[y][x].size();
	int max = 0;
	int sum = 0;
	int dir = 0;
	int index = 0;
	for (int i = 0; i < size; i++) {
		sum = sum + v[map[y][x][i]].num;
		if (max < v[map[y][x][i]].num) {
			max = v[map[y][x][i]].num;
			dir = v[map[y][x][i]].dir;
			index = map[y][x][i];
		}
		v[map[y][x][i]].num = 0;
	}
	v[index].num = sum;
	v[index].dir = dir;
}

void move() {

	int size = v.size();
	for (int i = 0; i < size; i++) {
		if (v[i].num == 0)
			continue;
		map[v[i].y][v[i].x].clear();

	}
	for (int i = 0; i < size; i++) {
		//cout << "check";
		if (v[i].num == 0)
			continue;
		int cx = v[i].x;
		int cy = v[i].y;
		v[i].x = cx + dx[v[i].dir - 1];
		v[i].y = cy + dy[v[i].dir - 1];
		map[v[i].y][v[i].x].push_back(i);
	}
	for (int i = 0; i < size; i++) {
		if (v[i].num == 0)
			continue;
		if (v[i].x == 0 || v[i].x == N - 1 || v[i].y == 0 || v[i].y == N - 1) {
			v[i].num = v[i].num / 2;
			if (v[i].dir == 1) v[i].dir = 2;
			else if (v[i].dir == 2) v[i].dir = 1;
			else if (v[i].dir == 3)v[i].dir = 4;
			else v[i].dir = 3;
		}
		else if (map[v[i].y][v[i].x].size() > 1) {
			mergegoon(v[i].y, v[i].x);
		}
	}


}

int main() {
	cin >> T;
	for (int t = 0; t < T; t++) {
		cin >> N;
		cin >> M;
		cin >> K;

		for (int i = 0; i < K; i++) {
			goon node;
			cin >> node.y;
			cin >> node.x;
			cin >> node.num;
			cin >> node.dir;
			v.push_back(node);
			map[node.y][node.x].push_back(i);
		}
		for (int i = 0; i < M; i++) {
			move();
		}
		int result = 0;
		for (int i = 0; i < v.size(); i++) {
			result = result + v[i].num;

		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j].clear();
			}
		}
		v.clear();
		cout << "#" << t + 1 << " " << result << endl;
	}
}