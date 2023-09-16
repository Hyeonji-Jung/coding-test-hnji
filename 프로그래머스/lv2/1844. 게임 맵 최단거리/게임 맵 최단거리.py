from collections import deque

def solution(maps):
    deq = deque([[0, 0]])
    max_x = len(maps) - 1
    max_y = len(maps[0]) - 1
    
    def bfs():        
        dx = [0, 0, 1, -1]
        dy = [1, -1, 0, 0]
        while (deq):
            x, y = deq.popleft()
            for i in range(4):
                nx, ny = x + dx[i], y + dy[i]
                if nx < 0 or nx > max_x or ny < 0 or ny > max_y:
                    continue
                if maps[nx][ny] == 1:
                    maps[nx][ny] = maps[x][y] + 1
                    deq.append([nx, ny])

        if maps[max_x][max_y] != 1:
            return maps[max_x][max_y]
        return -1

    return bfs()