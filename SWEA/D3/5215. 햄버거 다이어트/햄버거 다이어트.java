import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer tokens;

	private static int T, N, L;
	private static int[] tastes, weights, dp;

	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			tokens = new StringTokenizer(br.readLine());
			N = Integer.parseInt(tokens.nextToken());
			L = Integer.parseInt(tokens.nextToken());
			tastes = new int[N];
			weights = new int[N];
			dp = new int[L + 1];
			Arrays.fill(dp, 0);
			for (int i = 0; i < N; i++) {
				tokens = new StringTokenizer(br.readLine());
				tastes[i] = Integer.parseInt(tokens.nextToken());
				weights[i] = Integer.parseInt(tokens.nextToken());
			}
			for (int i = 0; i < N; i++)
				for (int j = L; j > weights[i] + 1; j--)
					dp[j] = Math.max(dp[j], dp[j - weights[i]] + tastes[i]);
			sb.append("#").append(t).append(" ").append(dp[L]).append("\n");
		}
		System.out.println(sb);
	}
}