import sys
from collections import deque

input = sys.stdin.readline

T = int(input())
for _ in range(T):
    p = list(input().strip())
    n = int(input())
    arr = deque(input().rstrip()[1:-1].split(","))
    if n == 0:
        arr = deque([])

    flag = False
    rev = 0

    for comm in p:
        if comm == "R":
            rev += 1
        if comm == "D":
            if len(arr) == 0:
                print("error")
                flag = True
                break
            else:
                if rev % 2 == 1:
                    arr.pop()
                else:
                    arr.popleft()
    if not flag:
        if rev % 2 == 1:
            arr.reverse()
        print("[" + ",".join(arr) + "]")
