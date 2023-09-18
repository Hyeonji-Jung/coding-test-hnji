def solution(distance, rocks, n):
    answer = 0
    mini, maxi = 0, distance
    rocks.sort()
    rocks.append(distance)
    
    while mini <= maxi:
        mid = (mini + maxi) // 2
        removed = 0 # 제거한 바위 수
        prev = 0 # 기준이 되는 바위
        
        for rock in rocks:
            # 현재 거리가 기준값보다 작은 경우 바위를 제거
            if rock - prev < mid:
                removed += 1
            # 제거하지 않는 경우 기준점을 현재 바위로 변경
            else:
                prev = rock
            # 제거한 바위의 수가 문제 조건보다 크면 break
            if removed > n:
                break
        
        # 제거한 바위의 수가 너무 많은 경우 기준값이 큰 것이므로 왼쪽 탐색
        if removed > n:
            maxi = mid - 1
        # 제거한 바위의 수가 적은 경우 기준값이 작은 것이므로 오른쪽 탐색
        else:
            answer = mid
            mini = mid + 1
            
    return answer