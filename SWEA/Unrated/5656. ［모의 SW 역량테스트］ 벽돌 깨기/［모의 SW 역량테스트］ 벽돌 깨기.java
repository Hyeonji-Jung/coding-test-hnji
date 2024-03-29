import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Solution {

	static class Brick {
		int x, y, b;

		Brick(int x, int y, int b) {
			this.x = x;
			this.y = y;
			this.b = b;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder sb = new StringBuilder();

	static int T, N, W, H, minBrickCnt;
	static int[][] delta = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static ArrayDeque<Brick> q;

	static int[][] bfs(int p, int[][] bricks) {
		int[][] nextBricks = new int[H][W];
		for (int i = 0; i < H; i++)
			for (int j = 0; j < W; j++)
				nextBricks[i][j] = bricks[i][j];

		q = new ArrayDeque<Brick>();
		for (int i = 0; i < H; i++)
			if (nextBricks[i][p] > 0) {
				q.offer(new Brick(i, p, nextBricks[i][p]));
				nextBricks[i][p] = 0;
				break;
			}

		while (!q.isEmpty()) {
			Brick curr = q.poll();
			for (int d = 1; d < curr.b; d++) {
				for (int i = 0; i < 4; i++) {
					int nx = curr.x + delta[i][0] * d;
					int ny = curr.y + delta[i][1] * d;
					if (nx >= 0 && nx < H && ny >= 0 && ny < W && nextBricks[nx][ny] > 0) {
						q.offer(new Brick(nx, ny, nextBricks[nx][ny]));
						nextBricks[nx][ny] = 0;
					}
				}
			}
		}

		for (int i = 0; i < W; i++) {
			for (int j = H - 1; j >= 1; j--) {
				if (nextBricks[j][i] != 0)
					continue;
				for (int k = j - 1; k >= 0; k--) {
					if (nextBricks[k][i] != 0) {
						nextBricks[j][i] = nextBricks[k][i];
						j--;
						nextBricks[k][i] = 0;
					}
				}
			}
		}

		return nextBricks;
	}

	static void dfs(int depth, int[][] bricks) {
		int brickCnt = 0;
		for (int i = 0; i < H; i++)
			for (int j = 0; j < W; j++)
				if (bricks[i][j] > 0)
					brickCnt++;

//		System.out.println(depth + " " + brickCnt);
//		for (int i = 0; i < H; i++) {
//			for (int j = 0; j < W; j++)
//				System.out.print(bricks[i][j] + " ");
//			System.out.println();
//		}
//		System.out.println();

		if (depth == N || brickCnt == 0) {
			minBrickCnt = Math.min(minBrickCnt, brickCnt);
			return;
		}
		for (int p = 0; p < W; p++)
			dfs(depth + 1, bfs(p, bricks));
	}

	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			tokens = new StringTokenizer(br.readLine());
			N = Integer.parseInt(tokens.nextToken());
			W = Integer.parseInt(tokens.nextToken());
			H = Integer.parseInt(tokens.nextToken());
			int[][] bricks = new int[H][W];
			for (int i = 0; i < H; i++) {
				tokens = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++)
					bricks[i][j] = Integer.parseInt(tokens.nextToken());
			}
			minBrickCnt = Integer.MAX_VALUE;
			dfs(0, bricks);
			sb.append("#").append(t).append(" ").append(minBrickCnt).append("\n");
		}
		System.out.println(sb);
	}
}