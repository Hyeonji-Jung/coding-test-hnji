import sys
input = sys.stdin.readline

n = int(input())
n_nums = set(map(int, input().split()))
m = int(input())
m_nums = list(map(int, input().split()))

for num in m_nums:
    print(1 if num in n_nums else 0)
