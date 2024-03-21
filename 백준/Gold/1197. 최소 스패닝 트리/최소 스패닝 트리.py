import sys

input = sys.stdin.readline
V, E = map(int, input().split())
edges = [list(map(int, input().split())) for _ in range(E)]
parent = [i for i in range(V + 1)]

def find(a):
    global parent
    if parent[a] == a:
        return a
    parent[a] = find(parent[a])
    return parent[a]

def union(a, b):
    global parent
    a = find(a)
    b = find(b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

edges.sort(key=lambda x:x[2])
cnt = 0
weight = 0
for a, b, c in edges:
    if cnt == V - 1:
        break
    if find(a) != find(b):
        union(a, b)
        cnt += 1
        weight += c
print(weight)