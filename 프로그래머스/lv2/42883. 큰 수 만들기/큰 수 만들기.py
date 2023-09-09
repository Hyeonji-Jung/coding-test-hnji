def solution(number, k):
    answer = []
    for n in number:
        while k and answer and answer[-1] < n:
            answer.pop()
            k -= 1
        answer.append(n)
    return ''.join(answer[:len(answer) - k])