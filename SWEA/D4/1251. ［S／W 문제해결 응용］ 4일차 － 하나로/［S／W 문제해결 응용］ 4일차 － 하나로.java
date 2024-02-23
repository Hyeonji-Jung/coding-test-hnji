import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

	static class Tunnel implements Comparable<Tunnel> {
		int i1;
		int i2;
		double dist;

		Tunnel(int i1, int i2, double dist) {
			this.i1 = i1;
			this.i2 = i2;
			this.dist = dist;
		}

		@Override
		public int compareTo(Tunnel o) {
			return Double.compare(this.dist, o.dist);
		}
	}

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer tokens;

	private static int T, N;
	private static double E, minCost;
	private static int[][] islands;
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

	private static double getSquareDist(int i1, int i2) {
		return Math.pow(islands[0][i1] - islands[0][i2], 2) + Math.pow(islands[1][i1] - islands[1][i2], 2);
	}

	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			islands = new int[2][N];
			for (int i = 0; i < 2; i++) {
				tokens = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++)
					islands[i][j] = Integer.parseInt(tokens.nextToken());
			}
			E = Double.parseDouble(br.readLine());
			PriorityQueue<Tunnel> pq = new PriorityQueue<>();
			parent = new int[N];
			for (int i = 0; i < N; i++) {
				parent[i] = i;
				for (int j = i + 1; j < N; j++)
					pq.add(new Tunnel(i, j, getSquareDist(i, j)));
			}
			minCost = 0;
			while (N > 1) {
				Tunnel tunnel = pq.poll();
				if (find(tunnel.i1) != find(tunnel.i2)) {
					union(tunnel.i1, tunnel.i2);
					minCost += tunnel.dist;
					N--;
				}
			}
			sb.append("#" + t + " " + Math.round(minCost * E) + "\n");
		}
		System.out.println(sb);
	}
}