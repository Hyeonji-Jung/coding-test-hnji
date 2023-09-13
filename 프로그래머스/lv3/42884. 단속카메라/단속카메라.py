def solution(routes):
    routes.sort(key=lambda x:x[0])
    answer = 1
    max_val = 30001
    for i, j in routes:
        if i > max_val:
            answer += 1
            max_val = j
        max_val = min(max_val, j)
    return answer