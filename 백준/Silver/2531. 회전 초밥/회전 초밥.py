N, d, k, c = map(int, input().split())
sushi = [int(input()) for _ in range(N)]

max_k = 0;
for i in range(N):
    curr_k = 0
    curr_sushi = set()
    for j in range(k):
        if sushi[(i + j) % N] not in curr_sushi and sushi[(i + j) % N] != c:
            curr_sushi.add(sushi[(i + j) % N])
            curr_k += 1
    max_k = curr_k if curr_k > max_k else max_k
print(max_k + 1)