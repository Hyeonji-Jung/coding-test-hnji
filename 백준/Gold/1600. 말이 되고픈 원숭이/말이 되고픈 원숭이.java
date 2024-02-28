import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	static class Move {
		int x, y, moves, jump;

		Move(int x, int y, int moves, int jump) {
			this.x = x;
			this.y = y;
			this.moves = moves;
			this.jump = jump;
		}
	}

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer tokens;

	private static int K, W, H;
	private static boolean[][] wall;
	private static boolean[][][] visited;
	private static int[][] horse = new int[][] { { -2, -1 }, { -1, -2 }, { -2, 1 }, { -1, 2 }, { 1, -2 }, { 1, 2 },
			{ 2, -1 }, { 2, 1 } }, monkey = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws Exception {
		K = Integer.parseInt(br.readLine());
		tokens = new StringTokenizer(br.readLine());
		W = Integer.parseInt(tokens.nextToken());
		H = Integer.parseInt(tokens.nextToken());
		wall = new boolean[H][W];
		for (int i = 0; i < H; i++) {
			tokens = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++)
				if (tokens.nextToken().charAt(0) == '1')
					wall[i][j] = true;
		}
		visited = new boolean[H][W][K + 1];
		ArrayDeque<Move> q = new ArrayDeque<>();
		q.offer(new Move(0, 0, 0, 0));
		visited[0][0][0] = true;
		while (!q.isEmpty()) {
			Move curr = q.poll();
			if (curr.x == H - 1 && curr.y == W - 1) {
				System.out.println(curr.moves);
				return;
			}
			if (curr.jump < K)
				for (int i = 0; i < 8; i++) {
					int nx = curr.x + horse[i][0];
					int ny = curr.y + horse[i][1];
					if (nx >= 0 && nx < H && ny >= 0 && ny < W && !wall[nx][ny] && !visited[nx][ny][curr.jump + 1]) {
						visited[nx][ny][curr.jump + 1] = true;
						q.offer(new Move(nx, ny, curr.moves + 1, curr.jump + 1));
					}
				}
			for (int i = 0; i < 4; i++) {
				int nx = curr.x + monkey[i][0];
				int ny = curr.y + monkey[i][1];
				if (nx >= 0 && nx < H && ny >= 0 && ny < W && !wall[nx][ny] && !visited[nx][ny][curr.jump]) {
					visited[nx][ny][curr.jump] = true;
					q.offer(new Move(nx, ny, curr.moves + 1, curr.jump));
				}
			}
		}
		System.out.println(-1);
	}
}