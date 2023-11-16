T = int(input())

for t in range(1, T + 1):
    N = int(input())
    alphabets = []
    for _ in range(N):
        c, n = input().split()
        n = int(n)
        alphabets.append((c, n))

    print(f"#{t}")
    curr_line = 0
    for alphabet, repeats in alphabets:
        for i in range(repeats):
            if curr_line == 10:
                curr_line = 0
                print()
            print(alphabet, end="")
            curr_line += 1
    print()