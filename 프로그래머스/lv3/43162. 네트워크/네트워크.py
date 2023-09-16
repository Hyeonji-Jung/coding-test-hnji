from collections import Counter

def solution(n, computers):
    
    def find(parent, x):
        if parent[x] != x:
            return find(parent, parent[x])
        return x
    
    def union(parent, a, b):
        a = find(parent, a)
        b = find(parent, b)
        if a < b:
            parent[b] = a
        else:
            parent[a] = b
    
    parent = [i for i in range(n)]
    for i in range(n):
        for j in range(i + 1, n):
            if computers[i][j] == 1 and i != j:
                union(parent, i, j)

    answer = set()
    for i in range(n):
        answer.add(find(parent, parent[i]))
    return len(answer)