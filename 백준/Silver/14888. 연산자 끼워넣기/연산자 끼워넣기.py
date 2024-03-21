import sys

input = sys.stdin.readline
N = int(input())
A = list(map(int, input().split()))
operator = list(map(int, input().split()))
max_val = -1_000_000_000
min_val = 1_000_000_000

def calculate(exp):
    tokens = exp.split()
    val = int(tokens[0])
    for i in range(1, len(tokens), 2):
        op = tokens[i]
        n = int(tokens[i + 1])
        if op == "+":
            val += n
        elif op == "-":
            val -= n
        elif op == "*":
            val *= n
        else:
            if val < 0:
                val = -(-val // n)
            else:
                val //= n
    return val

def dfs(depth, plus, minus, multi, divide, exp):
    global max_val, min_val
    exp += str(A[depth])
    if depth == N - 1:
        val = calculate(exp)
        max_val = max(max_val, val)
        min_val = min(min_val, val)
        return
    if plus > 0:
        dfs(depth + 1, plus - 1, minus, multi, divide, exp + " + ")
    if minus > 0:
        dfs(depth + 1, plus, minus - 1, multi, divide, exp + " - ")
    if multi > 0:
        dfs(depth + 1, plus, minus, multi - 1, divide, exp + " * ")
    if divide > 0:
        dfs(depth + 1, plus, minus, multi, divide - 1, exp + " // ")

dfs(0, operator[0], operator[1], operator[2], operator[3], "")
print(max_val)
print(min_val)