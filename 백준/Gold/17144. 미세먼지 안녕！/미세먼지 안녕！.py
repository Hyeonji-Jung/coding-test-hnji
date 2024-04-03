import sys

input = sys.stdin.readline
R, C, T = map(int, input().split())
room = [list(map(int, input().split())) for _ in range(R)]
airc = []
for i in range(R):
    if room[i][0] == -1:
        airc = [i, i + 1]
        break


def spread():
    global room
    newroom = [[0] * C for _ in range(R)]
    newroom[airc[0]][0] = newroom[airc[1]][0] = -1
    for i in range(R):
        for j in range(C):
            if room[i][j] > 0:
                dirCnt = 0
                spr = room[i][j] // 5
                for dx, dy in ((1, 0), (-1, 0), (0, 1), (0, -1)):
                    nx = i + dx
                    ny = j + dy
                    if 0 <= nx < R and 0 <= ny < C and room[nx][ny] >= 0:
                        newroom[nx][ny] += spr
                        dirCnt += 1
                newroom[i][j] += room[i][j] - dirCnt * spr
    room = newroom


def oper():
    global room
    r, c = airc[0] - 1, 0
    while r > 0:
        room[r][c] = room[r - 1][c]
        r -= 1
    while c + 1 < C:
        room[r][c] = room[r][c + 1]
        c += 1
    while r < airc[0]:
        room[r][c] = room[r + 1][c]
        r += 1
    while c > 1:
        room[r][c] = room[r][c - 1]
        c -= 1
    room[r][c] = 0

    r, c = airc[1] + 1, 0
    while r + 1 < R:
        room[r][c] = room[r + 1][c]
        r += 1
    while c + 1 < C:
        room[r][c] = room[r][c + 1]
        c += 1
    while r > airc[1]:
        room[r][c] = room[r - 1][c]
        r -= 1
    while c > 1:
        room[r][c] = room[r][c - 1]
        c -= 1
    room[r][c] = 0


for _ in range(T):
    spread()
    oper()

ans = 0
for i in range(R):
    for j in range(C):
        if room[i][j] > 0:
            ans += room[i][j]
print(ans)