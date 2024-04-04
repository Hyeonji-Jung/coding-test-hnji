import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution {

	static class Pos implements Comparable<Pos> {
		int x, y, t;

		Pos(int x, int y, int t) {
			this.x = x;
			this.y = y;
			this.t = t;
		}

		@Override
		public int compareTo(Pos o) {
			return Integer.compare(this.t, o.t);
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	static int T, N, min;
	static int[][] map;
	static boolean[][] visited;
	static int[][] delta = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

	static void bfs() {
		PriorityQueue<Pos> q = new PriorityQueue<>();
		q.offer(new Pos(0, 0, 0));
		visited[0][0] = true;

		while (!q.isEmpty()) {
			Pos curr = q.poll();
			if (curr.x == N - 1 && curr.y == N - 1)
				min = Math.min(min, curr.t);
			for (int i = 0; i < 4; i++) {
				int nx = curr.x + delta[i][0];
				int ny = curr.y + delta[i][1];
				if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
					q.offer(new Pos(nx, ny, curr.t + map[nx][ny]));
					visited[nx][ny] = true;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				char[] temp = br.readLine().toCharArray();
				for (int j = 0; j < N; j++)
					map[i][j] = temp[j] - '0';
			}
			min = Integer.MAX_VALUE;
			bfs();
			sb.append("#" + t + " " + min + "\n");
		}
		System.out.println(sb);
	}
}