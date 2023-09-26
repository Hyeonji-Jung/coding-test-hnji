import sys
from collections import deque

input = sys.stdin.readline

for _ in range(int(input())):
    n, m = map(int, input().split())
    priorities = list(map(int, input().split()))
    q = deque([(i, p) for i, p in enumerate(priorities)])
    priorities.sort(reverse=True)
    for i, priority in enumerate(priorities):
        x, x_priority = q.popleft()
        while x_priority != priority:
            q.append((x, x_priority))
            x, x_priority = q.popleft()
        if x == m:
            print(i + 1)