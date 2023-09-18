n = int(input())
seq = list(map(int, input().split()))
dp = [1] * n

for i in range(1, n):
    for j in range(i):
        # 현재 값이 이전 값보다 큰 경우
        if seq[i] > seq[j]:
            # 이전 값을 마지막으로 하는 가장 긴 증가하는 부분 수열 뒤에 추가될 수 있으므로
            # 현재 dp 테이블 값과 이전 값의 dp 테이블 값 + 1 중 최댓값 선택
            dp[i] = max(dp[i], dp[j] + 1)
print(max(dp))
