import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer tokens;

	private static int N, M;
	private static int[] arr;

	private static void dfs(int start, int depth) {
		if (depth == M) {
			for (int n : arr)
				sb.append(n).append(" ");
			sb.append("\n");
			return;
		}
		for (int i = start; i <= N; i++) {
			arr[depth] = i;
			dfs(i + 1, depth + 1);
		}
	}

	public static void main(String[] args) throws Exception {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		arr = new int[M];

		dfs(1, 0);
		System.out.println(sb);
	}
}