import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder sb = new StringBuilder();

	static int T, N, R;
	static final int MOD = 1234567891;
	static long fac[];

	public static long fermat(long n, int x) {
		if (x == 0)
			return 1;
		long tmp = fermat(n, x / 2);
		long ret = (tmp * tmp) % MOD;
		if (x % 2 == 0)
			return ret;
		else
			return (ret * n) % MOD;
	}

	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			tokens = new StringTokenizer(br.readLine());
			N = Integer.parseInt(tokens.nextToken());
			R = Integer.parseInt(tokens.nextToken());

			fac = new long[N + 1];
			fac[0] = 1;
			for (int i = 1; i <= N; i++)
				fac[i] = (fac[i - 1] * i) % MOD;

			sb.append("#").append(t).append(" ");
			sb.append((fac[N] * fermat((fac[R] * fac[N - R]) % MOD, MOD - 2)) % MOD);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}