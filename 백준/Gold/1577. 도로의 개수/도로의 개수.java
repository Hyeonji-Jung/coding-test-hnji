import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer tokens;

	private static int N, M, K;
	private static long[][] city;
	private static boolean[][] cantVisitHor, cantVisitVer;

	public static void main(String[] args) throws Exception {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(br.readLine());
		cantVisitHor = new boolean[N + 1][M + 1];
		cantVisitVer = new boolean[N + 1][M + 1];
		for (int k = 0; k < K; k++) {
			tokens = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(tokens.nextToken());
			int y1 = Integer.parseInt(tokens.nextToken());
			int x2 = Integer.parseInt(tokens.nextToken());
			int y2 = Integer.parseInt(tokens.nextToken());
			if (x1 == x2)
				cantVisitHor[x1][Math.max(y1, y2)] = true;
			else
				cantVisitVer[Math.max(x1, x2)][y1] = true;
		}
		city = new long[N + 1][M + 1];
		city[0][0] = 1;
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= M; j++) {
				if (i == 0 && j == 0)
					continue;
				if (j > 0 && !cantVisitHor[i][j])
					city[i][j] += city[i][j - 1];
				if (i > 0 && !cantVisitVer[i][j])
					city[i][j] += city[i - 1][j];
			}
		}
		System.out.println(city[N][M]);
	}
}