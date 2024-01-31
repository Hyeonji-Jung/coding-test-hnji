T = int(input())

for t in range(1, T + 1):
    n = int(input())
    week = list(map(int, input().split()))
    class_days = [i for i in range(7) if week[i] == 1]

    ans = float("inf")
    for day in class_days:
        day_cnt = 0
        class_cnt = 0
        while class_cnt < n:
            if week[day] == 1:
                class_cnt += 1
            day_cnt += 1
            day = (day + 1) % 7
        ans = min(ans, day_cnt)

    print(f"#{t}", ans)
