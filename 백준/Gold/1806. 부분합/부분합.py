N, S = map(int, input().split())
seq = list(map(int, input().split()))

left, right = 0, 0
accum = 0
min_len = 1e9

while True:
    if accum >= S:
        min_len = min(min_len, right - left)
        accum -= seq[left]
        left += 1
    elif right == N:
        break
    else:
        accum += seq[right]
        right += 1

print(min_len if min_len != 1e9 else 0)