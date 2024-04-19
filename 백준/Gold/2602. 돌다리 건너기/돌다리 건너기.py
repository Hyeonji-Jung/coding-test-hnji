import sys

input = sys.stdin.readline

chars = list(input().strip())
strings = [list(input().strip()) for _ in range(2)]

len_chars = len(chars)
len_strs = len(strings[0])

dp = [[[0]*2 for _ in range(len_chars)] for _ in range(len_strs)]

for i in range(len_strs):
    for j in range(len_chars):
        for k in range(2):
            if strings[k][i] == chars[j]:
                if j == 0:
                    dp[i][j][k] = 1
                else:
                    for l in range(i):
                        dp[i][j][k] += dp[l][j-1][1-k]

ans = 0
for i in range(len_strs):
    ans += dp[i][-1][0] + dp[i][-1][1]
print(ans)