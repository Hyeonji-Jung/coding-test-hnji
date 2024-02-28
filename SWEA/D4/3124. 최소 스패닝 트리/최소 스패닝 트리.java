import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

	static class Edge implements Comparable<Edge> {
		int u, v, w;

		Edge(int u, int v, int w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}
	}

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer tokens;

	private static int T, V, E;
	private static long weight;
	private static PriorityQueue<Edge> graph;
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
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			tokens = new StringTokenizer(br.readLine());
			V = Integer.parseInt(tokens.nextToken());
			E = Integer.parseInt(tokens.nextToken());
			graph = new PriorityQueue<>();
			for (int i = 0; i < E; i++) {
				tokens = new StringTokenizer(br.readLine());
				graph.add(new Edge(Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken()),
						Integer.parseInt(tokens.nextToken())));
			}
			parent = new int[V + 1];
			for (int i = 1; i <= V; i++)
				parent[i] = i;
			weight = 0;
			while (V > 1) {
				Edge curr = graph.poll();
				if (find(curr.u) != find(curr.v)) {
					union(curr.u, curr.v);
					weight += curr.w;
					V--;
				}
			}
			sb.append("#" + t + " " + weight + "\n");
		}
		System.out.println(sb);
	}
}