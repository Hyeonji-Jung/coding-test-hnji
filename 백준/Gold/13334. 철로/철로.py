import heapq

n = int(input())
pairs = []
for _ in range(n):
    h, o = map(int, input().split())
    heapq.heappush(pairs, (max(h, o), min(h, o)))
d = int(input())

possible = []
cnt = 0
res = 0
while pairs:
    right, left = heapq.heappop(pairs)
    if right - left <= d:
        heapq.heappush(possible, (left, right))
        cnt += 1
    while possible:
        l, r = heapq.heappop(possible)
        if right - l <= d:
            heapq.heappush(possible, (l, r))
            break
        else:
            cnt -= 1
    res = max(res, cnt)
print(res)