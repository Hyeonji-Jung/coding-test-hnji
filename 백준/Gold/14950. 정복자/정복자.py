import heapq

N, M, t = map(int, input().split())
roads = []
for _ in range(M):
    a, b, c = map(int, input().split())
    heapq.heappush(roads, (c, a, b))

parents = [i for i in range(N + 1)]

connected = 0
total = 0


def find(a):
    if parents[a] == a:
        return a
    parents[a] = find(parents[a])
    return parents[a]


def union(a, b):
    a = find(a)
    b = find(b)
    if a < b:
        parents[b] = a
    else:
        parents[a] = b


while roads:
    c, a, b = heapq.heappop(roads)
    if find(a) != find(b):
        union(a, b)
        total += c + connected * t
        connected += 1

print(total)