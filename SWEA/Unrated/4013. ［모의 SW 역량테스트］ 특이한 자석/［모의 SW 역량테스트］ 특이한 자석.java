import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder sb = new StringBuilder();

	static int T, K, n, dir, ans;
	static int[] magnets = new int[4], status = new int[4];

	static void checkLeft() {
		for (int i = n - 1; i >= 0; i--)
			if (((magnets[i] & (1 << 5)) >> 5) != ((magnets[i + 1] & (1 << 1)) >> 1))
				status[i] = status[i + 1] * -1;
	}

	static void checkRight() {
		for (int i = n + 1; i < 4; i++)
			if (((magnets[i - 1] & (1 << 5)) >> 5) != ((magnets[i] & (1 << 1)) >> 1))
				status[i] = status[i - 1] * -1;
	}

	static void checkDir() {
		for (int i = 0; i < 4; i++)
			status[i] = 0;
		status[n] = dir;
		if (n == 0)
			checkRight();
		else if (n == 3)
			checkLeft();
		else {
			checkLeft();
			checkRight();
		}
	}

	static void rotate() {
		for (int i = 0; i < 4; i++) {
			if (status[i] == 1) {
				int temp = (magnets[i] & 1) << 7;
				magnets[i] = (magnets[i] >> 1) | temp;
			} else if (status[i] == -1) {
				int temp = (magnets[i] & (1 << 7)) >> 7;
				magnets[i] = (magnets[i] << 1) | temp;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			K = Integer.parseInt(br.readLine());
			for (int i = 0; i < 4; i++) {
				tokens = new StringTokenizer(br.readLine());
				int magnet = 0;
				while (tokens.hasMoreTokens()) {
					magnet <<= 1;
					if (tokens.nextToken().equals("1"))
						magnet |= 1;
				}
				magnets[i] = magnet;
			}
			for (int i = 0; i < K; i++) {
				tokens = new StringTokenizer(br.readLine());
				n = Integer.parseInt(tokens.nextToken()) - 1;
				dir = Integer.parseInt(tokens.nextToken());
				checkDir();
				rotate();
			}
			ans = 0;
			for (int i = 0; i < 4; i++)
				if ((magnets[i] & (1 << 7)) != 0)
					ans += Math.pow(2, i);
			sb.append("#" + t + " " + ans + "\n");
		}
		System.out.println(sb);
	}
}