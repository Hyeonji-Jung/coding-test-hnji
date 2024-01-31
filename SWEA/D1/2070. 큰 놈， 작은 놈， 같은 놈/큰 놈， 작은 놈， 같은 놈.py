T = int(input())

for t in range(1, T + 1):
    x, y = map(int, input().split())
    if x > y:
        print(f"#{t}", ">")
    elif x < y:
        print(f"#{t}", "<")
    else:
        print(f"#{t}", "=")
