import sys
input = sys.stdin.readline

def disassemble(num):
    string = str(num)
    sum = num
    for c in string:
        sum += int(c)
    return sum

def print_disassem(n):
    start = n - 60 if n > 60 else 0
    for i in range(start, n):
        disassem = disassemble(i)
        if disassem == n:
            return i
    return 0

print(print_disassem(int(input())))