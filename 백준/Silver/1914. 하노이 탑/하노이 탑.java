import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	
	private static int N;
	
	private static void hanoi(int num, int from, int to, int via) {
		if (num == 1)
			sb.append(from).append(" ").append(to).append("\n");
		else {
			hanoi(num-1, from, via, to);
			sb.append(from).append(" ").append(to).append("\n");
			hanoi(num-1, via, to, from);
		}
	}
	
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine().trim());
		BigInteger count = new BigInteger("2");
		sb.append(count.pow(N).subtract(new BigInteger("1"))).append("\n");
		if (N <= 20)
			hanoi(N, 1, 3, 2);
		System.out.println(sb);
	}
}