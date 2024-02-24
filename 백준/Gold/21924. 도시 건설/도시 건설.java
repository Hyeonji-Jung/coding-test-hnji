import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Edge implements Comparable<Edge> {

        int from, to, cost;

        public Edge(int from, int to, int cost) {
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

    private static int N, M;
    private static long totalCost = 0, minCost = 0;
    private static int[] parent;

    private static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x < y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }

    public static void main(String[] args) throws Exception {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++)
            parent[i] = i;
        for (int i = 0; i < M; i++) {
            tokens = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(tokens.nextToken());
            int to = Integer.parseInt(tokens.nextToken());
            int cost = Integer.parseInt(tokens.nextToken());
            pq.add(new Edge(from, to, cost));
            totalCost += cost;
        }
        while (N > 1) {
            Edge edge = pq.poll();
            if (edge == null) {
                System.out.println(-1);
                return;
            }
            if (find(edge.from) != find(edge.to)) {
                union(edge.from, edge.to);
                minCost += edge.cost;
                N--;
            }
        }
        System.out.println(totalCost - minCost);
    }
}