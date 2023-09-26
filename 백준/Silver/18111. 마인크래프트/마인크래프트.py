import sys

input = sys.stdin.readline
N, M, B = map(int, input().split())
world = []
max_height, min_height = 0, 256
for i in range(N):
    world.append(list(map(int, input().split())))
    max_height = max(max_height, max(world[i]))
    min_height = min(min_height, min(world[i]))

h, min_sec = max_height, sys.maxsize
for height in range(min_height, max_height + 1):
    remove_block, use_block = 0, 0
    for i in range(N):
        for j in range(M):
            if world[i][j] > height:
                remove_block += world[i][j] - height
            else:
                use_block += height - world[i][j]
    if use_block > remove_block + B:
        continue
    sec = remove_block * 2 + use_block
    if sec <= min_sec:
        min_sec = sec
        h = height
print(min_sec, h)