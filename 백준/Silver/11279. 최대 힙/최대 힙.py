import sys
import heapq

input = sys.stdin.readline

N = int(input())
maxheap = []

for _ in range(N):
    x = int(input())
    if x != 0:
        heapq.heappush(maxheap, -x)
    else:
        print(0 if len(maxheap) == 0 else -heapq.heappop(maxheap))