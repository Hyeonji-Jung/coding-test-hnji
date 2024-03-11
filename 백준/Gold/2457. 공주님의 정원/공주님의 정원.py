import sys

input = sys.stdin.readline
N = int(input())
arr = []
for _ in range(N):
    m1, d1, m2, d2 = map(int, input().split())
    arr.append((m1 * 100 + d1, m2 * 100 + d2))
arr.sort()
end = 301
flowers = 0
idx = 0

while idx < N:
    if end >= 1201 or arr[idx][0] > end:
        break
    tmp_end = -1
    for i in range(idx, N):
        if arr[i][0] > end:
            break
        if arr[i][1] > tmp_end:
            tmp_end = arr[i][1]
            idx = i + 1
    end = tmp_end
    flowers += 1

if end < 1201:
    print(0)
else:
    print(flowers)