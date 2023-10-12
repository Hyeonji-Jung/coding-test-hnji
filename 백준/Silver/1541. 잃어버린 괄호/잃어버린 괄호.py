import sys
input = sys.stdin.readline

expression = list(input().rstrip().split("-"))
res = 0
for i, exp in enumerate(expression):
    num = sum(map(int, exp.split("+")))
    res = res - num if i != 0 else res + num
print(res)