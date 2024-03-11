N = int(input())
dp = [0 for _ in range(N+2)]
dp[1] = 1
dp[2] = 2
for i in range(3, N + 1):
    if (i % 2 == 1):
        dp[i] = dp[i - 1]
    else:
        dp[i] = (dp[i - 1] + dp[i // 2]) % 1_000_000_000
print(dp[N])