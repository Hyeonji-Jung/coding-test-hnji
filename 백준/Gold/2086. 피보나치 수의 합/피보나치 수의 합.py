a, b = map(int, input().split())
MOD = 1_000_000_000


def matrix_mul(A, B):
    temp = [[0] * 2 for _ in range(2)]
    for i in range(2):
        for j in range(2):
            for k in range(2):
                temp[i][j] += A[i][k] * B[k][j] % MOD
    return temp


def matrix_pow(M, n):
    if n == 1:
        return M
    if n % 2 == 0:
        temp = matrix_pow(M, n // 2)
        return matrix_mul(temp, temp)
    else:
        temp = matrix_pow(M, n - 1)
        return matrix_mul(temp, M)

# S(n) = F(n + 2) - 1
# S(b) - S(a - 1) = F(b + 2) - F(a + 1)


print((matrix_pow([[1, 1], [1, 0]], b + 1)[0][0] -
      matrix_pow([[1, 1], [1, 0]], a)[0][0]) % MOD)