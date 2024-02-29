from collections import deque
from copy import deepcopy

N, M = map(int, input().split())
g = []
virus = []
safe = 0
g = [list(map(int, input().split())) for _ in range(N)]

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

def cnt_safe(graph):
    cnt = 0
    for i in range(N):
        for j in range(M):
            if graph[i][j] == 0:
                cnt += 1
    return cnt

def bfs():
    q = deque()
    test = deepcopy(g)
    for i in range(N):
        for j in range(M):
            if test[i][j] == 2:
                q.append((i, j))
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if (0 <= nx < N) and (0 <= ny < M) and test[nx][ny] == 0:
                q.append((nx, ny))
                test[nx][ny] = 2
    global safe
    safe = max(safe, cnt_safe(test))

def make_wall(cnt):
    if cnt == 3:
        bfs()
        return
    for i in range(N):
        for j in range(M):
            if g[i][j] == 0:
                g[i][j] = 1
                make_wall(cnt + 1)
                g[i][j] = 0

make_wall(0)
print(safe)