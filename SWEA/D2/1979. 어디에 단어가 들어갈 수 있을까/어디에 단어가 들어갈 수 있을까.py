T = int(input())

for t in range(1, T + 1):
    N, K = map(int, input().split())
    puzzle = [list(map(int, input().split())) for _ in range(N)]
    cnt = 0

    for i in range(N):
        for j in range(N - K + 1):
            flag = True
            for k in range(j, j + K):
                if puzzle[i][k] == 0:
                    flag = False
            if (
                flag
                and (j == 0 or puzzle[i][j - 1] == 0)
                and (j + K == N or puzzle[i][j + K] == 0)
            ):
                cnt += 1

    for j in range(N):
        for i in range(N - K + 1):
            flag = True
            for k in range(i, i + K):
                if puzzle[k][j] == 0:
                    flag = False
            if (
                flag
                and (i == 0 or puzzle[i - 1][j] == 0)
                and (i + K == N or puzzle[i + K][j] == 0)
            ):
                cnt += 1

    print(f"#{t}", cnt)
