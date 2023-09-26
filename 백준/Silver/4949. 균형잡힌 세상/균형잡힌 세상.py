import re

def balance(brackets):
    stack = []
    for bracket in brackets:
        if len(stack) == 0 or re.match("[\[\(]", bracket):
            stack.append(bracket)
        else:
            top = stack.pop()
            if (bracket == ")" and top != "(") or (bracket == "]" and top != "["):
                stack.append(top)
                stack.append(bracket)
    return "yes" if len(stack) == 0 else "no"

while True:
    string = input()
    if string == ".":
        break
    brackets = re.findall("[\[\]\(\)]", string)
    print(balance(brackets))