string = input()
sep = input()

stack = []
sep_len = len(sep)

for c in string:
    stack.append(c)
    if c == sep[-1] and "".join(stack[-sep_len:]) == sep:
        for _ in range(sep_len):
            stack.pop()

ans = "".join(stack)
print("FRULA" if len(ans) == 0 else ans)