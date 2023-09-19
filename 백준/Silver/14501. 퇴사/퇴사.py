import sys

input = sys.stdin.readline

n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]
maximum = 0

def dfs(idx, sum):
    global n, arr, maximum
    if idx >= n:
        maximum = max(maximum, sum)
        return
    if idx + 1 <= n:
        dfs(idx + 1, sum)
    if idx + arr[idx][0] <= n:
        dfs(idx + arr[idx][0], sum + arr[idx][1])

dfs(0, 0)
print(maximum)
