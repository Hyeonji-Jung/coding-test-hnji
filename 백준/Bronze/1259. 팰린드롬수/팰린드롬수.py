import sys
input = sys.stdin.readline

def printPalindrome(string):
    for i in range(len(string) // 2):
        if string[i] != string[len(string) - i - 1]:
            print("no")
            return
    print("yes")

while True:
    string = input().rstrip()
    if string == "0":
        break
    printPalindrome(string)
