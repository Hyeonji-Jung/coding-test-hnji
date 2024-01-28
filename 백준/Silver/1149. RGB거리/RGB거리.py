import sys

input = sys.stdin.readline

N = int(input())
rgbs = list(list(map(int, input().split())) for _ in range(N))
dp = [[sys.maxsize for _ in range(N)] for _ in range(N)]

for i in range(3):
    dp[0][i] = rgbs[0][i]

for i in range(1, N):
    for j in range(3):
        for k in range(3):
            if j != k:
                dp[i][j] = min(dp[i][j], dp[i - 1][k] + rgbs[i][j])

print(min(dp[N - 1]))
