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