import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer tokens;

	private static int N, K;
	private static int[][] items;
	private static int[][] dp;

	public static void main(String[] args) throws Exception {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		items = new int[N + 1][2];
		for (int i = 1; i <= N; i++) {
			tokens = new StringTokenizer(br.readLine());
			items[i][0] = Integer.parseInt(tokens.nextToken());
			items[i][1] = Integer.parseInt(tokens.nextToken());
		}
		dp = new int[N + 1][K + 1];
		for (int i = 1; i <= N; i++) {
			for (int w = 1; w <= K; w++) {
				dp[i][w] = dp[i - 1][w];
				if (items[i][0] <= w)
					dp[i][w] = Math.max(dp[i][w], items[i][1] + dp[i - 1][w - items[i][0]]);
			}
		}
		System.out.println(dp[N][K]);
	}
}