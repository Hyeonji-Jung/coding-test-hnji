import sys
from collections import deque

input = sys.stdin.readline

r, c = map(int, input().split())
m = [list(map(int, input().split())) for _ in range(r)]
v = [[False for _ in range(c)] for _ in range(r)]
q = deque([])

for i in range(r):
    if len(q) > 0:
        break
    for j in range(c):
        if m[i][j] == 2:
            m[i][j] = 0
            v[i][j] = True
            q.append((i, j))
            break

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
while len(q) != 0:
    x, y = q.popleft()
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < r and 0 <= ny < c and m[nx][ny] == 1 and v[nx][ny] == False:
            q.append((nx, ny))
            m[nx][ny] = m[x][y] + 1
            v[nx][ny] = True

for i in range(r):
    for j in range(c):
        print(-1 if m[i][j] == 1 and v[i][j] == False else m[i][j], end=" ")
    print()