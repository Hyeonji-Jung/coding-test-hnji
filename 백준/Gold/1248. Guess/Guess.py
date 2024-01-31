import sys

input = sys.stdin.readline
n = int(input())
arr = list(input().strip())
temp_idx = 0
matrix = [[0] * n for _ in range(n)]
res = [0] * n

def chk_sign(idx):
    temp_sum = 0
    for i in range(idx, -1, -1):
        temp_sum += res[i]
        if temp_sum == 0 and not matrix[i][idx] == 0:
            return False
        if temp_sum > 0 and matrix[i][idx] <= 0:
            return False
        if temp_sum < 0 and matrix[i][idx] >= 0:
            return False
    return True

def solve(idx):
    if idx == n:
        return True
    if matrix[idx][idx] == 0:
        res[idx] = 0
        return solve(idx + 1)
    for i in range(1, 11):
        res[idx] = matrix[idx][idx] * i
        if chk_sign(idx) and solve(idx + 1):
            return True
    return False

for i in range(n):
    for j in range(i, n):
        if arr[temp_idx] == '+':
            matrix[i][j] = 1
        elif arr[temp_idx] == '-':
            matrix[i][j] = -1
        temp_idx += 1
solve(0)
print(' '.join(map(str, res)))