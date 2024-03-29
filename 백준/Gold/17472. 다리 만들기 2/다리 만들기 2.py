import sys
import heapq
from collections import deque

input = sys.stdin.readline
N, M = map(int, input().split())
jido = [list(map(int, input().split())) for _ in range(N)]
visited = [[False for _ in range(M)] for _ in range(N)]
island_cnt = 1
parent = []
bridges = []


def find_island(x, y):
    global jido, visited, island_cnt
    q = deque([])
    jido[x][y] = island_cnt
    visited[x][y] = True
    q.append((x, y))

    while q:
        x, y = q.popleft()
        for dx, dy in ((0, 1), (0, -1), (1, 0), (-1, 0)):
            nx = x + dx
            ny = y + dy
            if 0 <= nx < N and 0 <= ny < M and jido[nx][ny] == 1 and not visited[nx][ny]:
                jido[nx][ny] = island_cnt
                visited[nx][ny] = True
                q.append((nx, ny))
    island_cnt += 1


def make_bridge(x, y):
    global bridges
    for dx, dy in ((0, 1), (0, -1), (1, 0), (-1, 0)):
        d = 1
        while True:
            nx = x + dx * d
            ny = y + dy * d
            if nx < 0 or nx >= N or ny < 0 or ny >= M or jido[x][y] == jido[nx][ny]:
                break
            elif jido[nx][ny] == 0:
                d += 1
                continue
            else:
                bridges.append((d - 1, jido[x][y], jido[nx][ny]))
                break


def find(a):
    if parent[a] == a:
        return a
    parent[a] = find(parent[a])
    return parent[a]


def union(a, b):
    a = find(a)
    b = find(b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b


for i in range(N):
    for j in range(M):
        if jido[i][j] == 1 and not visited[i][j]:
            find_island(i, j)

for i in range(island_cnt):
    parent.append(i)

for i in range(N):
    for j in range(M):
        if jido[i][j] > 0:
            make_bridge(i, j)

heapq.heapify(bridges)
cnt = ans = 0
while bridges:
    length, island1, island2 = heapq.heappop(bridges)
    if length > 1 and find(island1) != find(island2):
        union(island1, island2)
        ans += length
for i in range(1, island_cnt):
    find(i)
print(ans if len(set(parent)) == 2 else -1)