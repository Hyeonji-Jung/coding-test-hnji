import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer tokens;

	private static int N, M, V;
	private static int[][] graph;
	private static boolean[] visited;

	private static void dfs(int depth, int v, boolean[] visited) {
		if (depth == N)
			return;
		sb.append(v).append(" ");
		visited[v] = true;
		for (int i = 1; i <= N; i++)
			if (graph[v][i] == 1 && !visited[i])
				dfs(depth + 1, i, visited);
	}

	private static void bfs() {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.offer(V);
		visited[V] = true;
		sb.append(V).append(" ");
		while (!q.isEmpty()) {
			int v = q.poll();
			for (int i = 1; i <= N; i++)
				if (graph[v][i] == 1 && !visited[i]) {
					visited[i] = true;
					q.offer(i);
					sb.append(i).append(" ");
				}
		}
	}

	public static void main(String[] args) throws Exception {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		V = Integer.parseInt(tokens.nextToken());
		graph = new int[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			tokens = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			graph[a][b] = graph[b][a] = 1;
		}
		visited = new boolean[N + 1];
		dfs(0, V, visited);
		sb.append("\n");
		visited = new boolean[N + 1];
		bfs();
		System.out.println(sb);
	}
}