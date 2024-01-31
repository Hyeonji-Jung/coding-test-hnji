from collections import defaultdict

T = int(input())

for t in range(1, T + 1):
    N = int(input())
    result = defaultdict(list)
    result[1] = [1]
    for i in range(2, N + 1):
        for j in range(i):
            if j == 0 or j == i - 1:
                result[i].append(1)
            else:
                result[i].append(result[i - 1][j - 1] + result[i - 1][j])
    print(f"#{t}")
    for i in range(1, N + 1):
        print(*result[i])
