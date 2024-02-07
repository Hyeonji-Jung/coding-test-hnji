import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer tokens;

	private static int N, area;
	private static boolean[][] map = new boolean[101][101];

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(tokens.nextToken());
			int Y = Integer.parseInt(tokens.nextToken());
			for (int x = X; x < X + 10; x++)
				for (int y = Y; y < Y + 10; y++)
					map[x][y] = true;
		}
		for (int i = 1; i <= 100; i++)
			for (int j = 1; j <= 100; j++)
				if (map[i][j])
					area++;
		System.out.println(area);
	}
}