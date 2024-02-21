import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer tokens;

	private static int T, N, M;
	private static int[] parent;

	private static int find(int a) {
		if (parent[a] < 0)
			return a;
		return parent[a] = find(parent[a]);
	}

	private static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot != bRoot) {
			parent[aRoot] += parent[bRoot];
			parent[bRoot] = aRoot;
		}
	}

	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			tokens = new StringTokenizer(br.readLine());
			N = Integer.parseInt(tokens.nextToken());
			M = Integer.parseInt(tokens.nextToken());
			parent = new int[N];
			for (int i = 0; i < N; i++)
				parent[i] = -1;
			for (int i = 0; i < M; i++) {
				tokens = new StringTokenizer(br.readLine());
				int comm = Integer.parseInt(tokens.nextToken());
				int a = Integer.parseInt(tokens.nextToken()) - 1;
				int b = Integer.parseInt(tokens.nextToken()) - 1;
				if (comm == 0)
					union(a, b);
				else
					sb.append(a == b || find(a) == find(b) ? 1 : 0);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}