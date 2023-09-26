import sys
input = sys.stdin.readline

n = int(input())
users = [list(input().split()) for _ in range(n)]
users.sort(key=lambda x: int(x[0]))
for age, user in users:
    print(age, user)
