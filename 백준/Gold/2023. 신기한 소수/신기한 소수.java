import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();

	private static int N;

	private static void interestingPrime(int cnt, int num) {
		if (cnt == N) {
			if (isPrime(num))
				sb.append(num).append("\n");
			return;
		}
		for (int i = 1; i < 10; i += 2) {
			if (i == 5)
				continue;
			if (isPrime(num * 10 + i))
				interestingPrime(cnt + 1, num * 10 + i);
		}
	}

	private static boolean isPrime(int num) {
		for (int i = 2; i < Math.sqrt(num); i++)
			if (num % i == 0)
				return false;
		return true;
	}

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		interestingPrime(1, 2);
		interestingPrime(1, 3);
		interestingPrime(1, 5);
		interestingPrime(1, 7);
		System.out.println(sb);
	}
}