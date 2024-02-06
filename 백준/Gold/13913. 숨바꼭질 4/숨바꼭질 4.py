import sys
from collections import deque

input = sys.stdin.readline
min_sec = [-1 for _ in range(100001)]
prev = [-1 for _ in range(100001)]


def print_path():
    path = []
    curr = K
    while curr != N:
        path.append(curr)
        curr = prev[curr]
    path.append(N)
    path.reverse()
    print(*path)


def bfs(N, K):
    q = deque([])
    min_sec[N] = 0
    q.append(N)

    if N <= K:
        while q:
            node = q.popleft()
            if node == K:
                print(min_sec[K])
                print_path()
                break
            for i in node - 1, node + 1, node * 2:
                if 0 <= i <= 100000 and min_sec[i] == -1:
                    min_sec[i] = min_sec[node] + 1
                    prev[i] = node
                    q.append(i)
    else:
        print(N - K)
        print(*[i for i in range(N, K - 1, -1)])


N, K = map(int, input().split())
bfs(N, K)