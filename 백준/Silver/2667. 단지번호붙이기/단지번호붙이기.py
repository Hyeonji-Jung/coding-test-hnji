import sys
input = sys.stdin.readline

N = int(input())
maps = [list(map(int, input().rstrip())) for _ in range(N)]
res_cnt = 0
res_cnts = []


def dfs(x, y):
    global res_cnt
    if x < 0 or x >= N or y < 0 or y >= N:
        return
    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]
    if maps[x][y] == 1:
        res_cnt += 1
        maps[x][y] = 0
        for ddx, ddy in zip(dx, dy):
            dfs(x + ddx, y + ddy)


for i in range(N):
    for j in range(N):
        if maps[i][j] == 1:
            dfs(i, j)
            res_cnts.append(res_cnt)
            res_cnt = 0

res_cnts.sort()
print(len(res_cnts))
for res in res_cnts:
    print(res)