T = int(input())

for t in range(1, T + 1):
    puzzle = [list(map(int, input().split())) for _ in range(9)]

    def chk_horizontal(x):
        nums = set()
        for i in range(9):
            nums.add(puzzle[x][i])
        return len(nums) == 9

    def chk_vertical(y):
        nums = set()
        for i in range(9):
            nums.add(puzzle[i][y])
        return len(nums) == 9

    def chk_grid(x, y):
        nums = set()
        grid = [(0, 0), (0, 1), (0, 2), (1, 0), (1, 1), (1, 2), (2, 0), (2, 1), (2, 2)]
        flag = True
        for dx, dy in grid:
            nums.add(puzzle[x + dx][y + dy])
        return len(nums) == 9

    for i in range(9):
        flag = True
        if not chk_horizontal(i) or not chk_vertical(i):
            flag = False
            break

    if flag:
        for i in range(0, 9, 3):
            flag = True
            for j in range(0, 9, 3):
                if not chk_grid(i, j):
                    flag = False
                    break
            if not flag:
                break

    print(f"#{t}", 1 if flag else 0)
