import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer tokens;

    private static int T, N;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            int profits = 0;
            int fromMid = N / 2;

            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                for (int j = 0; j < N; j++) {
                    if (j < fromMid || j > N - fromMid - 1) {
                        continue;
                    }
                    profits += s.charAt(j) - '0';
                }
                fromMid += i < N / 2 ? -1 : 1;
            }
            sb.append("#").append(t).append(" ").append(profits).append("\n");
        }
        System.out.println(sb);
    }
}