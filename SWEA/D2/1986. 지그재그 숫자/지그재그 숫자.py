T = int(input())

for t in range(1, T + 1):
    N = int(input())
    res = 0
    for n in range(1, N + 1):
        res += n if n % 2 == 1 else -n
    print(f"#{t}", res)
