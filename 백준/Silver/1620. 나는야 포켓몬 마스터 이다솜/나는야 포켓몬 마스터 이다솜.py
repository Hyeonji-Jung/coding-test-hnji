import sys
input = sys.stdin.readline

n, m = map(int, input().split())
pokemons = []
for i in range(n):
    pokemons.append(input().rstrip())
for _ in range(m):
    question = input().rstrip()
    if question.isdigit():
        print(pokemons[int(question) - 1])
    else:
        print(pokemons.index(question) + 1)
