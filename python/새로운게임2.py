def findindex(find_list, target):
    for i in range(len(find_list)):
        if find_list[i] == target:
            return i


def finddir(dir):
    if dir == 1:
        return 2
    elif dir == 2:
        return 1
    elif dir == 3:
        return 4
    elif dir == 4:
        return 3


dx = [0, 1, -1, 0, 0]
dy = [0, 0, 0, -1, 1]

N, K = map(int, input().split(' '))

chess = [list(map(int, input().split(' '))) for _ in range(N)]
horse = [list(map(int, input().split(' '))) for _ in range(K)]
# horse[i][j] i 는 몇번째 말, j 는 0: y, 1: x ,2: dir
chess_map = []
for i in range(N):
    line = []
    for j in range(N):
        line.append([])
    chess_map.append(line)

count = 0
res = 0
for i in range(K):
    chess_map[horse[i][0] - 1][horse[i][1] - 1].append(i)

while True:
    # for _ in range(1):

    flag = 0
    for i in range(K):
        cx = horse[i][1] - 1
        cy = horse[i][0] - 1
        cdir = horse[i][2]

        nx = cx + dx[cdir]
        ny = cy + dy[cdir]

        if nx < 0 or ny < 0 or nx >= N or ny >= N or chess[ny][nx] == 2:
            horse[i][2] = finddir(horse[i][2])
            nx = cx + dx[horse[i][2]]
            ny = cy + dy[horse[i][2]]
            if nx < 0 or ny < 0 or nx >= N or ny >= N or chess[ny][nx] == 2:
                continue

        if chess[ny][nx] == 0:
            index = findindex(chess_map[cy][cx], i)
            length = len(chess_map[cy][cx])
            temp = []

            for j in range(index, length):
                temp.insert(0, chess_map[cy][cx].pop())
            chess_map[ny][nx].extend(temp)
            for num in chess_map[ny][nx]:
                horse[num][0] = ny + 1
                horse[num][1] = nx + 1
            if len(chess_map[ny][nx]) >= 4:
                flag = 1
                break;

        elif chess[ny][nx] == 1:
            index = findindex(chess_map[cy][cx], i)
            length = len(chess_map[cy][cx])
            for j in range(index, length):
                chess_map[ny][nx].append(chess_map[cy][cx].pop())
            for num in chess_map[ny][nx]:
                horse[num][0] = ny + 1
                horse[num][1] = nx + 1

            if len(chess_map[ny][nx]) >= 4:
                flag = 1
                break;

    for i in range(N):
        for j in range(N):
            if len(chess_map[i][j]) >= 4:
                flag = 1
    count += 1
    if flag == 1:
        res = count
        break
    if count > 1000:
        res = -1
        break
print(res)