T = int(input())

for t in range(1, T + 1):
    string = input()
    pattern = []
    next_pattern = []
    length = 0

    for i in range(1, 11):
        pattern = string[:i]
        next_pattern = string[i : i * 2]
        if pattern == next_pattern:
            length = i
            break
    print(f"#{t} {length}")