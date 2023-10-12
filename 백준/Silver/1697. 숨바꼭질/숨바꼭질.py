import sys
from collections import deque

input = sys.stdin.readline

n, k = map(int, input().split())
MAX = 100000
visited = [0] * (MAX + 1)

def bfs():
    q = deque([n])
    while len(q):
        v = q.popleft()
        if v == k:
            return visited[v]
        for next in (v - 1, v + 1, v * 2):
            if 0 <= next <= MAX and visited[next] == 0:
                visited[next] = visited[v] + 1
                q.append(next)

print(bfs())