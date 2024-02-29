import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer tokens;

	private static int N, K;
	private static int[][] subjects;
	private static int[] dp;

	public static void main(String[] args) throws Exception {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		subjects = new int[K][2];
		for (int i = 0; i < K; i++) {
			tokens = new StringTokenizer(br.readLine());
			subjects[i][0] = Integer.parseInt(tokens.nextToken());
			subjects[i][1] = Integer.parseInt(tokens.nextToken());
		}
		dp = new int[N + 1];
		for (int i = 0; i < K; i++) {
			for (int j = N; j > 0; j--) {
				if (subjects[i][1] <= j)
					dp[j] = Math.max(dp[j], dp[j - subjects[i][1]] + subjects[i][0]);
			}
		}
		System.out.println(dp[N]);
	}
}