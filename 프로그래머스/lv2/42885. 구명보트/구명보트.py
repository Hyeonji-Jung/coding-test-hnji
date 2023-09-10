from collections import deque

def solution(people, limit):
    answer = 0
    people.sort()
    dq = deque(people)
    
    while len(dq) > 1:
        if dq.pop() + dq[0] <= limit:
            dq.popleft()
        answer += 1
    return answer + 1 if dq else answer
