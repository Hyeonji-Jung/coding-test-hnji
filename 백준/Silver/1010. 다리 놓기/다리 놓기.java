import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer tokens;

	private static int T, N, M;
	private static int[][] dp = new int[30][30];

	private static int comb(int n, int k) {
		if (dp[n][k] > 0)
			return dp[n][k];
		if (k == 0 || n == k)
			return dp[n][k] = 1;
		return dp[n][k] = comb(n - 1, k - 1) + comb(n - 1, k);
	}

	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			tokens = new StringTokenizer(br.readLine());
			N = Integer.parseInt(tokens.nextToken());
			M = Integer.parseInt(tokens.nextToken());
			sb.append(comb(M, N)).append("\n");
		}
		System.out.println(sb);
	}
}