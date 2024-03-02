import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer tokens;

    private static int N;
    private static int[] students, dp;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        tokens = new StringTokenizer(br.readLine());
        students = new int[N + 1];
        for (int i = 1; i <= N; i++)
            students[i] = Integer.parseInt(tokens.nextToken());
        dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int j = i; j >= 1; j--) {
                max = Math.max(max, students[j]);
                min = Math.min(min, students[j]);
                dp[i] = Math.max(dp[i], max - min + dp[j - 1]);
            }
        }
        System.out.println(dp[N]);
    }
}