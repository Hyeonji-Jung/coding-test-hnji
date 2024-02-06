import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer tokens;

	private static int N, M;
	private static int[][] dist;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		dist = new int[N][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				dist[i][j] = i == j ? 0 : 10_000_000;
		for (int i = 0; i < M; i++) {
			tokens = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			int c = Integer.parseInt(tokens.nextToken());
			dist[a - 1][b - 1] = Math.min(dist[a - 1][b - 1], c);
		}
		for (int k = 0; k < N; k++)
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++)
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				sb.append(dist[i][j] == 10_000_000 ? 0 : dist[i][j]).append(" ");
			sb.append("\n");
		}
		System.out.println(sb);
	}
}