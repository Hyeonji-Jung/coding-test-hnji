import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer tokens;

	private static int N;
	private static int[][] rgbs;
	private static int[][] dp;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		rgbs = new int[N][3];
		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++)
				rgbs[i][j] = Integer.parseInt(tokens.nextToken());
		}
		dp = new int[N][3];
		for (int i = 0; i < 3; i++)
			dp[0][i] = rgbs[0][i];
		for (int i = 1; i < N; i++)
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		for (int i = 1; i < N; i++)
			for (int j = 0; j < 3; j++)
				for (int k = 0; k < 3; k++)
					if (j != k)
						dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + rgbs[i][j]);
		System.out.println(Math.min(dp[N - 1][0], Math.min(dp[N - 1][1], dp[N - 1][2])));
	}
}