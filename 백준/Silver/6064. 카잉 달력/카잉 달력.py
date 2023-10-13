import sys
input = sys.stdin.readline

T = int(input())
for _ in range(T):
    M, N, x, y = map(int, input().split())
    k = x
    flag = False
    while k <= M * N:
        if (k - x) % M == 0 and (k - y) % N == 0:
            print(k)
            flag = True
            break
        k += M
    if not flag:
        print(-1)