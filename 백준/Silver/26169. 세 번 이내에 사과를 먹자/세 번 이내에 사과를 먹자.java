import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer tokens;

	private static int[][] board = new int[5][5];
	private static boolean[][] visited = new boolean[5][5];
	private static int r, c;
	private static boolean flag;

	private static int[] dx = { 0, 0, 1, -1 };
	private static int[] dy = { 1, -1, 0, 0 };

	public static void dfs(int x, int y, int apples, int depth) {
		if (flag || depth > 3)
			return;
		if (board[x][y] == 1) {
			if (++apples >= 2) {
				flag = true;
				return;
			}
		}
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (isIn(nx, ny) && board[nx][ny] != -1 && !visited[nx][ny]) {
				visited[nx][ny] = true;
				dfs(nx, ny, apples, depth + 1);
				visited[nx][ny] = false;
			}
		}
	}

	private static boolean isIn(int nx, int ny) {
		return nx >= 0 && nx < 5 && ny >= 0 && ny < 5;
	}

	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 5; i++) {
			tokens = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++)
				board[i][j] = Integer.parseInt(tokens.nextToken());
		}
		
		tokens = new StringTokenizer(br.readLine());
		r = Integer.parseInt(tokens.nextToken());
		c = Integer.parseInt(tokens.nextToken());
		
		visited[r][c] = true;
		dfs(r, c, 0, 0);
		System.out.println(flag ? 1 : 0);
	}
}