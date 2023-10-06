import sys
from collections import deque

input = sys.stdin.readline

n = int(input())
meetings = [tuple(map(int, input().split())) for _ in range(n)]
meetings.sort(key=lambda x: (x[0], x[1]))
greedy = []

for start, end in meetings:
    if len(greedy) == 0:
        greedy.append((start, end))
    else:
        prev_start, prev_end = greedy.pop()
        if prev_end <= start:
            greedy.append((prev_start, prev_end))
            greedy.append((start, end))
        elif prev_end <= end:
            greedy.append((prev_start, prev_end))
        else:
            greedy.append((start, end))
print(len(greedy))