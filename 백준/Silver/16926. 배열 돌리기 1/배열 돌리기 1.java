import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer tokens;

	private static int N, M, R, depth;
	private static int[][] matrix;

	private static void rotate() {
		int[][] temp = new int[N][M];
		for (int d = 0; d < depth; d++) {
			for (int c = M - d - 1; c > d; c--)
				temp[d][c - 1] = matrix[d][c];
			for (int c = d; c < M - d - 1; c++)
				temp[N - d - 1][c + 1] = matrix[N - d - 1][c];
			for (int r = d; r < N - d - 1; r++)
				temp[r + 1][d] = matrix[r][d];
			for (int r = N - d - 1; r > d; r--)
				temp[r - 1][M - d - 1] = matrix[r][M - d - 1];
		}
		matrix = temp;
	}

	public static void main(String[] args) throws Exception {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		R = Integer.parseInt(tokens.nextToken());
		depth = Math.min(N, M) / 2;
		matrix = new int[N][M];
		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				matrix[i][j] = Integer.parseInt(tokens.nextToken());
		}
		for (int i = 0; i < R; i++)
			rotate();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++)
				sb.append(matrix[i][j]).append(" ");
			sb.append("\n");
		}
		System.out.println(sb);
	}
}