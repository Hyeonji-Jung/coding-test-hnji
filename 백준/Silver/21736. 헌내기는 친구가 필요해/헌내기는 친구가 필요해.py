import sys
from collections import deque

input = sys.stdin.readline

N, M = map(int, input().split())
campus = []
q = deque([])
for i in range(N):
    row = list(input().rstrip())
    for j in range(M):
        if row[j] == "I":
            q.append((i, j))
            row[j] = "X"
    campus.append(row)


def bfs():
    global N, M, campus, q
    people = 0
    while len(q) != 0:
        x, y = q.popleft()
        dx = [0, 0, 1, -1]
        dy = [1, -1, 0, 0]
        for d_x, d_y in zip(dx, dy):
            nx = x + d_x
            ny = y + d_y
            if 0 <= nx < N and 0 <= ny < M and campus[nx][ny] != "X":
                if campus[nx][ny] == "P":
                    people += 1
                q.append((nx, ny))
                campus[nx][ny] = "X"
    return people


res = bfs()
print(res if res != 0 else "TT")