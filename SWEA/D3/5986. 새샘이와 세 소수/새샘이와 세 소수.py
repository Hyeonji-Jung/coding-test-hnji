import math

prime_num = [True] * 1000
prime_num[0] = prime_num[1] = False

for i in range(2, int(math.sqrt(999)) + 1):
    if prime_num[i] == True:
        for j in range(2, 1000):
            if i * j > 999:
                break
            prime_num[i * j] = False

T = int(input())

for t in range(1, T + 1):
    N = int(input())
    cnt = 0
    for i in range(2, N):
        if prime_num[i]:
            for j in range(i, N - i + 1):
                if prime_num[j]:
                    for k in range(j, N - i - j + 1):
                        if prime_num[k] and i + j + k == N:
                            cnt += 1
    print(f"#{t}", cnt)
