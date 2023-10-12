import sys

input = sys.stdin.readline

N, r, c = map(int, input().split())
res = 0


def recursion(start_r, start_c, curr, cnt):
    global res
    if curr == 1:
        res = cnt
        return
    if (
        start_r <= r < start_r + curr // 2 and start_c <= c < start_c + curr // 2
    ):  # 1번째 사각형
        recursion(start_r, start_c, curr // 2, cnt)
    elif (
        start_r <= r < start_r + curr // 2 and start_c + curr // 2 <= c < start_c + curr
    ):  # 2번째 사각형
        recursion(
            start_r,
            start_c + curr // 2,
            curr // 2,
            cnt + (curr // 2) ** 2 if curr > 1 else cnt + 1,
        )
    elif (
        start_r + curr // 2 <= r < start_r + curr and start_c <= c < start_c + curr // 2
    ):  # 3번째 사각형
        recursion(
            start_r + curr // 2,
            start_c,
            curr // 2,
            cnt + (curr // 2) ** 2 * 2 if curr > 1 else cnt + 2,
        )
    elif (
        start_r + curr // 2 <= r < start_r + curr
        and start_c + curr // 2 <= c < start_c + curr
    ):  # 4번째 사각형
        recursion(
            start_r + curr // 2,
            start_c + curr // 2,
            curr // 2,
            cnt + (curr // 2) ** 2 * 3 if curr > 1 else cnt + 3,
        )


recursion(0, 0, 2**N, 0)
print(res)
