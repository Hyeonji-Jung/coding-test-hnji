import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static class Pos {
		int z;
		int x;
		int y;
		int min;

		Pos(int z, int x, int y, int min) {
			this.z = z;
			this.x = x;
			this.y = y;
			this.min = min;
		}
	}

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer tokens;

	private static int L, R, C, minutes;
	private static Pos S;
	private static char[][][] building;
	private static int[][] delta = { { 1, 0, 0 }, { -1, 0, 0 }, { 0, 1, 0 }, { 0, -1, 0 }, { 0, 0, 1 }, { 0, 0, -1 } };

	private static boolean isIn(int z, int x, int y) {
		return z >= 0 && z < L && x >= 0 && x < R && y >= 0 && y < C;
	}

	private static int bfs() {
		Deque<Pos> q = new ArrayDeque<>();
		q.offer(S);
		while (!q.isEmpty()) {
			Pos curr = q.poll();
			for (int[] del : delta) {
				int nz = curr.z + del[0];
				int nx = curr.x + del[1];
				int ny = curr.y + del[2];
				if (isIn(nz, nx, ny)) {
					if (building[nz][nx][ny] == 'E')
						return curr.min + 1;
					if (building[nz][nx][ny] == '.') {
						building[nz][nx][ny] = '#';
						q.offer(new Pos(nz, nx, ny, curr.min + 1));
					}
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) throws Exception {
		while (true) {
			tokens = new StringTokenizer(br.readLine());
			L = Integer.parseInt(tokens.nextToken());
			R = Integer.parseInt(tokens.nextToken());
			C = Integer.parseInt(tokens.nextToken());
			if (L == 0 && R == 0 && C == 0)
				break;
			building = new char[L][R][];
			for (int l = 0; l < L; l++) {
				for (int r = 0; r < R; r++) {
					building[l][r] = br.readLine().toCharArray();
					for (int c = 0; c < C; c++)
						if (building[l][r][c] == 'S')
							S = new Pos(l, r, c, 0);
				}
				br.readLine();
			}
			if ((minutes = bfs()) != -1)
				sb.append("Escaped in " + minutes + " minute(s).\n");
			else
				sb.append("Trapped!\n");
		}
		System.out.println(sb);
	}
}