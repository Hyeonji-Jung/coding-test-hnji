N = int(input())
x, y = [], []
for _ in range(N):
    xi, yi = map(int, input().split())
    x.append(xi)
    y.append(yi)
x.append(x[0])
y.append(y[0])

xr, yr = 0, 0
for i in range(N):
    xr += x[i] * y[i + 1]
    yr += y[i] * x[i + 1]
print(round(abs((xr - yr) / 2), 1))