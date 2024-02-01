import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer tokens;

	private static int T, N, M, maxFlies;
	private static int[][] arr;

	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			tokens = new StringTokenizer(br.readLine());
			N = Integer.parseInt(tokens.nextToken());
			M = Integer.parseInt(tokens.nextToken());
			maxFlies = 0;
			arr = new int[N + 1][N + 1];
			for (int i = 1; i <= N; i++) {
				tokens = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++)
					arr[i][j] = Integer.parseInt(tokens.nextToken()) + arr[i - 1][j] + arr[i][j - 1]
							- arr[i - 1][j - 1];
			}
			for (int i = M; i <= N; i++)
				for (int j = M; j <= N; j++)
					maxFlies = Math.max(maxFlies, arr[i][j] - arr[i - M][j] - arr[i][j - M] + arr[i - M][j - M]);
			sb.append("#").append(t).append(" ").append(maxFlies).append("\n");
		}
		System.out.println(sb);
	}
}