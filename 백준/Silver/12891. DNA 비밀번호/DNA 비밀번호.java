import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer tokens;

	private static int S, P, A, C, G, T, cnt;
	private static char[] str;
	private static int[][] chars;

	public static void main(String[] args) throws Exception {
		tokens = new StringTokenizer(br.readLine());
		S = Integer.parseInt(tokens.nextToken());
		P = Integer.parseInt(tokens.nextToken());
		chars = new int[S + 1][4];
		str = br.readLine().trim().toCharArray();
		tokens = new StringTokenizer(br.readLine());
		A = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		G = Integer.parseInt(tokens.nextToken());
		T = Integer.parseInt(tokens.nextToken());

		for (int i = 1; i < P; i++)
			update(i, str[i - 1]);
		for (int i = P; i < S + 1; i++) {
			update(i, str[i - 1]);
			if (chars[i][0] - chars[i - P][0] >= A && chars[i][1] - chars[i - P][1] >= C
					&& chars[i][2] - chars[i - P][2] >= G && chars[i][3] - chars[i - P][3] >= T)
				cnt++;
		}
		System.out.println(cnt);
	}

	private static void update(int i, char c) {
		int idx = -1;
		switch (c) {
		case 'A':
			idx = 0;
			break;
		case 'C':
			idx = 1;
			break;
		case 'G':
			idx = 2;
			break;
		case 'T':
			idx = 3;
		}
		for (int j = 0; j < 4; j++) {
			chars[i][j] = chars[i - 1][j];
			if (j == idx)
				chars[i][j]++;
		}
	}
}