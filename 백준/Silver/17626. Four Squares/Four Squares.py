import sys
input = sys.stdin.readline

n = int(input())
dp = [0] * (n + 1)
dp[1] = 1
for i in range(2, n + 1):
    minimum = sys.maxsize
    for j in range(1, int(i**0.5) + 1):
        minimum = min(minimum, dp[i - j**2])
    dp[i] = minimum + 1

print(dp[n])