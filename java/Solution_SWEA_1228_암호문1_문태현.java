package homework;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution_SWEA_1228_암호문1_문태현 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		for(int t =0; t<10; t++) {
			ArrayList<Integer> arr = new ArrayList<Integer>();
			int N = sc.nextInt();
			for(int n =0; n<N; n++) {
				arr.add(sc.nextInt());
			}
			int M = sc.nextInt();
			for(int m=0; m<M; m++) {
				sc.next();
				int x = sc.nextInt();
				int Y= sc.nextInt();
				for(int y =0; y<Y; y++) {
					arr.add(x++, sc.nextInt());
				}
			}
			System.out.print("#"+(t+1)+" ");
			for(int i=0; i<10; i++) {
				System.out.print(arr.get(i)+" ");
			}System.out.println();
			
		}
	}

}
