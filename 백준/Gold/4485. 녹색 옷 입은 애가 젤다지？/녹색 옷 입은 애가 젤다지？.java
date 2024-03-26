import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    static class Node implements Comparable<Node> {
        int x, y, w;

        public Node(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.w, o.w);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = 0;

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0)
                break;
            T++;

            int[][] cave = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    cave[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            PriorityQueue<Node> q = new PriorityQueue<>();
            q.offer(new Node(0, 0, cave[0][0]));

            int[][] dist = new int[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(dist[i], Integer.MAX_VALUE);
            }
            dist[0][0] = 0;

            int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

            while (!q.isEmpty()) {
                Node node = q.poll();
                int x = node.x;
                int y = node.y;
                int w = node.w;

                if (x == N - 1 && y == N - 1) {
                    sb.append("Problem ").append(T).append(": ").append(w).append("\n");
                    break;
                }

                for (int[] dir : directions) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                        int nextW = w + cave[nx][ny];
                        if (nextW < dist[nx][ny]) {
                            dist[nx][ny] = nextW;
                            q.offer(new Node(nx, ny, nextW));
                        }
                    }
                }
            }
        }
        System.out.print(sb);
    }
}