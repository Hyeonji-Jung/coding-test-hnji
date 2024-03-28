import sys

input = sys.stdin.readline
N, M = map(int, input().split())
memory = list(map(int, input().split()))
cost = list(map(int, input().split()))

sum_cost = sum(cost)
dp = [[0] * (sum_cost + 1) for _ in range(N + 1)]
dp[0][0] = 0

for i in range(1, N + 1):
    for j in range(sum_cost + 1):
        dp[i][j] = dp[i - 1][j]
        if cost[i - 1] <= j:
            dp[i][j] = max(dp[i][j],
                           dp[i - 1][j - cost[i - 1]] + memory[i - 1])
for i in range(sum_cost + 1):
    if dp[N][i] >= M:
        print(i)
        break