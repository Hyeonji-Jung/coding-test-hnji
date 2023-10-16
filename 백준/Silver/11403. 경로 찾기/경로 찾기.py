import sys
input = sys.stdin.readline

N = int(input())
graph = [list(map(int, input().split())) for _ in range(N)]
dist = [[sys.maxsize] * N for _ in range(N)]
for i in range(N):
    for j in range(N):
        if graph[i][j] == 1:
            dist[i][j] = 1
for k in range(N):
    for i in range(N):
        for j in range(N):
            dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])
for i in range(N):
    for j in range(N):
        print(1 if dist[i][j] != sys.maxsize else 0, end=" ")
    print()