import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer tokens;

	private static int N, M, knows;
	private static int[] parent;

	private static int find(int a) {
		if (parent[a] == a)
			return a;
		return parent[a] = find(parent[a]);
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a < b)
			parent[b] = a;
		else
			parent[a] = b;
	}

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++)
			parent[i] = i;
		for (int i = 0; i < M; i++) {
			tokens = new StringTokenizer(br.readLine());
			union(Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken()));
		}
		for (int i = 2; i <= N; i++)
			if (find(i) == 1)
				knows++;
		System.out.println(knows);
	}
}