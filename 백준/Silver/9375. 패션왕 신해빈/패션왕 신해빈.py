import sys
from collections import defaultdict

input = sys.stdin.readline

t = int(input())
for _ in range(t):
    n = int(input())
    clothes = defaultdict(list)
    ans = 1
    for _ in range(n):
        name, kinds = input().split()
        clothes[kinds].append(name)
    for item in clothes:
        ans *= len(clothes[item]) + 1
    print(ans - 1)