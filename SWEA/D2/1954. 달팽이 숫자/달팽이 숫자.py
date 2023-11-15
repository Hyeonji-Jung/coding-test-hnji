dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

T = int(input())
for t in range(1, T + 1):
    N = int(input())
    snail = [[0] * N for _ in range(N)]
    x, y = 0, 0
    dist = 0

    for num in range(1, N * N + 1):
        snail[x][y] = num
        if (
            x + dx[dist] < 0
            or x + dx[dist] >= N
            or y + dy[dist] < 0
            or y + dy[dist] >= N
            or snail[x + dx[dist]][y + dy[dist]] != 0
        ):
            dist = (dist + 1) % 4
        x += dx[dist]
        y += dy[dist]

    print(f"#{t}")
    for sn in snail:
        print(*sn)