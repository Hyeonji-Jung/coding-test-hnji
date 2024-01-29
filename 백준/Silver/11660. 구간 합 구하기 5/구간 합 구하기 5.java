import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer tokens;

	private static int[][] arr;
	private static int N, M;

	public static void main(String[] args) throws Exception {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		arr = new int[N + 1][N + 1];

		for (int i = 1; i < N + 1; i++) {
			tokens = new StringTokenizer(br.readLine());
			for (int j = 1; j < N + 1; j++) {
				int temp = Integer.parseInt(tokens.nextToken());
				arr[i][j] = arr[i][j - 1] + arr[i - 1][j] - arr[i - 1][j - 1] + temp;
			}
		}

		for (int t = 0; t < M; t++) {
			tokens = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(tokens.nextToken());
			int y1 = Integer.parseInt(tokens.nextToken());
			int x2 = Integer.parseInt(tokens.nextToken());
			int y2 = Integer.parseInt(tokens.nextToken());

			int ans = arr[x2][y2] - arr[x2][y1 - 1] - arr[x1 - 1][y2] + arr[x1 - 1][y1 - 1];
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
}