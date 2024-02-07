import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer tokens;

	private static int N, M, knowFirst, cnt;
	private static int[] parents;
	private static ArrayList<Integer>[] parties;

	private static int find(int p) {
		return (parents[p] != p) ? parents[p] = find(parents[p]) : parents[p];
	}

	private static void union(int p1, int p2) {
		int p1Root = find(p1);
		int p2Root = find(p2);
		if (p1Root < p2Root)
			parents[p2Root] = p1Root;
		else
			parents[p1Root] = p2Root;
	}

	public static void main(String[] args) throws Exception {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());

		parents = new int[N + 1];
		for (int i = 1; i <= N; i++)
			parents[i] = i;

		tokens = new StringTokenizer(br.readLine());
		knowFirst = tokens.nextToken().equals("0") ? -1 : Integer.parseInt(tokens.nextToken());
		while (tokens.hasMoreTokens())
			union(knowFirst, Integer.parseInt(tokens.nextToken()));

		parties = new ArrayList[M];
		for (int i = 0; i < M; i++) {
			parties[i] = new ArrayList<>();
			tokens = new StringTokenizer(br.readLine());
			tokens.nextToken();
			int first = Integer.parseInt(tokens.nextToken());
			parties[i].add(first);
			while (tokens.hasMoreTokens()) {
				int one = Integer.parseInt(tokens.nextToken());
				parties[i].add(one);
				union(first, one);
			}
		}

		if (knowFirst == -1)
			cnt = M;
		else {
			for (ArrayList<Integer> party : parties)
				if (find(knowFirst) != find(party.get(0)))
					cnt++;
		}
		System.out.println(cnt);
	}
}