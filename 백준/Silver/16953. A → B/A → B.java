import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static class Pair {
		long num;
		long count;

		public Pair(long num, long count) {
			this.num = num;
			this.count = count;
		}
	}

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer tokens;
	private static long A, B;
	private static boolean flag;
	private static Queue<Pair> queue = new LinkedList<>();

	private static void bfs() {
		queue.add(new Pair(A, 0));
		while (!queue.isEmpty()) {
			Pair top = queue.poll();
			if (top.num == B) {
				System.out.println(top.count + 1);
				flag = true;
				break;
			} else if (top.num < B) {
				queue.add(new Pair(top.num * 2, top.count + 1));
				queue.add(new Pair(top.num * 10 + 1, top.count + 1));
			}
		}
	}

	public static void main(String[] args) throws Exception {
		tokens = new StringTokenizer(br.readLine());
		A = Long.parseLong(tokens.nextToken());
		B = Long.parseLong(tokens.nextToken());
		bfs();
		if (!flag)
			System.out.println(-1);
	}
}