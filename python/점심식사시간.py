def simulation(idx):
    # 거리부터 계산하자.
    # stair[idx], person[i] 중 visited[i] 가
    distance = [0] * len(person)
    state = [0] * len(person)  # 0 : 계단 가는중, 1 : 계단 대기 2. 계단 들어감.
    queue = []
    stair_dis = map_arr[stair[idx][0]][stair[idx][1]]
    count = 0

    for i in range(len(person)):
        if visited[i] == idx:
            count += 1
            y = person[i][0]
            x = person[i][1]
            distance[i] = abs(y - stair[idx][0]) + abs(x - stair[idx][1])
    minute = 0
    while True:  # 1반복 1분

        for i in range(len(person)):
            if state[i] == 0:  # 계단 가는중.
                distance[i] -= 1
                if distance[i] == 0:
                    state[i] = 1
        for i in range(len(person)):
            if state[i] == 2:
                distance[i] -= 1
                if distance[i] == 0:
                    queue.pop()
                    state[i] = -1
                    count -= 1
        for i in range(len(person)):
            if state[i] == 1:  # 큐
                if len(queue) < 3:  # 큐에 들어갈 수 있다.
                    state[i] = 2
                    distance[i] = stair_dis
                    queue.insert(0, i)

        minute += 1
        if count == 0:
            return minute

    # print(distance)


def dfs(length, index):
    global min_res
    if index == length:
        # visited에 어떤사람이 어떤계단으로 들어가는지 정해져있다. 여기서 simul 돌려서 이동 시간 구하면 됨.
        min_res = min(max(simulation(0), simulation(1)), min_res)
        return
    dfs(length, index + 1)

    visited[index] = 1
    dfs(length, index + 1)
    visited[index] = 0


T = int(input())

for t in range(T):
    min_res = 1000000
    N = int(input())
    map_arr = [list(map(int, input().split(' '))) for _ in range(N)]

    person = []
    stair = []
    for i in range(N):
        for j in range(N):
            if map_arr[i][j] == 1:
                person.append([i, j])
            elif map_arr[i][j] != 0:
                stair.append([i, j])
    length = len(person)
    visited = [0] * len(person)

    dfs(length, 0)
    print("#" + str(t + 1) + " " + str(min_res + 1))