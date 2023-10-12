import sys
from collections import deque

input = sys.stdin.readline

N, M = map(int, input().split())
conn = [[0] * N for _ in range(N)]
visited = [[0] * N for _ in range(N)]
kb = (0, sys.maxsize)
for _ in range(M):
    x, y = map(int, input().split())
    conn[x - 1][y - 1] = conn[y - 1][x - 1] = 1


def bfs(x):
    q = deque([])
    for i in range(N):
        if i != x and conn[x][i] == 1:
            q.append((i, 1))
            visited[x][i] = 1
    while len(q) != 0:
        v, length = q.popleft()
        for i in range(N):
            if i != x and i != v and conn[v][i] == 1 and visited[x][i] == 0:
                q.append((i, length + 1))
                visited[x][i] = length + 1


for i in range(N):
    bfs(i)
    curr = sum(visited[i])
    kb = (i, curr) if curr < kb[1] else kb
print(kb[0] + 1)