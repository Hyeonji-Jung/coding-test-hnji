import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer tokens;

	private static int N, M;
	private static ArrayList<Integer>[] friends;
	private static boolean[] visited;
	private static boolean flag;

	private static void dfs(int depth, int curr) {
		if (flag)
			return;
		if (depth == 5) {
			flag = true;
			return;
		}
		for (int next : friends[curr]) {
			if (!visited[next]) {
				visited[next] = true;
				dfs(depth + 1, next);
				visited[next] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		friends = new ArrayList[N];
		for (int i = 0; i < N; i++)
			friends[i] = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			tokens = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			friends[a].add(b);
			friends[b].add(a);
		}
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(visited, false);
			visited[i] = true;
			dfs(1, i);
		}
		System.out.println(flag ? 1 : 0);
	}
}