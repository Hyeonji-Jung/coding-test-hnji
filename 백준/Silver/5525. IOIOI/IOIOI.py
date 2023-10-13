import sys
input = sys.stdin.readline

Pn = "IO" * (int(input())) + "I"
M = int(input())
S = input().rstrip()
cnt = 0

def findSubstr(start):
    global cnt
    if Pn == S[start : start + len(Pn)]:
        cnt += 1

for i in range(len(S)):
    if S[i] == "I":
        findSubstr(i)
print(cnt)