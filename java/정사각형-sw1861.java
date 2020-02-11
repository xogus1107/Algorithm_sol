package com.ssafy.algo;

import java.util.Scanner;

public class 정사각형 { 
    static int N;
    static int map[][];
    static int visited[][];
    static int dx[] = { 0, 0, -1, 1 };
    static int dy[] = { -1, 1, 0, 0 };
    static int max_y = -1;
    static int max_x = -1;
    static int min_bang = 1000000;
    static int max_res = -1;
    public static void sol(int gy, int gx, int y, int x, int count) {
 
        int cnum = map[y][x];
        visited[y][x] = 1;
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= N || nx >= N) {
                cnt++;
                continue;
            }

            if (visited[ny][nx] == 1) { 
                cnt++;
                continue;
            }
 
            if (map[ny][nx] != map[y][x] + 1) {
            	cnt++;
                continue;
            }
            sol(gy, gx, ny, nx, count + 1);
 
        }
 
        visited[y][x] = 0;
 
        if (cnt == 4) {
            if (max_res == count) {
                if(min_bang>map[gy][gx]) {
                    min_bang=map[gy][gx];
                }
            }else if(max_res<count) {
                min_bang=map[gy][gx];
                max_res =count;
            }
            return;
        }
 
    }
 
    public static void main(String[] args) {
 
        // TODO Auto-generated method stub
 
        Scanner sc = new Scanner(System.in);
 
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            N = sc.nextInt();
            map = new int[N][N];
            visited = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            
            max_res = -1;
            max_y = -1;
            max_x = -1;
            min_bang = 1000000;
            max_res = -1;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sol(i, j, i, j, 1);
                }
            }
 
            System.out.println("#" + (t + 1) + " " + min_bang + " " + max_res);
 
        }
 
    }
}

