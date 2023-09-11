# kruskal 알고리즘을 이용한 풀이
def solution(n, costs):
    answer = 0
    costs.sort(key=lambda x : x[2])
    link = set([costs[0][0]])
    while len(link) != n:
        for cost in costs:
            if cost[0] in link and cost[1] in link:
                continue
            if cost[0] in link or cost[1] in link:
                answer += cost[2]
                link.update([cost[0], cost[1]])
                break
    return answer

# union-find를 이용한 풀이
def solution(n, costs):
    
    def find(n, parent):
        if parent[n] != n:
            parent[n] = find(parent[n], parent)
        return parent[n]
    
    def union(a, b, parent):
        a = find(a, parent)
        b = find(b, parent)
        if a > b:
            parent[a] = b
        else:
            parent[b] = a

    answer = 0
    costs.sort(key=lambda x : x[2])
    parent = [i for i in range(n)]
    for v1, v2, cost in costs:
        if find(v1, parent) != find(v2, parent):
            answer += cost
            union(v1, v2, parent)
    return answer
