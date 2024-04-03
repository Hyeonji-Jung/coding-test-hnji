import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder sb = new StringBuilder();

	static int T, N, M, tallerCnt, shorterCnt, ans;
	static boolean[][] graph;

	static void getTaller(int from, boolean[] visited) {
		visited[from] = true;
		for (int i = 1; i <= N; i++)
			if (graph[from][i] && !visited[i]) {
				getTaller(i, visited);
				tallerCnt++;
			}
	}

	static void getShorter(int to, boolean[] visited) {
		visited[to] = true;
		for (int i = 1; i <= N; i++)
			if (graph[i][to] && !visited[i]) {
				getShorter(i, visited);
				shorterCnt++;
			}
	}

	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			graph = new boolean[N + 1][N + 1];
			for (int i = 0; i < M; i++) {
				tokens = new StringTokenizer(br.readLine());
				graph[Integer.parseInt(tokens.nextToken())][Integer.parseInt(tokens.nextToken())] = true;
			}
			ans = 0;
			for (int i = 1; i <= N; i++) {
				tallerCnt = shorterCnt = 0;
				getTaller(i, new boolean[N + 1]);
				getShorter(i, new boolean[N + 1]);
				if (tallerCnt + shorterCnt == N - 1)
					ans++;
			}
			sb.append("#" + t + " " + ans + "\n");
		}
		System.out.println(sb);
	}
}