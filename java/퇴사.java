package com.ssafy.algo;

import java.util.Arrays;
import java.util.Scanner;

public class 퇴사 {
	public static int N;
	public static int T[];
	public static int P[];
	public static int candidate[];
	public static int max_res = -1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		T = new int[N];
		P = new int[N];
		candidate = new int[N];
		for(int n=0; n<N; n++) {
			T[n]=sc.nextInt();
			P[n] = sc.nextInt();
		}
		makecand(0,0);
		makecand(0, 1);
		System.out.println(max_res);
		//부분집합 구하기 
	}
	public static void makecand(int index,int val) {
		if(index == N) {
			if(checkpossible()) {
				max_res = Math.max(max_res, calculate());
			}
		
			return;
		}
		candidate[index]=val;
		makecand(index+1, 0);
		makecand(index+1, 1);
		candidate[index] = 0;
		
	}
	public static int calculate() {
		int sum =0;
		for(int i=0; i<N; i++) {
			if(candidate[i]==1) {
				sum+=P[i];
			}
		}
		return sum;
	}
	public static boolean checkpossible() {
		int check[] = new int[N];
		for(int i=0; i<N; i++) {
			if(candidate[i]==1) {
				int day = T[i];
				for(int j = i ;j<i+day; j++) {
					if(j>=N || check[j]==1) {
						return false;
					}
					check[j]=1;
				}
			}
		}
		return true;
	}
}
