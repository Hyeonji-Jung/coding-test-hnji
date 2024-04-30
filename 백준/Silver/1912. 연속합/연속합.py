import sys

input = sys.stdin.readline

N = int(input())
seq = list(map(int, input().split()))
dp = [n for n in seq]
answer = seq[0]

for i in range(1, N):
    dp[i] = max(seq[i], dp[i - 1] + dp[i])
    answer = max(answer, dp[i])

print(answer)