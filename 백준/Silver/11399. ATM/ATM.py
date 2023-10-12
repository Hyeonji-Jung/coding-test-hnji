import sys
input = sys.stdin.readline

n = int(input())
times = list(map(int, input().split()))
times.sort()
cnt = 0
prev = 0
for time in times:
    cnt += prev + time
    prev += time
print(cnt)
