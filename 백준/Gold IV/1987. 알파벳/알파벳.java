import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer tokens;

	private static int R, C, max;
	private static char[][] board;
	private static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	private static void dfs(int x, int y, boolean[] visited, int cnt) {
		visited[board[x][y] - 'A'] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + delta[i][0];
			int ny = y + delta[i][1];
			if (nx >= 0 && nx < R && ny >= 0 && ny < C && !visited[board[nx][ny] - 'A'])
				dfs(nx, ny, visited, cnt + 1);
		}
		visited[board[x][y] - 'A'] = false;
		max = Math.max(max, cnt);
	}

	public static void main(String[] args) throws Exception {
		tokens = new StringTokenizer(br.readLine());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		board = new char[R][];
		for (int i = 0; i < R; i++)
			board[i] = br.readLine().toCharArray();
		dfs(0, 0, new boolean['Z' - 'A' + 1], 1);
		System.out.println(max);
	}
}