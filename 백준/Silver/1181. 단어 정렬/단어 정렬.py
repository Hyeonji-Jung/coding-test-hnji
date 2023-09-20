import sys
input = sys.stdin.readline

n = int(input())
words = list(set(input().strip() for _ in range(n)))

words.sort(key=lambda x: (len(x), x))
for word in words:
    print(word)