import sys
input = sys.stdin.readline

l = int(input())
s = input().strip()
hash = 0

for i, c in enumerate(s):
    hash += (ord(c) - ord("a") + 1) * (31**i) % 1234567891
print(hash)
