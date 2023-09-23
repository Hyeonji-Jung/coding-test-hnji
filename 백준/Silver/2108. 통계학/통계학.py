import sys
from collections import Counter

input = sys.stdin.readline

n = int(input())
arr = []
sum = 0
for i in range(n):
    arr.append(int(input()))
    sum += arr[i]
arr.sort()

def mode():
    global n, arr
    modes = []
    counter = Counter(arr).most_common()
    max_cnt = counter[0][1]
    for count in counter:
        if count[1] == max_cnt:
            modes.append(count[0])
        else:
            break
    return modes[0] if len(modes) == 1 else modes[1]

print(round(sum / n))
print(arr[n // 2])
print(mode())
print(abs(arr[-1] - arr[0]))
