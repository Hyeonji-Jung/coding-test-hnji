from collections import defaultdict

def solution(tickets):
    answer = []
    path = ["ICN"]
    
    t_dict = defaultdict(list)
    for a, b in tickets:
        t_dict[a].append(b)
    
    # 공항별로 갈 수 있는 공항을 알파벳 역순으로 정렬
    # 스택을 사용해 알파벳 순서가 앞서는 공항을 먼저 방문하기 위함
    for key in t_dict.keys():
        t_dict[key].sort(reverse=True)
    
    while path:
        curr = path[-1]
        
        # 만약 현재 공항에서 갈 수 있는 공항이 없거나(항공권이 존재하지 않거나) 다 사용한 경우
        # 현재 공항이 마지막으로 방문해야 하는 공항이 되므로 answer에 추가
        if curr not in t_dict or len(t_dict[curr]) == 0:
            answer.append(path.pop())
        # 다른 공항으로 갈 수 있는 경우
        # 알파벳 순서가 앞서는 공항에 먼저 방문
        else:
            path.append(t_dict[curr].pop())

    # answer에는 경로가 역순으로 담겨 있음
    return answer[::-1]