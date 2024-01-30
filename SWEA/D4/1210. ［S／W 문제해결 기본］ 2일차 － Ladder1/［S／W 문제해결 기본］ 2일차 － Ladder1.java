import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer tokens;

    private static boolean[][] ladder = new boolean[100][100];
    private static int r, c;

    public static void main(String[] args) throws Exception {
        for (int t = 1; t <= 10; t++) {
            br.readLine();
            for (int i = 0; i < 100; i++) {
                tokens = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    char temp = tokens.nextToken().charAt(0);
                    ladder[i][j] = temp != '0';
                    if (i == 99 && temp == '2') {
                        c = j;
                    }
                }
            }
            r = 99;
            while (r != 0) {
                moveHorizontally();
                if (r != 0) {
                    r--;
                }
            }
            sb.append("#").append(t).append(" ").append(c).append("\n");
        }
        System.out.println(sb);
    }

    private static void moveHorizontally() {
        if (c - 1 >= 0 && ladder[r][c - 1]) {
            while (c - 1 >= 0 && ladder[r][c - 1]) {
                c--;
            }
        } else if (c + 1 < 100 && ladder[r][c + 1]) {
            while (c + 1 < 100 && ladder[r][c + 1]) {
                c++;
            }
        }
    }
}