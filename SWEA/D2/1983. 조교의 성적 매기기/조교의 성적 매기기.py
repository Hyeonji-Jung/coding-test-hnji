T = int(input())

for t in range(1, T + 1):
    N, K = map(int, input().split())
    grades = ["A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"]
    students = []
    for i in range(N):
        mid, fin, assg = map(int, input().split())
        students.append((i + 1, mid * 0.35 + fin * 0.45 + assg * 0.2))
    students.sort(key=lambda x: x[1], reverse=True)
    grade_idx = 0
    for i in range(N):
        if students[i][0] == K:
            print(f"#{t}", grades[grade_idx])
            break
        if (i + 1) % (N // 10) == 0:
            grade_idx += 1
