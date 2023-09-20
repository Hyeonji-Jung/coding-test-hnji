import sys
from collections import defaultdict

input = sys.stdin.readline

n = int(input())
n_cards = defaultdict(int)
n_tmp = list(map(int, input().split()))
for tmp in n_tmp:
    n_cards[tmp] += 1

m = int(input())
m_cards = list(map(int, input().split()))

for card in m_cards:
    print(n_cards[card], end=" ")
