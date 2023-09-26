import sys
input = sys.stdin.readline

m, n = map(int, input().split())
nums = [True] * (n + 1)
nums[1] = False
for i in range(2, n + 1):
    for j in range(i * 2, n + 1, i):
        nums[j] = False
for i in range(m, n + 1):
    if nums[i] == True:
        print(i)