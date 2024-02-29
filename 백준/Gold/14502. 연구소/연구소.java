import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	static class Pos {
		int x, y;

		Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer tokens;

	private static int N, M, safeArea;
	private static int[][] map;
	private static int[][] d = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	private static void bfs() {
		ArrayDeque<Pos> q = new ArrayDeque<>();
		int[][] tmp = new int[N][M];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++) {
				tmp[i][j] = map[i][j];
				if (tmp[i][j] == 2)
					q.offer(new Pos(i, j));
			}
		while (!q.isEmpty()) {
			Pos curr = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = curr.x + d[i][0];
				int ny = curr.y + d[i][1];
				if (nx >= 0 && nx < N && ny >= 0 && ny < M && tmp[nx][ny] == 0) {
					q.offer(new Pos(nx, ny));
					tmp[nx][ny] = 2;
				}
			}
		}
		int area = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				if (tmp[i][j] == 0)
					area++;
		safeArea = Math.max(safeArea, area);
	}

	private static void dfs(int cnt) {
		if (cnt == 3) {
			bfs();
			return;
		}
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				if (map[i][j] == 0) {
					map[i][j] = 1;
					dfs(cnt + 1);
					map[i][j] = 0;
				}
	}

	public static void main(String[] args) throws Exception {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(tokens.nextToken());
		}
		dfs(0);
		System.out.println(safeArea);
	}
}