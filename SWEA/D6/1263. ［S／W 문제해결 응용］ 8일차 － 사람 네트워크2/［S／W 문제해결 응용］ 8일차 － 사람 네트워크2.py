T = int(input())
for t in range(1, T + 1):
    tmp = list(map(int, input().split()))
    N = tmp[0]
    net = [tmp[i:i+N] for i in range(1, N * N, N)]
    for i in range(N):
        for j in range(N):
            if i != j and net[i][j] == 0:
                net[i][j] = int(1e9)
    for k in range(N):
        for i in range(N):
            for j in range(N):
                net[i][j] = min(net[i][j], net[i][k] + net[k][j])
    ans = int(1e9)
    for i in range(N):
        curr = 0
        for j in range(N):
            curr += net[i][j]
        ans = min(ans, curr)
    print(f"#{t} {ans}")
