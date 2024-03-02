import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer tokens;

    private static int n, nVerify;
    private static int[] w, wVerify;
    private static boolean[][] dp;

    private static void dfs(int idx, int num) {
        if (idx > n || dp[idx][num])
            return;
        dp[idx][num] = true;
        dfs(idx + 1, num);
        dfs(idx + 1, num + w[idx]);
        dfs(idx + 1, Math.abs(num - w[idx]));
    }

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        tokens = new StringTokenizer(br.readLine());
        w = new int[n + 1];
        for (int i = 0; i < n; i++)
            w[i] = Integer.parseInt(tokens.nextToken());
        nVerify = Integer.parseInt(br.readLine());
        tokens = new StringTokenizer(br.readLine());
        wVerify = new int[nVerify];
        for (int i = 0; i < nVerify; i++)
            wVerify[i] = Integer.parseInt(tokens.nextToken());
        dp = new boolean[n + 1][15001];
        dfs(0, 0);
        for (int num : wVerify) {
            if (num > 15000 || !dp[n][num])
                sb.append("N ");
            else
                sb.append("Y ");
        }
        System.out.println(sb);
    }
}