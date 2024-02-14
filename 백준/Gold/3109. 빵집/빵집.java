import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer tokens;

	private static int R, C, cnt;
	private static char[][] map;
	private static int[] dx = { -1, 0, 1 };

	private static boolean pipe(int r, int c) {
		if (c == C - 1) {
			cnt++;
			return true;
		}
		map[r][c] = 'x';
		for (int i = 0; i < 3; i++) {
			int nr = r + dx[i];
			if (nr >= 0 && nr < R && map[nr][c + 1] == '.')
				if (pipe(nr, c + 1))
					return true;
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		tokens = new StringTokenizer(br.readLine());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		map = new char[R][];
		for (int i = 0; i < R; i++)
			map[i] = br.readLine().toCharArray();
		for (int i = 0; i < R; i++)
			pipe(i, 0);
		System.out.println(cnt);
	}
}