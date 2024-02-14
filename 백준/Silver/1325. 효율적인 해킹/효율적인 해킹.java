import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static class Computer {
		int idx;
		ArrayList<Computer> list;

		Computer(int idx) {
			this.idx = idx;
			list = new ArrayList<>();
		}
	}

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer tokens;

	private static int N, M;
	private static Computer[] graph;
	private static int[] trusted;
	private static boolean[] visited;

	private static void dfs(int num) {
		visited[num] = true;
		for (Computer next : graph[num].list)
			if (!visited[next.idx]) {
				trusted[next.idx]++;
				dfs(next.idx);
			}
	}

	public static void main(String[] args) throws Exception {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		graph = new Computer[N + 1];
		trusted = new int[N + 1];
		for (int n = 1; n <= N; n++)
			graph[n] = new Computer(n);
		for (int m = 0; m < M; m++) {
			tokens = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			graph[a].list.add(graph[b]);
		}
		for (int i = 1; i <= N; i++) {
			visited = new boolean[N + 1];
			dfs(i);
		}
		int max = 0;
		for (int i = 1; i <= N; i++)
			max = Math.max(trusted[i], max);
		for (int i = 1; i <= N; i++)
			if (max == trusted[i])
				sb.append(i + " ");
		System.out.println(sb);
	}
}