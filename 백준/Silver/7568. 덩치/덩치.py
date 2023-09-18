n = int(input())
people = []

for _ in range(n):
    people.append(list(map(int, input().split())))

for i in range(n):
    curr = 1
    for j in range(n):
        if i != j and people[i][0] < people[j][0] and people[i][1] < people[j][1]:
            curr += 1
    print(curr, end=" ")
