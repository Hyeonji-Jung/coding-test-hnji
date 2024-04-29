import sys

input = sys.stdin.readline

N = int(input())
nums = list(map(int, input().split()))

dp = [[False] * N for _ in range(N)]
for i in range(N):
    dp[i][i] = 1
for i in range(N - 1):
    if nums[i] == nums[i + 1]:
        dp[i][i + 1] = True
for l in range(N - 2):
    for i in range(N - 2 - l):
        j = i + 2 + l
        if nums[i] == nums[j] and dp[i + 1][j - 1]:
            dp[i][j] = True 

M = int(input())
for _ in range(M):
    a, b = map(int, input().split())
    print(1 if dp[a - 1][b - 1] else 0)