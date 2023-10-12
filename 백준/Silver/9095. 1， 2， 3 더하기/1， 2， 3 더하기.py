import sys
input = sys.stdin.readline

t = int(input())
ans = [0] * 11
ans[1] = 1
ans[2] = 2
ans[3] = 4

def sum_1_2_3(n):
    global ans
    if ans[n] != 0:
        return
    for i in range(4, n + 1):
        ans[i] = ans[i - 1] + ans[i - 2] + ans[i - 3]

for _ in range(t):
    n = int(input())
    sum_1_2_3(n)
    print(ans[n])