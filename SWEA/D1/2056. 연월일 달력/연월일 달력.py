T = int(input())

for t in range(1, T + 1):
    date = input()

    year = int(date[:4])
    month = int(date[4:6])
    day = int(date[6:])

    days = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

    if (
        year <= 0
        or month <= 0
        or month > 12
        or day <= 0
        or day > 31
        or day > days[month - 1]
    ):
        print(f"#{t}", "-1")
    else:
        print(f"#{t}", f"{year:04d}/{month:02d}/{day:02d}")
