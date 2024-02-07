import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	static class Val {
		int abs;
		int val;

		Val(int abs, int val) {
			this.abs = abs;
			this.val = val;
		}
	}

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();

	private static int N;
	private static PriorityQueue<Val> q = new PriorityQueue<Val>((o1, o2) -> {
		if (o1.abs == o2.abs)
			return Integer.compare(o1.val, o2.val);
		return Integer.compare(o1.abs, o2.abs);
	});

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x != 0)
				q.offer(new Val(Math.abs(x), x));
			else {
				Val val = q.poll();
				sb.append(val == null ? "0" : val.val).append("\n");
			}
		}
		System.out.println(sb);
	}
}