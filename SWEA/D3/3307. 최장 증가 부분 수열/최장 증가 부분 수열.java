import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder sb = new StringBuilder();

	static int T, N;
	static int[] seq, dp;

	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			seq = new int[N];
			tokens = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				seq[i] = Integer.parseInt(tokens.nextToken());
			dp = new int[N];
			for (int i = 0; i < N; i++) {
				dp[i] = 1;
				for (int j = 0; j < i; j++)
					if (seq[j] < seq[i])
						dp[i] = Math.max(dp[i], dp[j] + 1);
			}
			int maxLength = 0;
			for (int i = 0; i < N; i++) {
				maxLength = Math.max(maxLength, dp[i]);
			}
			sb.append("#" + t + " " + maxLength + "\n");
		}
		System.out.println(sb);
	}
}