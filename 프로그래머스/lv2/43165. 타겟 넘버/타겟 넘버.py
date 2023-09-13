def solution(numbers, target):
    
    def dfs(idx, num):
        nonlocal answer
        idx += 1
        if idx == len(numbers) - 1:
            if abs(target - num) == numbers[idx]:
                answer += 1
            return
        dfs(idx, num + numbers[idx])
        dfs(idx, num - numbers[idx])
    
    answer = 0
    dfs(-1, 0)
    
    return answer