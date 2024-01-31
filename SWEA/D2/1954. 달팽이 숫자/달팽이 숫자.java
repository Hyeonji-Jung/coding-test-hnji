import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();

	private static int T, N, x, y, curr, direction;
	private static int[][] snail;
	private static int[] dx = new int[] { 0, 1, 0, -1 };
	private static int[] dy = new int[] { 1, 0, -1, 0 };

	private static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}

	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			snail = new int[N][N];
			for (int i = 0; i < N; i++)
				Arrays.fill(snail[i], 0);
			x = 0;
			y = 0;
			curr = 1;
			direction = 0;

			while (curr <= N * N) {
				snail[x][y] = curr++;
				int nx = x + dx[direction];
				int ny = y + dy[direction];
				if (!isIn(nx, ny) || snail[nx][ny] != 0) {
					direction = (direction + 1) % 4;
				}
				x += dx[direction];
				y += dy[direction];
			}

			sb.append("#").append(t).append("\n");
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(snail[i][j]).append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}