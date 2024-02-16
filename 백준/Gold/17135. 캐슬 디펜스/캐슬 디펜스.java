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

	private static int N, M, D, enemyCnt, maxKill;
	private static int[] archers = new int[3];
	private static boolean[][] base, map;
	private static int[][] delta = { { 0, -1 }, { -1, 0 }, { 0, 1 } };

	private static int shoot() {
		int killCnt = 0;
		int[] killed = { -1, -1, -1, -1, -1, -1 };
		for (int a = 0; a < 3; a++) {
			ArrayDeque<Pos> q = new ArrayDeque<>();
			boolean[][] visited = new boolean[N][M];
			q.add(new Pos(N, archers[a]));
			find: while (!q.isEmpty()) {
				Pos curr = q.poll();
				for (int i = 0; i < 3; i++) {
					int nx = curr.x + delta[i][0];
					int ny = curr.y + delta[i][1];
					if (Math.abs(nx - N) + Math.abs(ny - archers[a]) > D)
						break find;
					if (nx < 0 || nx >= N || ny < 0 || ny >= M)
						continue;
					if (!map[nx][ny] && !visited[nx][ny]) {
						visited[nx][ny] = true;
						q.offer(new Pos(nx, ny));
					} else if (map[nx][ny]) {
						killed[a * 2] = nx;
						killed[a * 2 + 1] = ny;
						break find;
					}
				}
			}
		}
		for (int i = 0; i < 6; i += 2)
			if (killed[i] != -1 && map[killed[i]][killed[i + 1]]) {
				killCnt++;
				map[killed[i]][killed[i + 1]] = false;
			}
		return killCnt;
	}

	private static int move() {
		int removedCnt = 0;
		for (int i = 0; i < M; i++)
			if (map[N - 1][i])
				removedCnt++;
		for (int i = N - 1; i > 0; i--)
			for (int j = 0; j < M; j++)
				map[i][j] = map[i - 1][j];
		for (int i = 0; i < M; i++)
			map[0][i] = false;
		return removedCnt;
	}

	private static void game() {
		int leftEnemy = enemyCnt;
		int totalKillCnt = 0;
		while (leftEnemy > 0) {
			int currKillCnt = shoot();
			totalKillCnt += currKillCnt;
			leftEnemy -= currKillCnt;
			leftEnemy -= move();
		}
		maxKill = Math.max(maxKill, totalKillCnt);
	}

	private static void initMap() {
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				map[i][j] = base[i][j];
	}

	private static void dfs(int cnt, int start) {
		if (cnt == 3) {
			initMap();
			game();
			return;
		}
		for (int i = start; i < M; i++) {
			archers[cnt] = i;
			dfs(cnt + 1, i + 1);
		}
	}

	public static void main(String[] args) throws Exception {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		D = Integer.parseInt(tokens.nextToken());
		base = new boolean[N][M];
		map = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				if (tokens.nextToken().equals("1")) {
					base[i][j] = true;
					enemyCnt++;
				}
		}
		dfs(0, 0);
		System.out.println(maxKill);
	}
}