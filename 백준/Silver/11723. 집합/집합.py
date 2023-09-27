import sys
input = sys.stdin.readline

m = int(input())
s = set()

for _ in range(m):
    command = list(input().split())
    if len(command) == 2:
        cmd, x = command[0], int(command[1])
        if cmd == "add":
            s.add(x)
        if cmd == "remove":
            s.discard(x)
        if cmd == "check":
            print("1" if x in s else "0")
        if cmd == "toggle":
            if x in s:
                s.remove(x)
            else:
                s.add(x)
    else:
        if command[0] == "all":
            s = set([i for i in range(1, 21)])
        if command[0] == "empty":
            s = set()