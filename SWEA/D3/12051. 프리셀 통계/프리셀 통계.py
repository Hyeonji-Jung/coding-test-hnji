T = int(input())

for t in range(1, T + 1):
    N, P_D, P_G = map(int, input().split())

    if (P_D != 0 and P_G == 0) or (P_D != 100 and P_G == 100):
        print(f"#{t}", "Broken")
    else:
        flag = False
        for i in range(1, N + 1):
            if (i * P_D) % 100 == 0:
                flag = True
                break
        print(f"#{t}", "Possible" if flag else "Broken")