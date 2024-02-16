def rec(i, j):
    if i == j:
        return
    unit = (j - i + 1) // 3
    for k in range(i + unit, i + unit * 2):
        s[k] = " "
    rec(i, i + unit - 1)
    rec(i + unit * 2, j)


while True:
    try:
        N = int(input())
        s = ["-"] * (3**N)
        rec(0, 3**N - 1)
        print("".join(s))
    except:
        break