import sys
from collections import deque

input = sys.stdin.readline

n = int(input())
nums = [i for i in range(n, 0, -1)]
seq = deque([int(input()) for _ in range(n)])

stack = deque([])
result = []
flag = True

for s in seq:
    while len(nums) > 0 and s >= nums[-1]:
        stack.append(nums.pop())
        result.append("+")
    if s in stack:
        while s in stack:
            stack.pop()
            result.append("-")
    else:
        flag = False
        break

if flag:
    for res in result:
        print(res)
else:
    print("NO")
