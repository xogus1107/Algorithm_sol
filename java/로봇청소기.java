import java.util.*;
import java.io.*;
public class Main {
	public static int N,M;
	public static int r,c,dir;
	public static int[][] space;
	public static int dx[] = {-1,0,1,0}; //À§ ¿À ¾Æ·¡ ¿Þ
	public static int dy[] = {0,1,0,-1};
	//dir 0:»ó,1:¿À,2:ÇÏ,3:¿Þ
    public static void main(String[] args) throws IOException {
    	Scanner sc= new Scanner(System.in);
    	
    	N = sc.nextInt();
    	M = sc.nextInt();
    	r = sc.nextInt();
    	c = sc.nextInt();
    	dir = sc.nextInt();
    	space = new int[N][M];
    	for(int i=0;i<N;i++){
    		for(int j = 0 ; j<M;j++) {
    			space[i][j]=sc.nextInt();
    		}
    	}
    	int count = 0;
    	
    	//ÇöÀçÄ­ Ã»¼Ò Ã»¼Ò=2;
    	
    	dfs(r,c,dir);
    	for(int i=0;i<N;i++) {
    		for(int j = 0; j<M;j++)
    		{
    		
    			if(space[i][j]==2)
    				count++;
    		}
    	}
    	System.out.println(count);
    	
    }
    public static void dfs(int x, int y, int dir) {
    	space[x][y]=2;
    	boolean flags = false;
    	int nx,ny;
    	int nextdir=dir;
    	for(int i=0;i<4;i++) {
    		nextdir=next_dir(nextdir);
    		nx=x+dx[nextdir];
    		ny=y+dy[nextdir];
    		if(nx>0 && nx<N-1 && y>0 && y<M-1) {
    			if(space[nx][ny]==0)
    			{   
    				flags=true;
    				dfs(nx,ny,nextdir);
    				break;
    			}
    			else
    				continue;
    		}
    	}
    	
    	if(!flags) {
    		int backdir=backDirection(dir);
    		nx=x+dx[backdir];
    		ny=y+dy[backdir];
    		if(nx>0 && nx<N-1 && y>0 && y<M-1) {
    			if(space[nx][ny]!=1)
    			{
    				dfs(nx,ny,dir);
    			}
    			else 
    				return;
    		}
    	}
    	
    }
 
    
    public static int backDirection(int d) {
        if (d == 0) {
            return 2;
        } else if (d == 1) {
            return 3;
        } else if (d == 2) {
            return 0;
        } else {
            return 1;
        }
    }
     
    public static int next_dir(int dir) {
    	if(dir==0) {
    		return 3;
    	}
    	else if(dir==1)
    	{
    		return 0;
    	}
    	else if(dir==2) {
    		return 1;
    	}
    	else 
    		return 2;
    
    }
}  



    
    

