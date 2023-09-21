import sys
input = sys.stdin.readline

n = int(input())
coor = [tuple(map(int, input().split())) for _ in range(n)]
coor.sort(key=lambda x: (x[0], x[1]))
for x, y in coor:
    print(x, y)
