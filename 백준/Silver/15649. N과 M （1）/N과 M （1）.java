import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer tokens;

	private static int N, M;

	private static void makeComb(int depth, int[] seq, boolean[] visited) {
		if (depth == M) {
			for (int num : seq)
				sb.append(num).append(" ");
			sb.append("\n");
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (!visited[i - 1]) {
				visited[i - 1] = true;
				seq[depth] = i;
				makeComb(depth + 1, seq, visited);
				visited[i - 1] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		makeComb(0, new int[M], new boolean[N]);
		System.out.println(sb);
	}
}