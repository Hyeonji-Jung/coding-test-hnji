import sys
from collections import deque

input = sys.stdin.readline

M, N, H = map(int, input().split())
box = list(list(list(map(int, input().split())) for _ in range(N)) for _ in range(H))
q = deque([])
tomatoes = 0

for k in range(H):
    for i in range(N):
        for j in range(M):
            if box[k][i][j] == 1:
                q.append((k, i, j))
            elif box[k][i][j] == 0:
                tomatoes += 1


def bfs():
    global box, q
    dx = [0, 0, 1, -1, 0, 0]
    dy = [1, -1, 0, 0, 0, 0]
    dz = [0, 0, 0, 0, 1, -1]
    while q:
        z, x, y = q.popleft()
        for ddx, ddy, ddz in zip(dx, dy, dz):
            nx = x + ddx
            ny = y + ddy
            nz = z + ddz
            if 0 <= nx < N and 0 <= ny < M and 0 <= nz < H and box[nz][nx][ny] == 0:
                box[nz][nx][ny] = box[z][x][y] + 1
                q.append((nz, nx, ny))


if tomatoes == 0:
    print(0)
else:
    bfs()
    flag = False
    days = 0
    for k in range(H):
        for i in range(N):
            for j in range(M):
                if box[k][i][j] == 0:
                    print(-1)
                    flag = True
                    break
                else:
                    days = max(days, box[k][i][j])
            if flag:
                break
    if not flag:
        print(days - 1)