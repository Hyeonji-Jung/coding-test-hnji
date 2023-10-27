import sys
from itertools import combinations

input = sys.stdin.readline


def cal(a, b, c):
    res = 0
    for x, y, z in zip(a, b, c):
        if x != y:
            res += 1
        if x != z:
            res += 1
        if y != z:
            res += 1
    return res


T = int(input())
for _ in range(T):
    N = int(input())
    mbti = list(input().split())
    if len(mbti) > 32:
        print(0)
    else:
        coms = combinations(mbti, 3)
        res = sys.maxsize
        for a, b, c in coms:
            res = min(res, cal(a, b, c))
        print(res)
