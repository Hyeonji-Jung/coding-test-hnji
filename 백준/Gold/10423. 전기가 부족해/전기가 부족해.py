import sys

input = sys.stdin.readline
N, M, K = map(int, input().split())
plants = list(map(int, input().split()))
cables = [tuple(map(int, input().split())) for _ in range(M)]
cables.sort(key=lambda x:x[2])
parent = [i if i not in plants else 0 for i in range(N + 1)]

def find(x):
    if (parent[x] == x):
        return x
    parent[x] = find(parent[x])
    return parent[x]

def union(x, y):
    x = find(x)
    y = find(y)
    if x < y:
        parent[y] = x
    else:
        parent[x] = y

result = 0
while N > 1 and cables:
    u, v, w = cables.pop(0)
    if find(u) != find(v):
        union(u, v)
        result += w
        N -= 1
print(result)
