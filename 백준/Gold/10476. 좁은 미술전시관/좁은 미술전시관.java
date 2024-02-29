import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer tokens;

	private static int N, K;
	private static int[][] rooms;
	private static int[][][] dp;

	public static void main(String[] args) throws Exception {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		rooms = new int[N + 1][2];
		for (int i = 1; i <= N; i++) {
			tokens = new StringTokenizer(br.readLine());
			rooms[i][0] = Integer.parseInt(tokens.nextToken());
			rooms[i][1] = Integer.parseInt(tokens.nextToken());
		}
		br.readLine();
		dp = new int[N + 2][K + 2][3]; // 0: 둘 다 닫지 않음, 1: 왼쪽 닫음, 2: 오른쪽 닫음
		dp[1][0][0] = rooms[1][0] + rooms[1][1];
		dp[1][1][1] = rooms[1][1];
		dp[1][1][2] = rooms[1][0];
		for (int n = 2; n <= N; n++)
			for (int k = 0; k <= K; k++) {
				if (n != k)
					dp[n][k][0] = Math.max(Math.max(dp[n - 1][k][0], dp[n - 1][k][1]), dp[n - 1][k][2]) + rooms[n][0]
							+ rooms[n][1];
				if (k > 0) {
					dp[n][k][1] = Math.max(dp[n - 1][k - 1][0], dp[n - 1][k - 1][1]) + rooms[n][1];
					dp[n][k][2] = Math.max(dp[n - 1][k - 1][0], dp[n - 1][k - 1][2]) + rooms[n][0];
				}
			}
		System.out.println(Math.max(Math.max(dp[N][K][0], dp[N][K][1]), dp[N][K][2]));
	}
}