import sys

input = sys.stdin.readline
N = int(input())
A = list(map(int, input().split()))
A_rev = A[::-1]

inc = [1 for _ in range(N)]
dec = [1 for _ in range(N)]
for i in range(N):
    for j in range(i):
        if A[i] > A[j]:
            inc[i] = max(inc[i], inc[j] + 1)
        if A_rev[i] > A_rev[j]:
            dec[i] = max(dec[i], dec[j] + 1)

res = [inc[i] + dec[N - i - 1] - 1 for i in range(N)]
print(max(res))