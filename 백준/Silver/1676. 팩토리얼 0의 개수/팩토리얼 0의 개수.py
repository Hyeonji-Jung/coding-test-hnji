import sys
import math

input = sys.stdin.readline

fac = str(math.factorial(int(input())))[::-1]
zeros = 0
for c in fac:
    if c == "0":
        zeros += 1
    else:
        break
print(zeros)
