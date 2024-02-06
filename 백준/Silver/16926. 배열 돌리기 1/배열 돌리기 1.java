import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer tokens;

	private static int N, M, R, depth;
	private static int[][] matrix;
	private static Deque<Integer>[] layers;

	public static void main(String[] args) throws Exception {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		R = Integer.parseInt(tokens.nextToken());
		matrix = new int[N][M];
		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				matrix[i][j] = Integer.parseInt(tokens.nextToken());
		}
		
		depth = Math.min(N, M) / 2;
		layers = new Deque[depth];
		for (int i = 0; i < depth; i++) {
			layers[i] = new ArrayDeque<>();
			int r = i;
			int c = i;
			do {
				layers[i].add(matrix[r][c]);
				if (r == i && c < M - i - 1)
					c++;
				else if (r < N - i - 1 && c == M - i - 1)
					r++;
				else if (r == N - i - 1 && c > i)
					c--;
				else
					r--;
			} while (r != i || c != i);
			
			for (int j = 0; j < R; j++)
				layers[i].offer(layers[i].poll());
			
			r = i;
			c = i;
			do {
				matrix[r][c] = layers[i].poll();
				if (r == i && c < M - i - 1)
					c++;
				else if (r < N - i - 1 && c == M - i - 1)
					r++;
				else if (r == N - i - 1 && c > i)
					c--;
				else
					r--;
			} while (r != i || c != i);
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++)
				sb.append(matrix[i][j]).append(" ");
			sb.append("\n");
		}
		System.out.println(sb);
	}
}