import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

	static class Core {
		int x, y;

		Core(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer tokens;

	private static int T, N, coreCnt, maxCore, minLength;
	private static ArrayList<Core> c;
	private static int[][] m, d = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	private static void connect(int depth, int cnt, int wire) {
		if (depth == coreCnt) {
			if (cnt > maxCore) {
				maxCore = cnt;
				minLength = wire;
			} else if (cnt == maxCore && wire < minLength)
				minLength = wire;
			return;
		}
		connect(depth + 1, cnt, wire);
		Core core = c.get(depth);
		for (int i = 0; i < 4; i++) {
			boolean flag = false;
			int currDist = 1;
			while (true) {
				int nx = core.x + d[i][0] * currDist;
				int ny = core.y + d[i][1] * currDist;
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || m[nx][ny] == 1)
					break;
				if (nx == 0 || nx == N - 1 || ny == 0 || ny == N - 1) {
					flag = true;
					break;
				}
				currDist++;
			}
			if (flag) {
				for (int j = 1; j <= currDist; j++) {
					int nx = core.x + d[i][0] * j;
					int ny = core.y + d[i][1] * j;
					m[nx][ny] = 1;
				}
				connect(depth + 1, cnt + 1, wire + currDist);
				for (int j = 1; j <= currDist; j++) {
					int nx = core.x + d[i][0] * j;
					int ny = core.y + d[i][1] * j;
					m[nx][ny] = 0;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			m = new int[N][N];
			c = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				tokens = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					m[i][j] = Integer.parseInt(tokens.nextToken());
					if (m[i][j] == 1 && i != 0 && i != N - 1 && j != 0 && j != N - 1)
						c.add(new Core(i, j));
				}
			}
			coreCnt = c.size();
			maxCore = Integer.MIN_VALUE;
			minLength = Integer.MAX_VALUE;
			connect(0, 0, 0);
			sb.append("#" + t + " " + minLength + "\n");
		}
		System.out.println(sb);
	}
}