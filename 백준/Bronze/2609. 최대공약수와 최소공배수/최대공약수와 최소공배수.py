import sys
input = sys.stdin.readline

def GCD(n, m):
    a = max(n, m)
    b = min(n, m)
    while b != 0:
        temp = a
        a = b
        b = temp % b
    return a

def LCM(n, m):
    a = n
    b = m
    while a != b:
        while a < b:
            a += n
        while b < a:
            b += m
    return a

n, m = map(int, input().split())
print(GCD(n, m), LCM(n, m), sep="\n")