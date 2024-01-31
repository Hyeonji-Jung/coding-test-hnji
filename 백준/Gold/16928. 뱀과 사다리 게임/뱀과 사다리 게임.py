import sys
from collections import deque

input = sys.stdin.readline

N, M = map(int, input().split())
visited = [False] * 101

ladder = dict()
snake = dict()

for _ in range(N):
    x, y = map(int, input().split())
    ladder[x] = y

for _ in range(M):
    x, y = map(int, input().split())
    snake[x] = y

q = deque()
q.append((1, 0))

while q:
    x, cnt = q.popleft()
    if x == 100:
        print(cnt)
        break
    for i in range(1, 7):
        nx = x + i
        if nx > 100:
            continue
        if nx in ladder:
            nx = ladder[nx]
        elif nx in snake:
            nx = snake[nx]
        if not visited[nx]:
            visited[nx] = True
            q.append((nx, cnt + 1))
