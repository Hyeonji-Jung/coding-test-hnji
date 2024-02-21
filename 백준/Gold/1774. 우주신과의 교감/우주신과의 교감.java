import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Vertex {
		int x;
		int y;

		Vertex(int x, int y) {
			this.x = x;
			this.y = y;
		}

		static double getDist(Vertex v1, Vertex v2) {
			return Math.sqrt(Math.pow(v1.x - v2.x, 2) + Math.pow(v1.y - v2.y, 2));
		}
	}

	static class Edge implements Comparable<Edge> {
		int v1;
		int v2;
		double dist;

		Edge(int v1, int v2, double dist) {
			this.v1 = v1;
			this.v2 = v2;
			this.dist = dist;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.dist, o.dist);
		}
	}

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer tokens;

	private static int N, M;
	private static double minDist = 0;
	private static Vertex[] coord;
	private static int[] parent;

	private static int find(int a) {
		if (parent[a] == a)
			return a;
		return parent[a] = find(parent[a]);
	}

	private static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot < bRoot)
			parent[bRoot] = aRoot;
		else
			parent[aRoot] = bRoot;
	}

	public static void main(String[] args) throws Exception {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		coord = new Vertex[N + 1];
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
			tokens = new StringTokenizer(br.readLine());
			coord[i] = new Vertex(Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken()));
		}
		for (int i = 0; i < M; i++) {
			tokens = new StringTokenizer(br.readLine());
			union(Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken()));
		}
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for (int i = 1; i < N; i++)
			for (int j = i + 1; j <= N; j++)
				pq.add(new Edge(Math.min(i, j), Math.max(i, j), Vertex.getDist(coord[i], coord[j])));
		while (!pq.isEmpty()) {
			Edge edge = pq.poll();
			if (find(edge.v1) != find(edge.v2)) {
				union(edge.v1, edge.v2);
				minDist += edge.dist;
			}
		}
		System.out.printf("%.2f", minDist);
	}
}