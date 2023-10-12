import sys
import heapq

input = sys.stdin.readline
heap = []
n = int(input())

for _ in range(n):
    x = int(input())
    if x == 0:
        print("0" if len(heap) == 0 else heapq.heappop(heap))
    else:
        heapq.heappush(heap, x)