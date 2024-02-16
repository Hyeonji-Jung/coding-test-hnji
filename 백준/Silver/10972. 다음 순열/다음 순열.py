N = int(input())
seq = list(map(int, input().split()))
flag = True


def np():
    global seq, flag
    i = N - 1
    while i > 0 and seq[i - 1] > seq[i]:
        i -= 1
    if i == 0:
        flag = False
        return
    j = N - 1
    while seq[j] < seq[i - 1]:
        j -= 1
    tmp = seq[i - 1]
    seq[i - 1] = seq[j]
    seq[j] = tmp
    k = N - 1
    while i < k:
        tmp = seq[i]
        seq[i] = seq[k]
        seq[k] = tmp
        i += 1
        k -= 1


np()
if flag == False:
    print(-1)
else:
    print(*seq)