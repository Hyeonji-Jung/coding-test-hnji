import sys
input = sys.stdin.readline

n, m = map(int, input().split())
unheard = [input().rstrip() for _ in range(n)]
unseen = [input().rstrip() for _ in range(m)]
answer = list(set(unheard) & set(unseen))
answer.sort()
print(len(answer))
for ans in answer:
    print(ans)