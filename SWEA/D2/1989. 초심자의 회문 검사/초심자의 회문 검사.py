T = int(input())

for t in range(1, T + 1):
    palindrome = input().strip()
    rev_palindrome = palindrome[::-1]
    print(f"#{t}", 1 if palindrome == rev_palindrome else 0)