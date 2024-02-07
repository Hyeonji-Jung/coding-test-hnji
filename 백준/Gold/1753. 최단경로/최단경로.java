import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int idx;
		int dist;

		Node(int idx, int dist) {
			this.idx = idx;
			this.dist = dist;
		}
	}

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer tokens;

	private static int V, E, K;
	private static List<Node>[] graph;
	private static int[] dist;

	public static void main(String[] args) throws Exception {
		tokens = new StringTokenizer(br.readLine());
		V = Integer.parseInt(tokens.nextToken());
		E = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(br.readLine().trim());
		graph = new ArrayList[V];
		dist = new int[V];
		for (int i = 0; i < V; i++) {
			graph[i] = new ArrayList<>();
			dist[i] = 10_000_000;
		}
		dist[K - 1] = 0;
		for (int i = 0; i < E; i++) {
			tokens = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(tokens.nextToken());
			int v = Integer.parseInt(tokens.nextToken());
			int w = Integer.parseInt(tokens.nextToken());
			graph[u - 1].add(new Node(v - 1, w));
		}

		PriorityQueue<Node> q = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.dist, o2.dist));
		q.offer(new Node(K - 1, 0));
		while (!q.isEmpty()) {
			Node curr = q.poll();
			for (Node next : graph[curr.idx]) {
				if (dist[next.idx] > dist[curr.idx] + next.dist) {
					dist[next.idx] = dist[curr.idx] + next.dist;
					q.offer(new Node(next.idx, dist[next.idx]));
				}
			}
		}
		for (int d : dist) {
			if (d == 10_000_000)
				sb.append("INF");
			else
				sb.append(d);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}