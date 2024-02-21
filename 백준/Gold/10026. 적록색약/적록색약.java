import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	private static int N, area1, area2;
	private static char[][] pic;
	private static int[][] d = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	private static boolean[][] visited;

	private static void dfs(int x, int y, char color) {
		visited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + d[i][0];
			int ny = y + d[i][1];
			if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && pic[nx][ny] == color)
				dfs(nx, ny, color);
		}
	}

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		pic = new char[N][];
		for (int i = 0; i < N; i++)
			pic[i] = br.readLine().toCharArray();

		visited = new boolean[N][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				if (!visited[i][j]) {
					dfs(i, j, pic[i][j]);
					area1++;
				}

		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				if (pic[i][j] == 'R')
					pic[i][j] = 'G';

		visited = new boolean[N][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				if (!visited[i][j]) {
					dfs(i, j, pic[i][j]);
					area2++;
				}
		System.out.println(area1 + " " + area2);
	}
}