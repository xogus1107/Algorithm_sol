import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
 
public class Main{
 
    public static int room[][];
    public static int roomcopy[][];
 
    public static boolean firstwallcheck[][];
    public static int roomnumberof = 0;
    public static int max = 0;
    public static int count=0;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
 
        String a[] = bufferedReader.readLine().split(" ");
 
        int N = Integer.parseInt(a[0]); // ���� ����ũ��
        int M = Integer.parseInt(a[1]); // ���� ����ũ��
 
        room = new int[N][M];
        roomcopy = new int[N][M];
        firstwallcheck = new boolean[N][M];
 
        ArrayList<Vertex> arrayList = new ArrayList<>();
 
        for (int i = 0; i < N; i++) {
            String b[] = bufferedReader.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(b[j]);
                roomcopy[i][j] = Integer.parseInt(b[j]);
                if (room[i][j] == 2) {
                    arrayList.add(new Vertex(i, j));
                }
            }
        }
 
        // �� ���� �Ϸ�
 
        for (int i1 = 0; i1 < N; i1++) {
            for (int i2 = 0; i2 < M; i2++) {
 
                // ù��° �� �����ϱ�
 
                if (room[i1][i2] != 0) {
                    continue;
                } else if (!firstwallcheck[i1][i2]) {
                    room[i1][i2] = 1; // ù��° �� ����
                    firstwallcheck[i1][i2] = true;
 
                }
 
                for (int i3 = 0; i3 < N; i3++) {
                    for (int i4 = 0; i4 < M; i4++) {
 
                        // �ι�° �� �����ϱ�
 
                        if (room[i3][i4] != 0) {
                            continue;
                        } else if (i3 == i1 && i4 < i2) {
 
                            continue;
 
                        } else if (i3 < i1) {
                            continue;
                        } else {
                            room[i3][i4] = 1; // �ι�° �� ����
                        }
 
                        for (int i5 = 0; i5 < N; i5++) {
                            for (int i6 = 0; i6 < M; i6++) {
 
                                // ����° �� �����ϰ� dfs ������
 
                                if (room[i5][i6] != 0) {
                                    continue;
                                } else if (i5 == i3 && i6 < i4) {
                                    continue;
 
                                } else if (i5 < i3) {
                                    continue;
                                } else {
                                    room[i5][i6] = 1; // ����° �� ����
                                    copyroom(N, M);
                                  
        							
                                    
                                    for (int i = 0; i < arrayList.size(); i++) {
                                        Vertex vertex = arrayList.get(i);
                                        int x = vertex.x;
                                        int y = vertex.y;
                                        dfs(x, y, N, M);
                                    }
                                    
                                    
 
                                    checkroom(N, M);
                                    copyroom2(N, M);
                                    
                                    
                                    room[i5][i6] = 0;
                                }
 
                            }
                        }
 
                        room[i3][i4] = 0;
 
                    }
                }
 
                room[i1][i2] = 0;
 
            }
        }
 
        System.out.println(max);
    
        
 
    }
 
    static void dfs(int x, int y, int N, int M) {
 
        // �Ʒ�
        if (x + 1 < N && room[x + 1][y] == 0) {
            room[x + 1][y] = 2;
            dfs(x + 1, y, N, M);
        }
 
        // ��
        if (x - 1 >= 0 && room[x - 1][y] == 0) {
            room[x - 1][y] = 2;
            dfs(x - 1, y, N, M);
        }
 
        // ������
        if (y + 1 < M && room[x][y + 1] == 0) {
            room[x][y + 1] = 2;
            dfs(x, y + 1, N, M);
        }
 
        // ����
        if (y - 1 >= 0 && room[x][y - 1] == 0) {
            room[x][y - 1] = 2;
            dfs(x, y - 1, N, M);
        }
 
    }
 
    static void checkroom(int N, int M) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (room[i][j] == 0) {
                    roomnumberof++;
                }
            }
        }
 
        if (max < roomnumberof) {
            max = roomnumberof;
        }
        
        roomnumberof = 0;
 
    }
 
    static void copyroom(int N, int M) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                roomcopy[i][j] = room[i][j];
            }
        }
    }
    
    static void copyroom2(int N, int M) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                room[i][j] = roomcopy[i][j];
            }
        }
    }
 
    static class Vertex {
        int x;
        int y;
 
        public Vertex(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }
 
    }
 
}