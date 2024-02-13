import sys

input = sys.stdin.readline
R, C = map(int, input().split())
board = [list(input().strip()) for _ in range(R)]
visited = [False for _ in range(ord("Z") - ord("A") + 1)]
max_cnt = 0


def dfs(x, y, cnt):
    global max_cnt
    if cnt > max_cnt:
        max_cnt = cnt
    for dx, dy in ((0, 1), (0, -1), (1, 0), (-1, 0)):
        nx = x + dx
        ny = y + dy
        if (
            0 <= nx < R
            and 0 <= ny < C
            and visited[ord(board[nx][ny]) - ord("A")] == False
        ):
            visited[ord(board[nx][ny]) - ord("A")] = True
            dfs(nx, ny, cnt + 1)
            visited[ord(board[nx][ny]) - ord("A")] = False


visited[ord(board[0][0]) - ord("A")] = True
dfs(0, 0, 1)
print(max_cnt)