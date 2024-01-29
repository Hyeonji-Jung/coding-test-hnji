import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer tokens;

	private static int N, M;
	private static int[] arr;
	private static boolean[] visited;
	private static int[] res;

	private static void dfs(int start, int depth) {
		if (depth == M) {
			for (int n : res)
				sb.append(n).append(" ");
			sb.append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			if (visited[i] == false) {
				res[depth] = arr[i];
				visited[i] = true;
				dfs(i + 1, depth + 1);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		arr = new int[N];
		visited = new boolean[N];
		res = new int[M];
		tokens = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(tokens.nextToken());
			visited[i] = false;
		}
		Arrays.sort(arr);
		
		dfs(0, 0);
		System.out.println(sb);
	}
}