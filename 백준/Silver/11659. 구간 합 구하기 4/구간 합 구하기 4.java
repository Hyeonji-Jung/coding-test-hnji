import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer tokens;
	
	private static int N, M;
	private static int[] sums;

	public static void main(String[] args) throws Exception {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		sums = new int[N];
		tokens = new StringTokenizer(br.readLine());
		sums[0] = Integer.parseInt(tokens.nextToken());
		for (int i = 1; i < N; i++)
			sums[i] = sums[i - 1] + Integer.parseInt(tokens.nextToken());
		
		for (int m = 0; m < M; m++) {
			tokens = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(tokens.nextToken()) - 1;
			int j = Integer.parseInt(tokens.nextToken()) - 1;
			sb.append(sums[j] - (i > 0 ? sums[i - 1] : 0)).append("\n");
		}
		System.out.println(sb);
	}
}