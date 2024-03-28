import sys
from collections import deque

input = sys.stdin.readline
T = int(input())


def get_dist(v1, v2):
    return abs(v1[0] - v2[0]) + abs(v1[1] - v2[1])


for _ in range(T):
    N = int(input())
    nodes = [list(map(int, input().split())) for _ in range(N + 2)]

    def bfs():
        q = deque([])
        visited = [False for _ in range(N + 2)]
        visited[0] = True
        q.append(0)
        while q:
            curr = q.popleft()
            if get_dist(nodes[curr], nodes[-1]) <= 1000:
                print("happy")
                return
            for i in range(N + 2):
                if not visited[i] and get_dist(nodes[curr], nodes[i]) <= 1000:
                    visited[i] = True
                    q.append(i)
        print("sad")

    bfs()