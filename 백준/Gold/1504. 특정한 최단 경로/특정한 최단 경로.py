import sys
import heapq

input = sys.stdin.readline
N, E = map(int, input().split())
graph = {i: [] for i in range(1, N + 1)}
for _ in range(E):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))
    graph[b].append((a, c))
v1, v2 = map(int, input().split())
res1 = res2 = 0

def dijkstra(start):
    global dist
    dist[start] = 0
    heap = [(0, start)]
    while heap:
        d, v = heapq.heappop(heap)
        if dist[v] < d:
            continue
        for u, w in graph[v]:
            if dist[u] > d + w:
                dist[u] = d + w
                heapq.heappush(heap, (dist[u], u))

dist = [float('inf')] * (N + 1)
dijkstra(1)
res1 += dist[v1]
dist = [float('inf')] * (N + 1)
dijkstra(v1)
res1 += dist[v2]
dist = [float('inf')] * (N + 1)
dijkstra(v2)
res1 += dist[N]

dist = [float('inf')] * (N + 1)
dijkstra(1)
res2 += dist[v2]
dist = [float('inf')] * (N + 1)
dijkstra(v2)
res2 += dist[v1]
dist = [float('inf')] * (N + 1)
dijkstra(v1)
res2 += dist[N]

print(min(res1, res2) if min(res1, res2) != float('inf') else -1)