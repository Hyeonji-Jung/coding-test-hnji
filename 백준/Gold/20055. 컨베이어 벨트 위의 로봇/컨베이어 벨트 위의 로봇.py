from collections import deque

N, K = map(int, input().split())
belt = deque(list(map(int, input().split())))
robot = deque([False] * N)
step = 0

while True:
    step += 1

    belt.rotate(1)
    robot.rotate(1)

    robot[N - 1] = False

    for i in range(N - 2, -1, -1):
        if robot[i] and not robot[i + 1] and belt[i + 1] > 0:
            robot[i], robot[i + 1] = False, True
            belt[i + 1] -= 1

    robot[N - 1] = False

    if belt[0] > 0:
        robot[0] = True
        belt[0] -= 1

    if belt.count(0) >= K:
        break

print(step)