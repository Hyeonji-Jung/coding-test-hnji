import sys

input = sys.stdin.readline

N = int(input())
M = int(input())
broken = list(map(int, input().split()))

buttons = [i for i in range(10)]
for b in broken:
    buttons.remove(b)

ans = abs(N - 100)
for i in range(1000001):
    for j in range(len(str(i))):
        if int(str(i)[j]) not in buttons:
            break
        elif j == len(str(i)) - 1:
            ans = min(ans, abs(N - i) + len(str(i)))

print(ans)
