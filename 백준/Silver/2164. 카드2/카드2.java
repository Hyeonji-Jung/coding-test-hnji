import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static int N, n;
	private static ArrayDeque<Integer> q = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		n = N;
		for (int i = 1; i <= N; i++)
			q.add(i);
		while (n-- > 1) {
			q.pollFirst();
			q.add(q.pollFirst());
		}
		System.out.println(q.pop());
	}
}