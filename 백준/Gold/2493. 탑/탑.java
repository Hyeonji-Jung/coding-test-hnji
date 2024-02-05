import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static class Pair {
		int index;
		int height;

		public Pair(int i, int h) {
			this.index = i;
			this.height = h;
		}
	}

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer tokens;

	private static int N;
	private static Deque<Pair> stack = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		tokens = new StringTokenizer(br.readLine());
		
		int height = Integer.parseInt(tokens.nextToken());
		sb.append(0).append(" ");
		stack.offerFirst(new Pair(1, height));
		
		for (int i = 2; i <= N; i++) {
			height = Integer.parseInt(tokens.nextToken());
			while (true) {
				if (stack.isEmpty()) {
					sb.append(0).append(" ");
					stack.offerFirst(new Pair(i, height));
					break;
				}
				Pair top = stack.peek();
				if (top.height > height) {
					sb.append(top.index).append(" ");
					stack.offerFirst(new Pair(i, height));
					break;
				} else
					stack.pollFirst();
			}
		}

		System.out.println(sb);
	}
}