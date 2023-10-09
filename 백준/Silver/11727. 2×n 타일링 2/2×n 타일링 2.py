import sys

input = sys.stdin.readline

n = int(input())
ans = [0] * 10001
ans[1] = 1
ans[2] = 3
for i in range(3, n + 1):
    ans[i] = ans[i - 1] + 2 * ans[i - 2]
print(ans[n] % 10007)