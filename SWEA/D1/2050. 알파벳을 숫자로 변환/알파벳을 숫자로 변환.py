alphabets = list(input().strip())
result = []
for alphabet in alphabets:
    alphabet = alphabet.upper()
    result.append(ord(alphabet) - ord("A") + 1)
print(*result)
