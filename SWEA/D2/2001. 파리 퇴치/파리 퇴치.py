T = int(input())

for t in range(1, T + 1):
    N, M = map(int, input().split())
    area = [list(map(int, input().split())) for _ in range(N)]
    flies = 0

    def catch_flies(i, j):
        res = 0
        for x in range(i, i + M):
            for y in range(j, j + M):
                res += area[x][y]
        return res

    for i in range(N - M + 1):
        for j in range(N - M + 1):
            flies = max(flies, catch_flies(i, j))
    print(f"#{t}", flies)
