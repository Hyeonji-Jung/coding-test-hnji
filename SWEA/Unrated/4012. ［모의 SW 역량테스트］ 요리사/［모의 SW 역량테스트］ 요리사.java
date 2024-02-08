import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer tokens;

	private static int T, N, minDiff;
	private static int[][] S;
	private static int[] selected;

	private static boolean np() {
		int i = N - 1;
		while (i > 0 && selected[i - 1] >= selected[i])
			i--;
		if (i == 0)
			return false;
		int j = N - 1;
		while (selected[i - 1] >= selected[j])
			j--;
		int temp1 = selected[i - 1];
		selected[i - 1] = selected[j];
		selected[j] = temp1;
		int k = N - 1;
		while (i < k) {
			int temp2 = selected[i];
			selected[i] = selected[k];
			selected[k] = temp2;
			i++;
			k--;
		}
		return true;
	}

	private static int cooking() {
		ArrayList<Integer> dish1 = new ArrayList<>();
		ArrayList<Integer> dish2 = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			if (selected[i] == 0)
				dish1.add(i);
			else
				dish2.add(i);
		}
		int s1 = 0;
		int s2 = 0;
		for (int i = 0; i < N / 2 - 1; i++) {
			for (int j = i; j < N / 2; j++) {
				s1 += S[dish1.get(i)][dish1.get(j)] + S[dish1.get(j)][dish1.get(i)];
				s2 += S[dish2.get(i)][dish2.get(j)] + S[dish2.get(j)][dish2.get(i)];
			}
		}
		return Math.abs(s1 - s2);
	}

	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			S = new int[N][N];
			for (int i = 0; i < N; i++) {
				tokens = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++)
					S[i][j] = Integer.parseInt(tokens.nextToken());
			}

			selected = new int[N];
			for (int i = 0; i < N / 2; i++)
				selected[i] = 0;
			for (int i = N / 2; i < N; i++)
				selected[i] = 1;

			minDiff = Integer.MAX_VALUE;
			do {
				minDiff = Math.min(minDiff, cooking());
			} while (np());
			sb.append("#").append(t).append(" ").append(minDiff).append("\n");
		}
		System.out.println(sb);
	}
}