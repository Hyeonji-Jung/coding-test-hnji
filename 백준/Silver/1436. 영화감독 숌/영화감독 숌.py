import sys
input = sys.stdin.readline

n = int(input())
cnt = 0
for i in range(666, sys.maxsize):
    if "666" in str(i):
        cnt += 1
    if cnt == n:
        print(i)
        break
