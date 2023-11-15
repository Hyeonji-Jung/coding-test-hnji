T = int(input())
for t in range(1, T + 1):
    N = int(input())
    matrix = [list(map(int, input().split())) for _ in range(N)]
    res = [[] for _ in range(N)]

    def rotation():
        new_matrix = [[0] * N for _ in range(N)]
        new_res = []
        for i in range(N):
            for j in range(N):
                new_matrix[j][N - 1 - i] = matrix[i][j]
        for i in range(N):
            res[i].append("".join(map(str, new_matrix[i])))
        return new_matrix

    matrix = rotation()
    matrix = rotation()
    matrix = rotation()

    print(f"#{t}")
    for i in range(N):
        print(*res[i])
