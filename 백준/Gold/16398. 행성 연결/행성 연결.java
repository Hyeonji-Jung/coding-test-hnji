import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Edge implements Comparable<Edge> {
		int x;
		int y;
		int weight;

		Edge(int x, int y, int weight) {
			this.x = x;
			this.y = y;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			if (this.weight != o.weight)
				return Integer.compare(this.weight, o.weight);
			else if (this.x != o.x)
				return Integer.compare(this.x, o.x);
			return Integer.compare(this.y, o.y);
		}
	}

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer tokens;

	private static int N, edgeCnt;
	private static long cost;
	private static int[] parents;

	private static int find(int a) {
		if (parents[a] != a)
			parents[a] = find(parents[a]);
		return parents[a];
	}

	private static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot < bRoot)
			parents[bRoot] = aRoot;
		else
			parents[aRoot] = bRoot;
	}

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		parents = new int[N];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int weight = Integer.parseInt(tokens.nextToken());
				if (i < j)
					pq.add(new Edge(i, j, weight));
			}
			parents[i] = i;
		}
		while (edgeCnt < N - 1) {
			Edge edge = pq.poll();
			if (find(edge.x) != find(edge.y)) {
				union(edge.x, edge.y);
				cost += edge.weight;
				edgeCnt++;
			}
		}
		System.out.println(cost);
	}
}