import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer tokens;

	private static int K;
	private static int[] S;
	private static boolean[] visited;
	private static int[] lotto = new int[6];

	private static void lottery(int start, int depth) {
		if (depth == 6) {
			for (int val : lotto)
				sb.append(val).append(" ");
			sb.append("\n");
			return;
		}
		for (int i = start; i < S.length; i++) {
			if (visited[i] == false) {
				lotto[depth] = S[i];
				visited[i] = true;
				lottery(i + 1, depth + 1);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		while (true) {
			tokens = new StringTokenizer(br.readLine());
			K = Integer.parseInt(tokens.nextToken());
			if (K == 0)
				break;

			S = new int[K];
			visited = new boolean[K];
			for (int k = 0; k < K; k++)
				S[k] = Integer.parseInt(tokens.nextToken());
			lottery(0, 0);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}