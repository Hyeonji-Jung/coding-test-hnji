from collections import defaultdict, deque
import sys

input = sys.stdin.readline
n = int(input())
tree = defaultdict(list)


def bfs(node, visited):
    farthest, max_len = 0, 0
    q = deque([])
    q.append((node, 0))
    visited[node] = True
    while q:
        curr, curr_len = q.popleft()
        if curr_len > max_len:
            farthest = curr
            max_len = curr_len
        for next, next_len in tree[curr]:
            if not visited[next]:
                visited[next] = True
                q.append((next, curr_len + next_len))
    return farthest, max_len


for _ in range(n - 1):
    parent, child, weight = map(int, input().split())
    tree[parent].append((child, weight))
    tree[child].append((parent, weight))
farthest, max_len = bfs(1, [False for _ in range(n + 1)])
farthest, max_len = bfs(farthest, [False for _ in range(n + 1)])
print(max_len)