import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer tokens;

	private static int N;
	private static boolean[][] wall;
	private static int[][][] dp;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		wall = new boolean[N + 1][N + 1];
		dp = new int[N + 1][N + 1][3]; // 0: 가로, 1: 세로, 2: 대각선
		for (int i = 1; i <= N; i++) {
			tokens = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++)
				if (tokens.nextToken().charAt(0) == '1')
					wall[i][j] = true;
		}
		dp[1][2][0] = 1;
		for (int i = 1; i <= N; i++) {
			for (int j = 3; j <= N; j++) {
				if (!wall[i][j]) {
					dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2];
					dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2];
				}
				if (!wall[i][j] && !wall[i - 1][j] && !wall[i][j - 1])
					dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
			}
		}
		System.out.println(dp[N][N][0] + dp[N][N][1] + dp[N][N][2]);
	}
}