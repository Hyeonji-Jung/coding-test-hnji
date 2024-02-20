import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

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
	private static StringTokenizer tokens;

	private static int R, C, cheeseCnt, time;
	private static int[][] pan;
	private static int[][] d = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	private static void bfs() {
		ArrayDeque<Pos> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[R][C];
		visited[0][0] = true;
		pan[0][0] = 2;
		q.offer(new Pos(0, 0));
		while (!q.isEmpty()) {
			Pos curr = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = curr.x + d[i][0];
				int ny = curr.y + d[i][1];
				if (nx >= 0 && nx < R && ny >= 0 && ny < C && !visited[nx][ny]) {
					visited[nx][ny] = true;
					if (pan[nx][ny] != 1) {
						pan[nx][ny] = 2;
						q.offer(new Pos(nx, ny));
					}
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		tokens = new StringTokenizer(br.readLine());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		pan = new int[R][C];
		for (int i = 0; i < R; i++) {
			tokens = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				pan[i][j] = Integer.parseInt(tokens.nextToken());
				if (pan[i][j] == 1)
					cheeseCnt++;
			}
		}
		while (true) {
			bfs();
			int melted = 0;
			for (int i = 0; i < R; i++)
				for (int j = 0; j < C; j++) {
					if (pan[i][j] == 1) {
						boolean flag = false;
						for (int k = 0; k < 4; k++) {
							int nx = i + d[k][0];
							int ny = j + d[k][1];
							if (nx >= 0 && nx < R && ny >= 0 && ny < C && pan[nx][ny] == 2) {
								flag = true;
								break;
							}
						}
						if (flag) {
							pan[i][j] = 3;
							melted++;
						}
					}
				}
			time++;
			if (melted == cheeseCnt)
				break;
			cheeseCnt -= melted;
		}
		System.out.println(time + "\n" + cheeseCnt);
	}
}