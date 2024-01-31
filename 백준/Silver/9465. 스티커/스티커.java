import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer tokens;

	private static int T, N;
	private static int[][] stickers, dp;

	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			stickers = new int[2][N];
			dp = new int[2][N];
			for (int i = 0; i < 2; i++) {
				tokens = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++)
					stickers[i][j] = Integer.parseInt(tokens.nextToken());
			}

			if (N == 1) {
				sb.append(Math.max(stickers[0][0], stickers[1][0])).append("\n");
				continue;
			}

			dp[0][0] = stickers[0][0];
			dp[1][0] = stickers[1][0];
			dp[0][1] = stickers[0][1] + dp[1][0];
			dp[1][1] = stickers[1][1] + dp[0][0];

			for (int i = 2; i < N; i++) {
				dp[0][i] = stickers[0][i] + Math.max(Math.max(dp[1][i - 1], dp[0][i - 2]), dp[1][i - 2]);
				dp[1][i] = stickers[1][i] + Math.max(Math.max(dp[0][i - 1], dp[1][i - 2]), dp[0][i - 2]);
			}
			sb.append(Math.max(dp[0][N - 1], dp[1][N - 1])).append("\n");
		}
		System.out.println(sb);
	}
}