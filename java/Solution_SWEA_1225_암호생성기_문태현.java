package homework;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_SWEA_1225_암호생성기_문태현 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[8];
		Queue<Integer> q = new LinkedList();
		for (int t = 0; t < 10; t++) {
			int T = sc.nextInt();
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
				q.add(arr[i]);
			}
			
			while(true) {
				
				int flag =0;
				for(int i=1; i<6; i++) {
					int s = q.poll();
					s=s-i;
					if(s<=0) {
						s=0;
						flag=1;
					}
					q.add(s);
					if(flag ==1) {
						break;
					}
				}
				if(flag ==1) {
					break;
				}
			}
			System.out.print("#"+T+" ");
			for (int i = 0; i < 8; i++) {
				System.out.print(q.poll()+" ");
			}System.out.println();

		}		
	}

}
