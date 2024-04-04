import sys

input = sys.stdin.readline
N = int(input())
liq = list(map(int, input().split()))

if liq[0] >= 0:
    print(liq[0], liq[1])
elif liq[-1] <= 0:
    print(liq[-2], liq[-1])
else:
    left, right = 0, N - 1
    ans = abs(liq[left] + liq[right])
    ans_left, ans_right = left, right
    while left < right:
        temp = liq[left] + liq[right]
        if abs(temp) < ans:
            ans = abs(temp)
            ans_left = left
            ans_right = right
            if ans == 0:
                break
        if temp < 0:
            left += 1
        else:
            right -= 1
    print(liq[ans_left], liq[ans_right])