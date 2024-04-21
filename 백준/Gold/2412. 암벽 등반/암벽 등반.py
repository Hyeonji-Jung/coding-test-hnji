from collections import deque

n, T = map(int, input().split())
rock = set(tuple(map(int, input().split())) for _ in range(n))
start = 0


def bfs():
    q = deque([])
    q.append((0, 0, 0))

    while q:
        x, y, d = q.popleft()
        if y == T:
            return d

        for i in range(-2, 3):
            for j in range(-2, 3):
                nx = x + i
                ny = y + j
                if (nx, ny) in rock:
                    q.append((nx, ny, d + 1))
                    rock.remove((nx, ny))

    return -1


print(bfs())