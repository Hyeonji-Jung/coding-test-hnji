import sys
from collections import deque

input = sys.stdin.readline
N = int(input())
space = [list(map(int, input().split())) for _ in range(N)]
shark = None
for i in range(N):
    for j in range(N):
        if space[i][j] == 9:
            shark = (i, j)
            space[i][j] = 0
            break
    if shark:
        break
size = 2
dx = [-1, 0, 0, 1]
dy = [0, -1, 1, 0]

def bfs(x, y):
    q = deque([(x, y, 0)])
    visited = [[False] * N for _ in range(N)]
    visited[x][y] = True
    eatable = []
    while q:
        x, y, d = q.popleft()
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0 <= nx < N and 0 <= ny < N and not visited[nx][ny]:
                if space[nx][ny] == 0 or space[nx][ny] == size:
                    visited[nx][ny] = True
                    q.append((nx, ny, d + 1))
                elif space[nx][ny] < size:
                    visited[nx][ny] = True
                    eatable.append((nx, ny, d + 1))
    if eatable:
        eatable.sort(key=lambda x: (x[2], x[0], x[1]))
        return eatable[0]
    return None

time = 0
eat = 0
while True:
    result = bfs(*shark)
    if result:
        x, y, d = result
        time += d
        eat += 1
        if eat == size:
            size += 1
            eat = 0
        shark = (x, y)
        space[x][y] = 0
    else:
        break
print(time)