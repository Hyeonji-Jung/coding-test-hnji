from collections import deque

def solution(begin, target, words):
    if target not in words:
        return 0

    deq = deque([[begin, 0]])
    
    while (deq):
        x, cnt = deq.popleft()
        if x == target:
            return cnt
        
        for word in words:
            diff = 0
            for i in range(len(word)):
                if x[i] != word[i]:
                    diff += 1
            if diff == 1:
                deq.append([word, cnt + 1])
    
    return 0