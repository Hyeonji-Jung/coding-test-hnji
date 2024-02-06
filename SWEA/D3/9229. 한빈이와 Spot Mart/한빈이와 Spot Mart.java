import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer tokens;

	private static int TC, N, M, max;
	private static int[] snacks;

	public static void main(String[] args) throws Exception {
		TC = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= TC; t++) {
			tokens = new StringTokenizer(br.readLine());
			N = Integer.parseInt(tokens.nextToken());
			M = Integer.parseInt(tokens.nextToken());
			tokens = new StringTokenizer(br.readLine());
			snacks = new int[N];
			for (int i = 0; i < N; i++)
				snacks[i] = Integer.parseInt(tokens.nextToken());
			Arrays.sort(snacks);
			int max = -1;
			int left = 0;
			int right = N - 1;
			while (left < right) {
				int sum = snacks[left] + snacks[right];
				if (sum > M) {
					right--;
				} else {
					max = Math.max(max, sum);
					left++;
				}
			}
			sb.append("#").append(t).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}
}