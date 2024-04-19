import sys

input = sys.stdin.readline

N = int(input())
players = []

for _ in range(N):
    b, p, q, r = map(int, input().split())
    players.append((p*q*r, p+q+r, b))
players.sort()

print(players[0][2], players[1][2], players[2][2])