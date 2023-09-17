def solution(n, times):
    minimum = 0 # 절대 심사를 완료할 수 없는 시간으로 초기화
    maximum = min(times) * n # 심사에 걸리는 최대 시간으로 초기화
    
    while minimum < maximum:
        mid = (minimum + maximum) // 2
        # mid 값으로 심사를 모두 완료할 수 있는 경우 앞부분 탐색, 심사를 완료하지 못하는 경우 뒷부분 탐색
        minimum, maximum = (minimum, mid) if n <= sum([mid // i for i in times]) else (mid + 1, maximum)
    return minimum