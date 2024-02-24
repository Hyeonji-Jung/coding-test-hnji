import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
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
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer tokens;

    private static int N, M, K;
    private static ArrayList<Edge> edges = new ArrayList<>();
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
        if (a < b)
            parent[b] = a;
        else
            parent[a] = b;
        return true;
    }

    public static void main(String[] args) throws Exception {
        tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());
        K = Integer.parseInt(tokens.nextToken());
        parent = new int[N + 1];
        for (int i = 0; i < M; i++) {
            tokens = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(tokens.nextToken());
            int to = Integer.parseInt(tokens.nextToken());
            edges.add(new Edge(from, to, i + 1));
        }
        Collections.sort(edges);
        parent = new int[N + 1];
        boolean flag = false;
        for (int i = 0; i < K; i++) {
            if (!flag) {
                int totalCost = 0;
                int selected = 0;
                for (int p = 1; p <= N; p++)
                    parent[p] = p;
                for (int j = i; j < M; j++) {
                    if (selected == N - 1)
                        break;
                    Edge edge = edges.get(j);
                    if (union(edge.from, edge.to)) {
                        totalCost += edge.cost;
                        selected++;
                    }
                }
                if (selected == N - 1)
                    sb.append(totalCost + " ");
                else {
                    flag = true;
                    sb.append("0 ");
                }
            } else
                sb.append("0 ");
        }
        System.out.println(sb);
    }
}