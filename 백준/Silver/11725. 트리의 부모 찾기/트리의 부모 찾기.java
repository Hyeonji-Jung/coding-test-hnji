import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer tokens;

	private static int N;
	private static ArrayList<Integer> tree[];
	private static int[] parent;

	private static void dfs(int node, boolean[] visited) {
		visited[node] = true;
		for (int next : tree[node]) {
			if (!visited[next]) {
				parent[next] = node;
				dfs(next, visited);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		tree = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			tree[i] = new ArrayList<>();
		parent = new int[N + 1];
		boolean[] visited = new boolean[N + 1];
		Arrays.fill(visited, false);

		for (int i = 0; i < N - 1; i++) {
			tokens = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			tree[a].add(b);
			tree[b].add(a);
		}
		dfs(1, visited);
		for (int i = 2; i <= N; i++)
			sb.append(parent[i]).append("\n");
		System.out.println(sb);
	}
}