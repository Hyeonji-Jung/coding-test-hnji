import sys
input = sys.stdin.readline

n, m = map(int, input().split())
board = [list(input().strip()) for _ in range(n)]
minimum = 400

def draw(x, y):
    a = board[x][y]
    b = "W" if a == "B" else "B"
    cnt_1 = 0
    cnt_2 = 0
    for i in range(x, x + 8):
        for j in range(y, y + 8):
            x_pos = i - x
            y_pos = j - y
            if x_pos % 2 == 0:
                if y_pos % 2 == 0 and board[i][j] != a:
                    cnt_1 += 1
                if y_pos % 2 == 1 and board[i][j] != b:
                    cnt_1 += 1
            if x_pos % 2 == 1:
                if y_pos % 2 == 0 and board[i][j] != b:
                    cnt_1 += 1
                if y_pos % 2 == 1 and board[i][j] != a:
                    cnt_1 += 1
            if x_pos % 2 == 0:
                if y_pos % 2 == 0 and board[i][j] != b:
                    cnt_2 += 1
                if y_pos % 2 == 1 and board[i][j] != a:
                    cnt_2 += 1
            if x_pos % 2 == 1:
                if y_pos % 2 == 0 and board[i][j] != a:
                    cnt_2 += 1
                if y_pos % 2 == 1 and board[i][j] != b:
                    cnt_2 += 1
    return min(cnt_1, cnt_2)

for i in range(n - 8 + 1):
    for j in range(m - 8 + 1):
        minimum = min(minimum, draw(i, j))
print(minimum)
