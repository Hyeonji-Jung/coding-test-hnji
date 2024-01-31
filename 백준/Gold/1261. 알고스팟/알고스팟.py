import sys
from collections import deque

input = sys.stdin.readline

M, N = map(int, input().split())
maze = [list(map(int, input().rstrip())) for _ in range(N)]
walls = [[-1] * M for _ in range(N)]

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

q = deque()
q.append((0, 0))
walls[0][0] = 0

while q:
    x, y = q.popleft()
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < N and 0 <= ny < M and walls[nx][ny] == -1:
            if maze[nx][ny] == 0:
                walls[nx][ny] = walls[x][y]
                q.appendleft((nx, ny))
            else:
                walls[nx][ny] = walls[x][y] + 1
                q.append((nx, ny))

print(walls[N - 1][M - 1])
