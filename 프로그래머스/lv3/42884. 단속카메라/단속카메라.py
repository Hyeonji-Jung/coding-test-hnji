# 진입점 기준으로 정렬한 풀이
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

# 진출점 기준으로 정렬한 풀이
def solution(routes):
    routes.sort(key=lambda x:x[1])
    answer = 0
    last_camera = -30000
    for route in routes:
        if last_camera < route[0]:
            answer += 1
            last_camera = route[1]
    return answer
