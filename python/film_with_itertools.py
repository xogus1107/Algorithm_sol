from itertools import combinations
import time
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

def swap(a) :
    if a==0 :
        return 1
    else : return 0

def sol(c) :
    temp=[]

    for i in range(len(c)+1):
        temp.extend(combinations(c, i))

    for t in temp :
        back_list = []
        for target in c :
            tmp = [0]*W
            for i in range(W):
                tmp[i] = map_arr[target][i]
            back_list.append(tmp)

            if target in t :
                map_arr[target] = [1]*W
            else :
                map_arr[target] = [0]*W
        if check_pass() :
            return 1
        index =0
        for target in c :
            for w in range(W):
                map_arr[target][w] = back_list[index][w]
            index+=1





        #t 마다 바꿨다가 원상복구 필요

# c 가지고 powerset 만들기
# powerset의 행에만 1
# check_pass()
# if true 이면 모든 루프 break 후 결과 출력
T = int(input())
for t in range(T):
    D,W,K = list(map(int, input().split(' '))) #두께, 셀, 기준
    map_arr= [list(map(int,input().split(' '))) for _ in range(D)]

    if check_pass() :
        print('#'+str(t+1)+' ' +str(0))
        continue;
    if K ==1 :
        print('#' + str(t + 1) + ' ' + str(0))
        continue;
    flag =0

    for i in range(1, K+1) :

        list_c = list(combinations(range(D),i))
        for c in list_c :
            flag = sol(c)
            if flag ==1 :
                break;
        if flag ==1 :
            print('#'+str(t+1)+' ' +str(i))
            break;
