import sys
from collections import Counter

input = sys.stdin.readline

n, m = map(int, input().split())
parents = [i for i in range(n + 1)]

def find(a):
    if parents[a] != a:
        return find(parents[a])
    return a

def union(a, b):
    a = find(a)
    b = find(b)
    if a < b:
        parents[b] = a
    else:
        parents[a] = b

for _ in range(m):
    u, v = map(int, input().split())
    union(u, v)
for i in range(1, n + 1):
    if parents[i] != i:
        parents[i] = find(i)
print(len(list(Counter(parents[1:]))))