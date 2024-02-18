from collections import deque
import sys

input = sys.stdin.readline
N, M = map(int, input().split())
m = [list(map(int, input().strip())) for _ in range(N)]
visited = set()


def bfs():
    q = deque([])
    q.append((0, 0, 1, False))
    visited.add((0, 0, False))
    while q:
        x, y, length, broken = q.popleft()
        if x == N - 1 and y == M - 1:
            return length
        for dx, dy in ((0, 1), (0, -1), (1, 0), (-1, 0)):
            nx = x + dx
            ny = y + dy
            if 0 <= nx < N and 0 <= ny < M and (nx, ny, broken) not in visited:
                if m[nx][ny] == 0:
                    visited.add((nx, ny, broken))
                    q.append((nx, ny, length + 1, broken))
                elif m[nx][ny] == 1 and broken == False:
                    visited.add((nx, ny, True))
                    q.append((nx, ny, length + 1, True))
    return -1


print(bfs())
