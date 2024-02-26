import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Edge implements Comparable<Edge> {
		int from, to, cost;

		Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.cost, o.cost);
		}
	}

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer tokens;

	private static int N;
	private static long totalCost;
	private static int[] parent;

	private static int find(int a) {
		if (parent[a] == a)
			return a;
		return parent[a] = find(parent[a]);
	}

	private static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a == b)
			return false;
		else if (a < b)
			parent[b] = a;
		else
			parent[a] = b;
		return true;
	}

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		parent = new int[N + 1];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for (int i = 1; i <= N; i++) {
			pq.add(new Edge(0, i, Integer.parseInt(br.readLine())));
			parent[i] = i;
		}
		for (int i = 1; i <= N; i++) {
			tokens = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int cost = Integer.parseInt(tokens.nextToken());
				if (i < j && cost > 0)
					pq.add(new Edge(i, j, cost));
			}
		}
		while (N > 0 && !pq.isEmpty()) {
			Edge edge = pq.poll();
			if (union(edge.from, edge.to)) {
				totalCost += edge.cost;
				N--;
			}
		}
		System.out.println(totalCost);
	}
}