import sys

input = sys.stdin.readline

def round(x):
    return int(x) + 1 if x - int(x) >= 0.5 else int(x)

def calculate_difficulty():
    global n, arr
    if n == 0:
        return 0
    elif n <= 4:
        return int(round(sum(arr) / n))
    excep = int(round(n * 0.15))
    return int(round(sum(arr[excep : len(arr) - excep]) / (n - excep * 2)))

n = int(input())
arr = [int(input()) for _ in range(n)]
arr.sort()
print(calculate_difficulty())
