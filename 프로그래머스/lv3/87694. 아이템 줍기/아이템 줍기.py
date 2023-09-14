from collections import deque

def solution(rectangle, characterX, characterY, itemX, itemY):
    maps = [[0 for _ in range(102)] for _ in range(102)]
    min_x, max_x = 100, 0
    min_y, max_y = 100, 0
    
    for x, y, X, Y in rectangle:
        min_x = min(min_x, x * 2)
        max_x = max(max_x, X * 2)
        min_y = min(min_y, y * 2)
        max_y = max(max_y, Y * 2)
        for i in range(x * 2, X * 2 + 1):
            for j in range(y * 2, Y * 2 + 1):
                maps[i][j] = 1
    
    for i in range(min_x, max_x + 1):
        for j in range(min_y, max_y + 1):
            dx = [0, 0, 1, -1, 1, -1, -1, 1]
            dy = [1, -1, 0, 0, 1, -1, 1, -1]
            for k in range(8):
                nx = i + dx[k]
                ny = j + dy[k]
                if maps[nx][ny] == 0 and maps[i][j] == 1:
                    maps[i][j] = 2
                    break
    
    deq = deque([[characterX * 2, characterY * 2, 0]])
    itemX *= 2
    itemY *= 2
    answer = 0
    
    while (deq):
        x, y, cnt = deq.popleft()
        if x == itemX and y == itemY:
            answer = cnt // 2
            break

        maps[x][y] = 1
        dx = [0, 0, 1, -1]
        dy = [1, -1, 0, 0]
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if maps[nx][ny] == 2:
                deq.append([nx, ny, cnt + 1])
    
    return answer