import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer tokens;
	private static long A;
	private static int B, C;

	private static long pow(Long a, int b, int c) {
		if (b == 1)
			return a % c;
		
		long curr = pow(a, b / 2, c);
		if (b % 2 == 0)
			return curr * curr % c;
		else
			return curr * curr % c * A % c;
	}

	public static void main(String[] args) throws Exception {
		tokens = new StringTokenizer(br.readLine());
		A = Long.parseLong(tokens.nextToken());
		B = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		System.out.println(pow(A, B, C));
	}
}