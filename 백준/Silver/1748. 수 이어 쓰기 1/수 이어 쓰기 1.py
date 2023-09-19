import sys
n = sys.stdin.readline().strip()
answer = 0
length = len(n)

for i in range(1, length):
    answer += i * 9 * 10 ** (i - 1)
answer += length * (int(n) - (10 ** (length - 1)) + 1)
print(answer)