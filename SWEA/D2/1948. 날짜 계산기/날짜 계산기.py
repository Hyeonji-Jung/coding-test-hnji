end_days = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
T = int(input())

for t in range(1, T + 1):
    m1, d1, m2, d2 = map(int, input().split())
    res = 0
    if m1 == m2:
        res += (d2 - d1) + 1
    else:
        res += end_days[m1 - 1] - d1 + 1
        for month in range(m1 + 1, m2):
            res += end_days[month - 1]
        res += d2
    print(f"#{t}", res)