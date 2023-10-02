import sys
input = sys.stdin.readline

t = int(input())
ans = [0] * 101
ans[1] = ans[2] = ans[3] = 1

def padoban(n):
    if ans[n] != 0:
        return
    for i in range(4, n + 1):
        ans[i] = ans[i - 2] + ans[i - 3]

for _ in range(t):
    n = int(input())
    padoban(n)
    print(ans[n])