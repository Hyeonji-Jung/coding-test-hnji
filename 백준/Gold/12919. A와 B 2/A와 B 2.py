S = list(input().strip())
T = list(input().strip())

res = 0


def dfs(s):
    global res
    if len(s) == len(S):
        if s == S:
            res = 1
        return

    if s[-1] == "A":
        s.pop()
        dfs(s)
        s.append("A")
    if s[0] == "B":
        s.reverse()
        s.pop()
        dfs(s)
        s.append("B")
        s.reverse()


dfs(T)
print(res)