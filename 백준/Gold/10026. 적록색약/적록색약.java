import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

import sun.tools.jar.resources.jar;

public class Main {

	static class Pos {
		int x;
		int y;

		Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	private static int N, area1, area2;
	private static char[][] pic1, pic2;
	private static int[][] d = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	private static boolean[][] visited1, visited2;

	private static void bfs(int x, int y, boolean flag) {
		ArrayDeque<Pos> q = new ArrayDeque<>();
		if (!flag)
			visited1[x][y] = true;
		else
			visited2[x][y] = true;
		q.offer(new Pos(x, y));
		while (!q.isEmpty()) {
			Pos curr = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = curr.x + d[i][0];
				int ny = curr.y + d[i][1];
				if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
					if (!flag && !visited1[nx][ny] && pic1[x][y] == pic1[nx][ny]) {
						visited1[nx][ny] = true;
						q.offer(new Pos(nx, ny));
					} else if (flag && !visited2[nx][ny] && pic2[x][y] == pic2[nx][ny]) {
						visited2[nx][ny] = true;
						q.offer(new Pos(nx, ny));
					}
				}
			}
		}
		if (!flag)
			area1++;
		else
			area2++;
	}

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		pic1 = new char[N][];
		pic2 = new char[N][N];
		for (int i = 0; i < N; i++) {
			pic1[i] = br.readLine().toCharArray();
			for (int j = 0; j < N; j++)
				pic2[i][j] = pic1[i][j] == 'G' ? 'R' : pic1[i][j];
		}
		visited1 = new boolean[N][N];
		visited2 = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited1[i][j])
					bfs(i, j, false);
				if (!visited2[i][j])
					bfs(i, j, true);
			}
		}
		System.out.println(area1 + " " + area2);
	}
}