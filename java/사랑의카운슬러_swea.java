package practice;

import java.util.Scanner;

public class 사랑의카운슬러 {

	 public static void calculate(){
		 
	        long x =0; 
	        long y=0;
	        for(int i=0; i<N; i++){
	            if(visited[i]==1){
	 
	                x+= -arr[i][0];
	                y+= -arr[i][1];
	            }
	            else{
	                x+= arr[i][0];
	                y+= arr[i][1];
	            }
	        }
	         
	        min_res = Math.min(min_res,x*x+y*y);
	 
	        // math 계산
	    }
	 
	  
	 
	    public static void dfs(int index,int count){
	 
	        if(count==N/2){
	            calculate();
	            return;
	        }
	        if(index>N-1) return;
	        for(int i=index; i<N; i++) {
	        	if(visited[i]!=1)
	        	visited[i]=1;
	        	dfs(i+1, count+1);
	        	visited[i]=0;
	        }
	    }
	    public static long min_res;
	    public static int[] visited;
	    public static int[][] arr;
	    public static int N;
	    public static void main(String[] args) {
	 
	        Scanner sc= new Scanner(System.in);
	        int T = sc.nextInt();
	        for(int t=0; t<T; t++){
	            N = sc.nextInt();
	            arr = new int[N][2];
	            visited = new int[N];
	 
	            for(int n=0 ;n<N; n++){
	 
	                arr[n][0]= sc.nextInt();
	                arr[n][1]=sc.nextInt();
	            }
	            min_res = Long.MAX_VALUE;
	            dfs(0, 0);
	            System.out.println("#"+(t+1)+" "+min_res);
	        }
	 
	        int arr[]= {1,2,2,3,3,3,5,5,5};
			int[] count = new int[6];
			for(int i =0; i<arr.length; i++) {
				
				count[arr[i]]++;
			}
			
	 
	    }
		
		

}
