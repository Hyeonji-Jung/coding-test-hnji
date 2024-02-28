import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {

	static class Visit {
		int n, depth;

		Visit(int n, int depth) {
			this.n = n;
			this.depth = depth;
		}
	}

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer tokens;

	private static int N, start, prevDepth, max;
	private static HashMap<Integer, HashSet<Integer>> g;
	private static HashMap<Integer, Boolean> visited;

	public static void main(String[] args) throws Exception {
		for (int t = 1; t <= 10; t++) {
			tokens = new StringTokenizer(br.readLine());
			N = Integer.parseInt(tokens.nextToken());
			start = Integer.parseInt(tokens.nextToken());
			tokens = new StringTokenizer(br.readLine());
			g = new HashMap<>();
			visited = new HashMap<>();
			for (int i = 0; i < N / 2; i++) {
				int from = Integer.parseInt(tokens.nextToken());
				int to = Integer.parseInt(tokens.nextToken());
				if (!g.containsKey(from))
					g.put(from, new HashSet<>());
				g.get(from).add(to);
				visited.put(from, false);
				visited.put(to, false);
			}
			ArrayDeque<Visit> q = new ArrayDeque<>();
			q.offer(new Visit(start, 0));
			visited.put(start, true);
			prevDepth = 0;
			max = Integer.MIN_VALUE;
			while (!q.isEmpty()) {
				Visit curr = q.poll();
				if (prevDepth < curr.depth) {
					max = curr.n;
					prevDepth = curr.depth;
				}
				if (prevDepth == curr.depth)
					max = Math.max(max, curr.n);
				if (g.containsKey(curr.n))
					for (int next : g.get(curr.n))
						if (!visited.get(next)) {
							q.offer(new Visit(next, curr.depth + 1));
							visited.put(next, true);
						}
			}
			sb.append("#" + t + " " + max + "\n");
		}
		System.out.println(sb);
	}
}