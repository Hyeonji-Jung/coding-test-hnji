n = int(input())
arr = list(map(int, input().split()))
v = int(input())
cnt = 0
for a in arr:
    if a == v:
        cnt += 1
print(cnt)