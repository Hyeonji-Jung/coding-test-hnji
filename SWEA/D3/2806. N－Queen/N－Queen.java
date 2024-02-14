import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();

	static int T, N, cnt;
	static int[] queens;

	private static boolean chk(int col) {
		for (int i = 0; i < col; i++)
			if (queens[i] == queens[col] || Math.abs(i - col) == Math.abs(queens[i] - queens[col]))
				return false;
		return true;
	}

	private static void nQueen(int col) {
		if (col == N) {
			cnt++;
			return;
		}
		for (int i = 0; i < N; i++) {
			queens[col] = i;
			if (chk(col))
				nQueen(col + 1);
		}
	}

	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			cnt = 0;
			queens = new int[N];
			nQueen(0);
			sb.append("#" + t + " ").append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}