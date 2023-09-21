import sys
from collections import deque

input = sys.stdin.readline
n = int(input())

def chkVPS(string):
    if string[0] == ")":
        print("NO")
        return

    q = deque([])
    for c in string:
        if c == ")" and len(q) > 0:
            top = q.pop()
            if top != "(":
                q.append(top)
                q.append(c)
        else:
            q.append(c)
    print("YES" if len(q) == 0 else "NO")


for _ in range(n):
    chkVPS(input().strip())
