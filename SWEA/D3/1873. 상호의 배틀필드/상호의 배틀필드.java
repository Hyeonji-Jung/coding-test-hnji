import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer tokens;

	private static int T, H, W, N, currX, currY, dir;
	private static int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3;
	private static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	private static char[] tank = { '^', 'v', '<', '>' };
	private static char[] comm;
	private static char[][] map;

	private static void move() {
		int nx = currX + delta[dir][0];
		int ny = currY + delta[dir][1];
		if (nx >= 0 && nx < H && ny >= 0 && ny < W && map[nx][ny] == '.') {
			map[currX][currY] = '.';
			map[nx][ny] = tank[dir];
			currX = nx;
			currY = ny;
		}
	}

	private static void shoot() {
		int nx = currX;
		int ny = currY;
		while (true) {
			nx += delta[dir][0];
			ny += delta[dir][1];
			if (nx >= 0 && nx < H && ny >= 0 && ny < W) {
				if (map[nx][ny] == '.' || map[nx][ny] == '-')
					continue;
				if (map[nx][ny] == '*')
					map[nx][ny] = '.';
				break;
			} else
				break;
		}
	}

	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			tokens = new StringTokenizer(br.readLine());
			H = Integer.parseInt(tokens.nextToken());
			W = Integer.parseInt(tokens.nextToken());
			map = new char[H][];
			dir = -1;
			for (int i = 0; i < H; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j = 0; j < W; j++) {
					for (int k = 0; k < 4; k++)
						if (dir == -1)
							if (map[i][j] == tank[k]) {
								currX = i;
								currY = j;
								dir = k;
								break;
							}
				}
			}
			N = Integer.parseInt(br.readLine());
			comm = br.readLine().toCharArray();
			for (int i = 0; i < N; i++) {
				if (comm[i] == 'S')
					shoot();
				else {
					switch (comm[i]) {
					case 'U':
						dir = UP;
						break;
					case 'D':
						dir = DOWN;
						break;
					case 'L':
						dir = LEFT;
						break;
					case 'R':
						dir = RIGHT;
						break;
					}
					map[currX][currY] = tank[dir];
					move();
				}
			}
			sb.append("#" + t + " ");
			for (int i = 0; i < H; i++)
				sb.append(String.valueOf(map[i])).append("\n");
		}
		System.out.println(sb);
	}
}