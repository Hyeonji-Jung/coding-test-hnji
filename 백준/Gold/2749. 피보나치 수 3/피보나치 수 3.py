N = int(input())
MOD = 1_000_000
P = 100_000 * 15
fibo = [0, 1]
for i in range(2, P):
    fibo.append((fibo[i-1] + fibo[i-2]) % MOD)
print(fibo[N % P])