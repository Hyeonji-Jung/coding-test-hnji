import sys

input = sys.stdin.readline
N = int(input())
S = [list(map(int, input().split())) for _ in range(N)]
visited = [False for _ in range(N)]
min_diff = int(1e9)

def sol(depth, start):
    global min_diff
    if depth == N // 2:
        start_sum = link_sum = 0
        for i in range(N):
            for j in range(N):
                if i == j:
                    continue
                if visited[i] and visited[j]:
                    start_sum += S[i][j]
                elif not visited[i] and not visited[j]:
                    link_sum += S[i][j]
        min_diff = min(min_diff, abs(start_sum - link_sum))
        return
    for i in range(start, N):
        visited[i] = True
        sol(depth + 1, i + 1)
        visited[i] = False

sol(0, 0)
print(min_diff)