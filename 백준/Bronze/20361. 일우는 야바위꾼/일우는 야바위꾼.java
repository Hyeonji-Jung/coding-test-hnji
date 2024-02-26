import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer tokens;

	private static int N, X, K;
	private static boolean[] cups;

	public static void main(String[] args) throws Exception {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		X = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		cups = new boolean[N + 1];
		cups[X] = true;
		for (int i = 0; i < K; i++) {
			tokens = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			if (cups[a]) {
				X = b;
				cups[a] = false;
				cups[b] = true;
			} else if (cups[b]) {
				X = a;
				cups[b] = false;
				cups[a] = true;
			}
		}
		System.out.println(X);
	}
}