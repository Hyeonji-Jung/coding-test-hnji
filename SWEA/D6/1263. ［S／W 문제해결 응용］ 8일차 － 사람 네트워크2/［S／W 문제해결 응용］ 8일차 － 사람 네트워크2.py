import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static final int INF = (int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            int[][] net = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    net[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i != j && net[i][j] == 0) {
                        net[i][j] = INF;
                    }
                }
            }

            for (int k = 0; k < N; k++) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        net[i][j] = Math.min(net[i][j], net[i][k] + net[k][j]);
                    }
                }
            }

            int ans = INF;
            for (int i = 0; i < N; i++) {
                int curr = 0;
                for (int j = 0; j < N; j++) {
                    curr += net[i][j];
                }
                ans = Math.min(ans, curr);
            }

            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }

        System.out.println(sb);
    }
}