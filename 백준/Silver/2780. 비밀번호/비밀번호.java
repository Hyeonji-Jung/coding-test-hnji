import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();

	private static int T, N;
	private static int[][] dp = new int[1001][10];

	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 10; i++)
			dp[1][i] = 1;
		for (int i = 2; i <= 1000; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == 0)
					dp[i][j] = dp[i - 1][7];
				else if (j == 1)
					dp[i][j] = dp[i - 1][2] + dp[i - 1][4];
				else if (j == 2)
					dp[i][j] = dp[i - 1][1] + dp[i - 1][3] + dp[i - 1][5];
				else if (j == 3)
					dp[i][j] = dp[i - 1][2] + dp[i - 1][6];
				else if (j == 4)
					dp[i][j] = dp[i - 1][1] + dp[i - 1][5] + dp[i - 1][7];
				else if (j == 5)
					dp[i][j] = dp[i - 1][2] + dp[i - 1][4] + dp[i - 1][6] + dp[i - 1][8];
				else if (j == 6)
					dp[i][j] = dp[i - 1][3] + dp[i - 1][5] + dp[i - 1][9];
				else if (j == 7)
					dp[i][j] = dp[i - 1][0] + dp[i - 1][4] + dp[i - 1][8];
				else if (j == 8)
					dp[i][j] = dp[i - 1][5] + dp[i - 1][7] + dp[i - 1][9];
				else if (j == 9)
					dp[i][j] = dp[i - 1][6] + dp[i - 1][8];
				dp[i][j] %= 1_234_567;
			}
		}
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			int sum = 0;
			for (int i = 0; i < 10; i++)
				sum += dp[N][i];
			sb.append((sum % 1_234_567) + "\n");
		}
		System.out.println(sb);
	}
}