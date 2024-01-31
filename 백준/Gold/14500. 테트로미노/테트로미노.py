import sys

input = sys.stdin.readline

N, M = map(int, input().split())
paper = [list(map(int, input().split())) for _ in range(N)]
answer = 0

tetrominoTypes = [
    [[0, 0], [0, 1], [0, 2], [0, 3]],
    [[0, 0], [1, 0], [2, 0], [3, 0]],
    [[0, 0], [1, 0], [0, 1], [1, 1]],
    [[0, 0], [0, 1], [0, 2], [1, 1]],
    [[0, 0], [0, 1], [0, 2], [-1, 1]],
    [[0, 0], [1, 0], [1, 1], [2, 0]],
    [[0, 0], [1, 0], [1, -1], [2, 0]],
    [[0, 0], [1, 0], [1, 1], [2, 1]],
    [[0, 0], [1, 0], [1, -1], [2, -1]],
    [[0, 0], [0, 1], [-1, 1], [-1, 2]],
    [[0, 0], [0, 1], [1, 1], [1, 2]],
    [[0, 0], [1, 0], [1, 1], [1, 2]],
    [[0, 0], [0, 1], [0, 2], [-1, 2]],
    [[0, 0], [1, 0], [0, 1], [0, 2]],
    [[0, 0], [0, 1], [0, 2], [1, 2]],
    [[0, 0], [1, 0], [2, 0], [2, 1]],
    [[0, 0], [1, 0], [2, 0], [2, -1]],
    [[0, 0], [1, 0], [2, 0], [0, 1]],
    [[0, 0], [1, 0], [2, 0], [0, -1]],
]


def tetromino(x, y):
    global answer
    for tetrominoType in tetrominoTypes:
        flag = True
        sum = 0
        for tetro in tetrominoType:
            tet_x = x + tetro[0]
            tet_y = y + tetro[1]
            if 0 <= tet_x < N and 0 <= tet_y < M:
                sum += paper[x + tetro[0]][y + tetro[1]]
            else:
                flag = False
                break
        if flag:
            answer = max(answer, sum)


for i in range(N):
    for j in range(M):
        tetromino(i, j)

print(answer)
