import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer tokens;

	private static int N;
	private static Deque<Integer> stack = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		tokens = new StringTokenizer(br.readLine());

		int curr = 1;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(tokens.nextToken());
			if (num != curr)
				stack.offerFirst(num);
			else {
				curr++;
				while (!stack.isEmpty() && stack.peek() == curr) {
					stack.pollFirst();
					curr++;
				}
			}
		}
		while (!stack.isEmpty() && stack.peek() == curr + 1) {
			stack.pollFirst();
			curr++;
		}
		System.out.println(stack.isEmpty() ? "Nice" : "Sad");
	}
}