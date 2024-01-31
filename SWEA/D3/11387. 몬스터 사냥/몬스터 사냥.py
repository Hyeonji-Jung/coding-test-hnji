T = int(input())

for t in range(1, T + 1):
    D, L, N = map(int, input().split())
    damages = 0
    for i in range(N):
        damages += D * (1 + i * (L / 100))
    print(f"#{t}", int(damages))