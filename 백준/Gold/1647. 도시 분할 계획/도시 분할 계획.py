import sys
import heapq

input = sys.stdin.readline

N, M = map(int, input().split())
roads = []
for _ in range(M):
    a, b, c = map(int, input().split())
    heapq.heappush(roads, (c, a, b))
parents = [i for i in range(N + 1)]


def find(a):
    if parents[a] == a:
        return a
    parents[a] = find(parents[a])
    return parents[a]


def union(a, b):
    a = find(a)
    b = find(b)
    if a < b:
        parents[b] = parents[a]
    else:
        parents[a] = parents[b]


weight = 0
last = 0
edges = 0
while edges < N - 1:
    c, a, b = heapq.heappop(roads)
    if find(a) != find(b):
        union(a, b)
        weight += c
        last = c
        edges += 1
print(weight - last)