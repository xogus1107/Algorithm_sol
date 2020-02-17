package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 종교 {
	
	public static int[] arr;
	public static int[] p;
	public static int[] visited;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(bf.readLine(), " ");
		int N=0;
		int M=0;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1];
		visited = new int[N+1];
		p = new int[N+1];
		for(int i=1; i< N+1; i++) {
			makeSet(i);
		}
		int index =0;
		int map[][] = new int[M][2];
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(bf.readLine()," ");
			int first= Integer.parseInt(st.nextToken());
			int second= Integer.parseInt(st.nextToken());
			union(first, second);
		}
	
		int count=0;
		for(int i=1; i<p.length; i++) {
			if(p[i]==i) {
				count++;
			}
		}
		System.out.println(count);
	}
	public static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		if(arr[px]<arr[py]) {
			p[px]=py;
		}
		else {
			p[py] =px;
			if(arr[px]==arr[py]) {
				arr[px]++;
			}
		}
	}
	
	public static int findSet(int x) {
		if(p[x]==x) {
			return p[x];
		}
		else {
			p[x]=findSet(p[x]);
			return p[x];
		}
		
	}
	
	public static void makeSet(int x) {
		p[x]=x;
	}
		
}
