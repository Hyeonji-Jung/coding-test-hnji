import sys

input = sys.stdin.readline

N, Q, k = map(int, input().split())
queries = [tuple(map(int, input().split())) for _ in range(Q)]

last_sort_idx = max(i if query[0] == 1 else 0 for i,
                    query in enumerate(queries))
is_reversed = sum(query[0] == 2 for query in queries[:last_sort_idx]) % 2 == 0

prev = [query[1] for query in queries[:last_sort_idx] if query[0] == 0]
prev = sorted(prev, reverse=is_reversed)
prev = [prev, prev[::-1]]

add = [[], []]
for query in queries[last_sort_idx:]:
    if query[0] == 0:
        add[is_reversed].append(query[1])
    elif query[0] == 2:
        is_reversed = not is_reversed

result = add[is_reversed][::-1] + prev[is_reversed] + add[not is_reversed]
print(result[k - 1])