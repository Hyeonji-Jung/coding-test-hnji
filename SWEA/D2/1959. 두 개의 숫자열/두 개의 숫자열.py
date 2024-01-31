T = int(input())
for t in range(1, T + 1):
    N, M = map(int, input().split())
    if N > M:
        long = N
        short = M
        a = list(map(int, input().split()))
        b = list(map(int, input().split()))
    else:
        long = M
        short = N
        b = list(map(int, input().split()))
        a = list(map(int, input().split()))
    res = -float("inf")
    for i in range(long - short + 1):
        maximum = 0
        for j in range(short):
            maximum += b[j] * a[j + i]
        res = max(res, maximum)
    print(f"#{t}", res)
