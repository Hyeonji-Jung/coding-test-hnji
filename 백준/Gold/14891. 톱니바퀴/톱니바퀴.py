import sys

input = sys.stdin.readline
gears = [list(map(int, input().strip())) for _ in range(4)]
n, dir = 0, 0
status = []


def check_left():
    global status
    for i in range(n - 1, -1, -1):
        if gears[i][2] != gears[i + 1][6]:
            status[i] = status[i + 1] * -1


def check_right():
    global status
    for i in range(n + 1, 4):
        if gears[i - 1][2] != gears[i][6]:
            status[i] = status[i - 1] * -1


def check_dirs():
    global status
    status = [0, 0, 0, 0]
    status[n] = dir
    if n == 0:
        check_right()
    elif n == 3:
        check_left()
    else:
        check_left()
        check_right()


def rotate():
    global gears
    for i in range(4):
        if status[i] == 1:
            gears[i] = [gears[i][-1]] + gears[i][:-1]
        elif status[i] == -1:
            gears[i] = gears[i][1:] + [gears[i][0]]


K = int(input())
for _ in range(K):
    n, dir = map(int, input().split())
    n -= 1
    check_dirs()
    rotate()
ans = 0
for i in range(4):
    if gears[i][0] == 1:
        ans += pow(2, i)
print(ans)