import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int R, C, T, ans;
	static int[][] room;
	static int[] airc;
	static int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		room = new int[R][C];
		airc = new int[2];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
				if (room[i][j] == -1) {
					airc[0] = i - 1;
					airc[1] = i;
				}
			}
		}

		for (int t = 0; t < T; t++) {
			spread();
			operate();
		}

		for (int i = 0; i < R; i++)
			for (int j = 0; j < C; j++)
				if (room[i][j] > 0)
					ans += room[i][j];
		System.out.println(ans);
	}

	static void spread() {
		int[][] newRoom = new int[R][C];
		newRoom[airc[0]][0] = newRoom[airc[1]][0] = -1;

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (room[i][j] > 0) {
					int dirCnt = 0;
					int spr = room[i][j] / 5;
					for (int[] dir : directions) {
						int nx = i + dir[0];
						int ny = j + dir[1];
						if (nx >= 0 && nx < R && ny >= 0 && ny < C && room[nx][ny] >= 0) {
							newRoom[nx][ny] += spr;
							dirCnt++;
						}
					}
					newRoom[i][j] += room[i][j] - dirCnt * spr;
				}
			}
		}
		room = newRoom;
	}

	static void operate() {
		int r = airc[0] - 1, c = 0;
		while (r > 0) {
			room[r][c] = room[r - 1][c];
			r--;
		}
		while (c + 1 < C) {
			room[r][c] = room[r][c + 1];
			c++;
		}
		while (r < airc[0]) {
			room[r][c] = room[r + 1][c];
			r++;
		}
		while (c > 1) {
			room[r][c] = room[r][c - 1];
			c--;
		}
		room[r][c] = 0;

		r = airc[1] + 1;
		c = 0;
		while (r + 1 < R) {
			room[r][c] = room[r + 1][c];
			r++;
		}
		while (c + 1 < C) {
			room[r][c] = room[r][c + 1];
			c++;
		}
		while (r > airc[1]) {
			room[r][c] = room[r - 1][c];
			r--;
		}
		while (c > 1) {
			room[r][c] = room[r][c - 1];
			c--;
		}
		room[r][c] = 0;
	}
}