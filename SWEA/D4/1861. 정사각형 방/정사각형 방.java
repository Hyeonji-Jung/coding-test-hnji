import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static class Pos {
		int x;
		int y;

		Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer tokens;

	private static int T, N, roomNum, maxMoves;
	private static int[][] rooms;
	private static int[] dx = { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 };

	private static int bfs(int x, int y) {
		int move = 1;
		boolean isPossible = false;
		while (true) {
			isPossible = false;
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= 0 && nx < N && ny >= 0 && ny < N && rooms[x][y] + 1 == rooms[nx][ny]) {
					move++;
					x = nx;
					y = ny;
					isPossible = true;
					break;
				}
			}
			if (!isPossible)
				break;
		}
		return move;
	}

	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			roomNum = 100_000;
			maxMoves = 0;
			rooms = new int[N][N];
			for (int i = 0; i < N; i++) {
				tokens = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++)
					rooms[i][j] = Integer.parseInt(tokens.nextToken());
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int move = bfs(i, j);
					if (move > maxMoves) {
						roomNum = rooms[i][j];
						maxMoves = move;
					} else if (move == maxMoves)
						roomNum = rooms[i][j] < roomNum ? rooms[i][j] : roomNum;
				}
			}
			sb.append("#").append(t).append(" ").append(roomNum).append(" ").append(maxMoves).append("\n");
		}
		System.out.println(sb);
	}
}