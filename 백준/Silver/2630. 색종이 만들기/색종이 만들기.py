import sys
input = sys.stdin.readline

n = int(input())
paper = [list(input().split()) for _ in range(n)]
white = 0
blue = 0

def chk(x, y, length):
    global paper
    prev = paper[x][y]
    for i in range(x, x + length):
        for j in range(y, y + length):
            if paper[i][j] != prev:
                return False
            prev = paper[i][j]
    return True

def cut(x, y, length):
    global paper, white, blue
    if length == 1 or chk(x, y, length):
        if paper[x][y] == "0":
            white += 1
        else:
            blue += 1
        return
    cut(x, y, length // 2)
    cut(x + length // 2, y, length // 2)
    cut(x, y + length // 2, length // 2)
    cut(x + length // 2, y + length // 2, length // 2)

cut(0, 0, n)
print(white)
print(blue)