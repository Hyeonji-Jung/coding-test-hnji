import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;


public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb;
	private static StringTokenizer tokens;

	private static int N, M;
	private static int[] arr;
	private static int[] res;
	private static LinkedHashSet<String> ans = new LinkedHashSet<>();

	private static void dfs(int start, int depth) {
		if (depth == M) {
			sb = new StringBuilder();
			for (int n : res)
				sb.append(n).append(" ");
			ans.add(sb.toString());
			return;
		}
		for (int i = start; i < N; i++) {
			res[depth] = arr[i];
			dfs(i, depth + 1);
		}
	}

	public static void main(String[] args) throws Exception {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());

		arr = new int[N];
		res = new int[M];
		tokens = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(tokens.nextToken());
		Arrays.sort(arr);
		
		dfs(0, 0);
		sb = new StringBuilder();
		for (String seq : ans)
			sb.append(seq).append("\n");
		System.out.println(sb);
	}
}