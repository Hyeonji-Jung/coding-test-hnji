from collections import defaultdict
import heapq
import sys

input = sys.stdin.readline
INF = int(1e9)

N = int(input())
M = int(input())
graph = defaultdict(list)
dist = [INF] * (N + 1)
for _ in range(M):
    a, b, cost = map(int, input().split())
    graph[a].append((b, cost))
start, dest = map(int, input().split())


def dijk(start):
    q = []
    heapq.heappush(q, (0, start))
    dist[start] = 0

    while q:
        curr_dist, curr = heapq.heappop(q)
        if dist[curr] < curr_dist:
            continue

        for bus in graph[curr]:
            cost = curr_dist + bus[1]
            if cost < dist[bus[0]]:
                dist[bus[0]] = cost
                heapq.heappush(q, (cost, bus[0]))


dijk(start)
print(dist[dest])