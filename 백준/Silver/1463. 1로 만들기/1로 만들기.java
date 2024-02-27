import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	private static int N;
	private static int[] dp;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		dp = new int[N + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[1] = 0;
		for (int i = 2; i <= N; i++) {
			if (i % 3 == 0)
				dp[i] = Math.min(dp[i], dp[i / 3] + 1);
			if (i % 2 == 0)
				dp[i] = Math.min(dp[i], dp[i / 2] + 1);
			dp[i] = Math.min(dp[i], dp[i - 1] + 1);
		}
		System.out.println(dp[N]);
	}
}