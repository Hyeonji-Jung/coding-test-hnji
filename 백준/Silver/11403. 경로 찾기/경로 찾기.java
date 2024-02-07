import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer tokens;

	private static int N;
	private static int[][] graph;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine().trim());
		graph = new int[N][N];
		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				graph[i][j] = Integer.parseInt(tokens.nextToken());
		}
		for (int k = 0; k < N; k++)
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++)
					if (graph[i][k] == 1 && graph[k][j] == 1)
						graph[i][j] = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				sb.append(graph[i][j]).append(" ");
			sb.append("\n");
		}
		System.out.println(sb);
	}
}