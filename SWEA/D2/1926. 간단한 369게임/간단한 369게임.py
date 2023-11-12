N = int(input())
threeSixNine = ["3", "6", "9"]
nums = [str(i) for i in range(1, N + 1)]

for num in nums:
    res = ""
    flag = False
    for n in num:
        if n in threeSixNine:
            res += "-"
            flag = True
    if flag:
        print(res, end=" ")
    else:
        print(num, end=" ")
