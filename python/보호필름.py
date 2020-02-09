from itertools import combinations
import time
import copy
def check_pass():

    for i in range(W):
        flag = 0
        count =0
        check = map_arr[0][i]
        for j in range(D):
            if check==map_arr[j][i]:
                count+=1
            elif check != map_arr[j][i]:
                check = map_arr[j][i]
                count=1
            if count == K:
                flag = 1
                break
        if flag ==0: return False
    return True

def sol(index, insert):
    global min_res
    #index 를 아무것도 안칠하느냐 A로 칠하느냐 B로 칠하느냐.
    # 아무것도 안칠함
    if insert> min_res : return
    if index == D :
        if check_pass() :
            min_res = min(min_res, insert)
        return;

    sol(index+1, insert)
    # 이게 가장 훌륭하지 않나 싶음 직관적으로 왜 되는지 확실하고
    # 앞으로 값을 복사 할일이 있으면 이런식으로 하자.
    tmp = [0] * W
    for i in range(W):
        tmp[i] = map_arr[index][i]
    map_arr[index][i]=[0]*W
    sol(index + 1, insert + 1)
    map_arr[index][i]=[1]*W
    sol(index + 1, insert + 1)
    map_arr[index] = tmp
    ''' tmp = map_arr[index]
     map_arr[index]=[0]*W
     sol(index+1, insert+1)
     map_arr[index] = [1] * W
     sol(index+1,insert+1)
     map_arr[index]=tmp
    이거는 왜 되는지 모르겠는데 됨 뇌피셜로 [0]*W 가 새로운 리스트를 만들어 주는거라
    tmp 와 map_arr사이에 주소 연결이 끊지 않았나...
    
     tmp = [0]*W
     for i in range(W):
         tmp[i]=map_arr[index][i]
     for i in range(W):
         map_arr[index][i]=0
     sol(index+1, insert+1)
     for i in range(W):
         map_arr[index][i]=1
     sol(index+1,insert+1)
     map_arr[index]=tmp
    #이거는 당연히 됨 새로운 tmp를 만들었고 거기에 값을 복사했고 map_arr에 값을 따로 바꾼거니까
    
     sol(index+1, insert)
     # A로 칠함
     tmp = map_arr[index]
     for i in range(W):
         map_arr[index][i]=0
     sol(index+1, insert+1)
     for i in range(W):
         map_arr[index][i]=1
     sol(index+1,insert+1)
     map_arr[index]=tmp
     얘가 안되는데 tmp에 map_arr[index] 의 주소가 들어가고 map_arr의 값을 바꾸니 tmp값도 같이 바뀌는 듯 안됨
     '''
T = int(input())
for t in range(T):
    D,W,K = list(map(int, input().split(' '))) #두께, 셀, 기준
    map_arr= [list(map(int,input().split(' '))) for _ in range(D)]
    min_res = 100000
    if check_pass() :
        print('#'+str(t+1)+' ' +str(0))
        continue;
    if K ==1 :
        print('#' + str(t + 1) + ' ' + str(0))
        continue;

    sol(0, 0)
    print('#' + str(t + 1) + ' ' + str(min_res))

