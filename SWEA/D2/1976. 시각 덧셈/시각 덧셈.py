T = int(input())

for t in range(1, T + 1):
    h1, m1, h2, m2 = map(int, input().split())
    hour = (h1 + h2 + ((m1 + m2) // 60)) % 12
    print(f"#{t}", hour if hour != 0 else 12, (m1 + m2) % 60)
