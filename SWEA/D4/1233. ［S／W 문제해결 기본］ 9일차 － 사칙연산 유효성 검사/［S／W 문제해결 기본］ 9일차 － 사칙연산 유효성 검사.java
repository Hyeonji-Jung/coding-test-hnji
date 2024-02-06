import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer tokens;

	private static int N, flag;

	public static void main(String[] args) throws Exception {
		for (int t = 1; t <= 10; t++) {
			N = Integer.parseInt(br.readLine().trim());
			flag = 1;
			for (int i = 0; i < N; i++) {
				tokens = new StringTokenizer(br.readLine());
				tokens.nextToken();
				char val = tokens.nextToken().charAt(0);
				if (tokens.hasMoreTokens() && Character.isDigit(val))
					flag = 0;
				else if (!tokens.hasMoreTokens() && !Character.isDigit(val))
					flag = 0;
			}
			sb.append("#").append(t).append(" ").append(flag).append("\n");
		}
		System.out.println(sb);
	}
}