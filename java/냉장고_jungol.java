package com.ssafy.algo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 냉장고 {
	public static int c[][];
	//두개가 겹치는지 확인
	public static boolean isDup(int one, int two) {
		
		if(c[one][1]>=c[two][0] && c[one][0]<=c[two][1]){
			return true;
		}
		else 
			return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		c = new int[N][3]; // 0 : 최저, 1 : 최고, 2: alive
		for(int n=0; n<N; n++) {
			c[n][0]=sc.nextInt();
			c[n][1]=sc.nextInt();
			c[n][2]=1;
		}
		//최저 기준 sort
		Arrays.sort(c, new Comparator<int []>() {
			@Override
			public int compare(int[] c1, int[] c2) {
				// TODO Auto-generated method stub
				return c1[0]-c2[0];
			}		
		});
		
		int sum =0;
		for(int i=0; i< N; i++) {
			//c 에 alive를 표시하여 이미 냉장고에 넣은 것은 sum++하며 continue;
			//sum++는 건너뛴수 -> 전체(N)- 건너뛴거(sum) = 안건너뛴거(N-sum) = 냉장고 수
			if(c[i][2]==0) {
				sum ++;
				continue;
			}
			// ci 와  cj dup 여부 확인  
			for(int j=i; j<N; j++) {
				if(isDup(i,j)) {
					// 겹치면 그녀석들 다 죽은 상태로 변환.
					c[j][2]=0;
					//여기가 핵심인데
					//겹쳤으면 왼쪽은 sort된 상태니까 상관없고 오른쪽 범위를 통일 시켜야 됨
					// 그래야 같은 냉장고 소속인지 알지.
					if(c[i][1]<=c[j][1])
						c[j][1]=c[i][1];
					else if(c[i][1]>=c[j][1]) {
						c[i][1]=c[j][1];
					}
				}
			}
		}
		System.out.println(N-sum);
		
		
		
		
		
		
	}

}
