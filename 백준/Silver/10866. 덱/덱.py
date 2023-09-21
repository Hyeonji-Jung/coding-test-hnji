import sys
from collections import deque

input = sys.stdin.readline

n = int(input())
q = deque([])
for _ in range(n):
    command = list(input().split())
    if len(command) == 2:
        cmd, x = command[0], int(command[1])
        if cmd == "push_front":
            q.appendleft(x)
        elif cmd == "push_back":
            q.append(x)
    if len(command) == 1:
        cmd = command[0]
        if cmd == "size":
            print(len(q))
        elif cmd == "empty":
            print("1" if len(q) == 0 else "0")
        elif cmd == "front":
            print("-1" if len(q) == 0 else q[0])
        elif cmd == "back":
            print("-1" if len(q) == 0 else q[-1])
        elif cmd == "pop_front":
            print("-1" if len(q) == 0 else q.popleft())
        elif cmd == "pop_back":
            print("-1" if len(q) == 0 else q.pop())