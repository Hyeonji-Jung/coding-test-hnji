def solution(n, lost, reserve):
    answer = 0
    los = [x for x in lost if x not in reserve]
    rev = [x for x in reserve if x not in lost]
    for i in range(1, n + 1):
        pre, nex = i - 1, i + 1
        if i not in los:
            answer += 1
        elif pre in rev:
            rev.remove(pre)
            answer += 1
        elif nex in rev:
            rev.remove(nex)
            answer += 1
        else:
            pass
    return answer