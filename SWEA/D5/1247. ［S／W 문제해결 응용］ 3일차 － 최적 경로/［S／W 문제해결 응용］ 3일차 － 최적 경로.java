import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static class Pos {
		int x;
		int y;

		Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

		static int getDist(Pos p1, Pos p2) {
			return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
		}
	}

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer tokens;

	private static int T, N, minDist;
	private static Pos company, home;
	private static Pos[] customers;

	public static void dfs(int depth, int dist, Pos curr, boolean[] visited) {
		if (depth == N) {
			minDist = Math.min(minDist, dist + Pos.getDist(curr, home));
			return;
		}
		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;
			int nextDist = dist + Pos.getDist(curr, customers[i]);
			if (nextDist < minDist) {
				visited[i] = true;
				dfs(depth + 1, nextDist, customers[i], visited);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			tokens = new StringTokenizer(br.readLine());
			company = new Pos(Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken()));
			home = new Pos(Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken()));
			customers = new Pos[N];
			for (int i = 0; i < N; i++)
				customers[i] = new Pos(Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken()));
			minDist = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++)
				dfs(0, 0, company, new boolean[N]);
			sb.append("#" + t + " ").append(minDist).append("\n");
		}
		System.out.println(sb);
	}
}