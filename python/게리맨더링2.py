#전역변수는 참조는 가능하지만 변경은 불가능함.
def makemap(i,j,d1,d2):
#1번 영역 i =x, j= y
    #print(i, j, d1, d2)
    i+=1
    j+=1
    for r in range(1,N+1): #1234 영역
        for c in range(1,N+1):
            if r>=1 and r<i+d1 and c>=1 and c<=j:
                check_map[r-1][c-1]=1
            elif r>=1 and r<=i+d2 and c>j and c<=N:
                check_map[r-1][c-1]=2
            elif r>=i+d1 and r<=N and c>=1 and c<j-d1+d2:
                check_map[r-1][c-1]=3
            elif r>i+d2 and r<=N and c>= j-d1+d2 and c<= N:
                check_map[r-1][c-1]=4
    #경계선 채우기
    i-=1
    j-=1
    for n in range(0,d1+1):
        check_map[i+n][j-n]=5
        check_map[i+d2+n][j+d2-n]=5
    for n in range(0,d2+1):
        check_map[i+n][j+n]=5
        check_map[i+d1+n][j-d1+n]=5
    for y in range(j-d1+1, j+d2) :
        for x in range(N):
            if check_map[x][y]==5:
                hi = x
                break
        for x in range(N-1, 0,-1):
            if check_map[x][y]==5:
                last = x
                break
        for x in range(hi,last) :
            check_map[x][y]=5



def calculate():
    popul_list=[0]*5
    for i in range(N):
        for j in range(N):
            popul_list[check_map[i][j]-1]+=arr[i][j]
    popul_list.sort()
   # print(popul_list)
    res = popul_list[4]-popul_list[0]
    #print(res)
    global minimum
    minimum = min(minimum, res)

def select(i, j):
    for d1 in range(1,N):
        for d2 in range(1,N):
            if d1>=j+1:
                continue
            if d2>=N-(j):
                continue
            if d1+d2>N-(i+1): continue;
            makemap(i,j,d1,d2)
            calculate()
            #for k in range(N): print(check_map[k])
            #print("check")


minimum= float('inf')
N= int(input())
check_map =[[0]*N for _ in range(N)]
arr = [list(map(int, input().split(' '))) for _ in range(N)]
# x, y 결정
for i in range(0, N-2) :
    for j in range(1, N-1) :
        select(i,j) #(x,y)

        #print("check")
print(minimum)