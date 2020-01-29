import java.util.*;
import java.io.*;
public class Main {
	public static int R;
	public static int C;
	public static int T;
	public static int map[][];
	public static int spmap[][];
	public static int dx[] = {0,1,0,-1}; 
	public static int dy[] = {-1,0,1,0};
	

	public static void spread(){
		int temp;
		int cx;
		int cy;
		for(int i=0;i<R;i++) {
			for(int j =0; j<C; j++) {
				if(map[i][j]>0) {
					temp=map[i][j]/5;
					if(temp>0) {
						cx=j;
						cy=i;
						for(int n=0; n<4; n++) {
							int nx = cx+dx[n];
							int ny = cy+dy[n];
							if(nx>=0 && nx<C && ny>=0 && ny<R && map[ny][nx]!=-1) {
								spmap[ny][nx] = spmap[ny][nx]+temp;
								spmap[cy][cx] = spmap[cy][cx]-temp; 
							}
						}
					}
				}
			}
		}
		for(int i=0;i<R;i++) {
			for(int j =0; j<C; j++) {
				map[i][j]=spmap[i][j];
			}
		}
		
	}
	public static void machine() {
		int gx=0;
		int gy=0;
		int gx2=0;
		int gy2;
		int cx,cy;
		for(int i=2; i<R;i++) {
			if(map[i][0]==-1) {
				gy=i;
				break;
			}
		}
		gy2=gy+1;
		
		cx=1;
		cy=gy;
		spmap[gy][gx+1]=0;
		while(cx<C-1){			
			spmap[cy][cx+1]=map[cy][cx];
			cx++;
		}
		while(cy>0) {
			spmap[cy-1][cx]=map[cy][cx];
			cy--;
		}
		while(cx>0) {
			spmap[cy][cx-1]=map[cy][cx];
			cx--;
		}
		while(cy<gy-1) {
			spmap[cy+1][cx]=map[cy][cx];
			cy++;
		}
		
		cx=1;
		cy=gy2;
		spmap[gy2][gx2+1]=0;
		while(cx<C-1){			
			spmap[cy][cx+1]=map[cy][cx];
			cx++;
		}
		while(cy<R-1) {
			spmap[cy+1][cx]=map[cy][cx];
			cy++;
		}
		while(cx>0) {
			spmap[cy][cx-1]=map[cy][cx];
			cx--;
		}
		while(cy>gy2+1) {
			spmap[cy-1][cx]=map[cy][cx];
			cy--;
		}
		
		for(int i=0;i<R;i++) {
			for(int j =0; j<C; j++) {
				map[i][j]=spmap[i][j];
			}
		}
		
	}
	
    public static void main(String[] args) throws IOException {
    	long start = System.currentTimeMillis();
    	Scanner sc= new Scanner(System.in);
    	R = sc.nextInt();
    	C = sc.nextInt();
    	T = sc.nextInt();
    	int result=0;
    	
    	map= new int[R][C];
    	spmap = new int[R][C];
    	for(int i =0; i<R; i++){
    		for(int j =0; j<C; j++){
    			map[i][j]=spmap[i][j]=sc.nextInt();
    			
    		}    
    	}
    	for(int i=0; i<T; i++) {
    		spread();
    		machine();
    	}
    	for(int i =0; i<R; i++){
    		for(int j =0; j<C; j++){
    		
    			if(map[i][j]!=-1)
    			{
    				result=result+map[i][j];		
    			}
    		}    
    	
    		
    	}
    	System.out.println(result);

    	
    }
}
    
   