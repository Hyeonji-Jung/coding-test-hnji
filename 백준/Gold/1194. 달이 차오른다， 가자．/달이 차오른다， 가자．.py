import sys
from collections import deque

input = sys.stdin.readline
N, M = map(int, input().split())
miro = [list(input().strip()) for _ in range(N)]


def have_key(key, door):
    return key & (1 << (ord(door) - ord('A')))


def bfs(x, y):
    visited = [[[False for _ in range(1 << 6)]
                for _ in range(M)] for _ in range(N)]
    q = deque([])
    visited[x][y][0] = True
    q.append((x, y, 0, 0))
    while q:
        x, y, dist, key = q.popleft()
        if miro[x][y] == '1':
            print(dist)
            return
        for dx, dy in ((1, 0), (-1, 0), (0, 1), (0, -1)):
            nx = x + dx
            ny = y + dy
            if 0 <= nx < N and 0 <= ny < M and not visited[nx][ny][key]:
                if miro[nx][ny] == '1' or miro[nx][ny] == '.':
                    visited[nx][ny][key] = True
                    q.append((nx, ny, dist + 1, key))
                elif 'a' <= miro[nx][ny] <= 'f':
                    nkey = key | (1 << (ord(miro[nx][ny]) - ord('a')))
                    visited[nx][ny][nkey] = True
                    q.append((nx, ny, dist + 1, nkey))
                elif 'A' <= miro[nx][ny] <= 'Z':
                    if have_key(key, miro[nx][ny]):
                        visited[nx][ny][key] = True
                        q.append((nx, ny, dist + 1, key))
    print(-1)


for i in range(N):
    flag = False
    for j in range(M):
        if miro[i][j] == '0':
            miro[i][j] = '.'
            bfs(i, j)
            flag = True
    if flag:
        break