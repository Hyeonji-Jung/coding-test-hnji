import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer tokens;

	private static int T, winCnt, loseCnt;
	private static int[] A, B;
	private static boolean[] selected;

	private static boolean np() {
		int i = 8;
		while (i > 0 && B[i - 1] > B[i])
			i--;
		if (i == 0)
			return false;
		int j = 8;
		while (B[j] < B[i - 1])
			j--;
		int temp = B[i - 1];
		B[i - 1] = B[j];
		B[j] = temp;
		int k = 8;
		while (i < k) {
			temp = B[i];
			B[i] = B[k];
			B[k] = temp;
			i++;
			k--;
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			A = new int[9];
			B = new int[9];
			selected = new boolean[19];
			Arrays.fill(selected, false);
			winCnt = 0;
			loseCnt = 0;

			tokens = new StringTokenizer(br.readLine());
			for (int n = 0; n < 9; n++) {
				A[n] = Integer.parseInt(tokens.nextToken());
				selected[A[n]] = true;
			}
			int idx = 0;
			for (int n = 1; n <= 18; n++)
				if (!selected[n])
					B[idx++] = n;

			do {
				int total = 0;
				for (int i = 0; i < 9; i++) {
					if (A[i] > B[i])
						total += A[i] + B[i];
					else if (A[i] < B[i])
						total -= A[i] + B[i];
				}
				if (total > 0)
					winCnt++;
				else if (total < 0)
					loseCnt++;
			} while (np());
			sb.append("#").append(t).append(" ").append(winCnt).append(" ").append(loseCnt).append("\n");
		}
		System.out.println(sb);
	}
}