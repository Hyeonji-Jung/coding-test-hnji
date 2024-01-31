money = [50000, 10000, 5000, 1000, 500, 100, 50, 10]

T = int(input())
for t in range(1, T + 1):
    N = int(input())
    res = []
    for m in money:
        cnt = 0
        while N >= m * cnt:
            cnt += 1
        res.append(cnt - 1)
        N -= m * (cnt - 1)
    print(f"#{t}")
    print(*res)
