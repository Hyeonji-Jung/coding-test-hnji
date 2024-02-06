from math import inf
import sys
from collections import deque

input = sys.stdin.readline
min_sec = [float(inf) for _ in range(100001)]


def dijkstra(N, K):
    min_sec[N] = 0
    cnt = 0
    q = deque([])
    q.append((0, N))

    while q:
        sec, node = q.popleft()
        if node == K:
            if min_sec[node] == sec:
                cnt += 1
            elif min_sec[node] > sec:
                cnt = 1
        nexts = []
        if node - 1 >= 0:
            nexts.append((1, node - 1))
        if node + 1 <= 100000:
            nexts.append((1, node + 1))
        if node * 2 <= 100000:
            nexts.append((1, node * 2))
        for next_sec, next_node in nexts:
            if min_sec[next_node] >= sec + next_sec:
                min_sec[next_node] = sec + next_sec
                q.append((min_sec[next_node], next_node))
    print(min_sec[K])
    print(cnt)


N, K = map(int, input().split())
dijkstra(N, K)