import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer tokens;

	private static int N, K;
	private static Deque<Integer> queue = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		for (int i = 1; i <= N; i++)
			queue.offer(i);

		sb.append("<");
		while (!queue.isEmpty()) {
			for (int i = 0; i < K - 1; i++)
				queue.offer(queue.poll());
			sb.append(queue.poll());
			if (!queue.isEmpty())
				sb.append(", ");
		}
		sb.append(">");
		System.out.println(sb);
	}
}