import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer tokens;

	private static int N, d, k, c, max;
	private static int[] belt;
	private static int[] visited;

	public static void main(String[] args) throws Exception {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		d = Integer.parseInt(tokens.nextToken());
		k = Integer.parseInt(tokens.nextToken());
		c = Integer.parseInt(tokens.nextToken());
		belt = new int[N];
		for (int i = 0; i < N; i++)
			belt[i] = Integer.parseInt(br.readLine());

		visited = new int[d + 1];
		int cnt = 0;
		for (int i = 0; i < k; i++) {
			if (visited[belt[i]] == 0)
				cnt++;
			visited[belt[i]]++;
		}
		max = visited[c] == 0 ? cnt + 1 : cnt;
		for (int i = 1; i < N; i++) {
			visited[belt[i - 1]]--;
			if (visited[belt[i - 1]] == 0)
				cnt--;
			if (visited[belt[(i + k - 1) % N]] == 0)
				cnt++;
			visited[belt[(i + k - 1) % N]]++;
			max = Math.max(max, visited[c] == 0 ? cnt + 1 : cnt);
		}
		System.out.println(max);
	}
}