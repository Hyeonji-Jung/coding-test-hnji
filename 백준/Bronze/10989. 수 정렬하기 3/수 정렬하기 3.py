import sys
input = sys.stdin.readline

n = int(input())
nums = [0 for _ in range(10001)]
for _ in range(n):
    nums[int(input())] += 1
for i, num in enumerate(nums):
    for _ in range(num):
        print(i)
