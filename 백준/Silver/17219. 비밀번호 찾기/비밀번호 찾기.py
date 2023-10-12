import sys
from collections import defaultdict

input = sys.stdin.readline

n, m = map(int, input().split())
sites = defaultdict()
for _ in range(n):
    site, pw = input().split()
    sites[site] = pw
for _ in range(m):
    print(sites[input().rstrip()])