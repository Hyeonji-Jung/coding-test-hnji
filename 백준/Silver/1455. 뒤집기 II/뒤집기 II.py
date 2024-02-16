N, M = map(int, input().split())
coins = [list(map(int, input().strip())) for _ in range(N)]
cnt = 0


def reverse_coins(x, y):
    global cnt
    cnt += 1
    for i in range(x, -1, -1):
        for j in range(y, -1, -1):
            coins[i][j] = 1 if coins[i][j] == 0 else 0


for i in range(N - 1, -1, -1):
    for j in range(M - 1, -1, -1):
        if coins[i][j] == 1:
            reverse_coins(i, j)
print(cnt)