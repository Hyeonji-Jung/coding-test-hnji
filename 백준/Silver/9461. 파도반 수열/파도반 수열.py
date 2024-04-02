import sys
input = sys.stdin.readline

t = int(input())
ans = [0] * 101
ans[1] = ans[2] = ans[3] = 1
for i in range(4, 101):
    ans[i] = ans[i-3] + ans[i-2]

for _ in range(t):
    n = int(input())
    print(ans[n])