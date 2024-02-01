import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer tokens;

	private static int N, minDiff;
	private static int[][] taste;

	private static void cook(int cnt, int ingredients, int sour, int bitter) {
		if (cnt == N) {
			if (ingredients > 0)
				minDiff = Math.min(minDiff, Math.abs(sour - bitter));
			return;
		}
		cook(cnt + 1, ingredients, sour, bitter);
		cook(cnt + 1, ingredients + 1, sour * taste[cnt][0], bitter + taste[cnt][1]);
	}

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		minDiff = Integer.MAX_VALUE;
		taste = new int[N][2];
		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(br.readLine());
			taste[i][0] = Integer.parseInt(tokens.nextToken());
			taste[i][1] = Integer.parseInt(tokens.nextToken());
		}
		cook(0, 0, 1, 0);
		System.out.println(minDiff);
	}
}