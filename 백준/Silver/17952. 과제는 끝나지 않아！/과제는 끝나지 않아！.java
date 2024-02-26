import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	static class Work {
		int A, T;

		Work(int A, int T) {
			this.A = A;
			this.T = T;
		}
	}

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer tokens;

	private static int N, score;
	private static ArrayDeque<Work> works = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(br.readLine());
			switch (Integer.parseInt(tokens.nextToken())) {
			case 0:
				Work currWork = works.peek();
				if (currWork != null) {
					if (currWork.T - 1 == 0) {
						score += currWork.A;
						works.poll();
					} else
						currWork.T--;
				}
				break;
			case 1:
				int A = Integer.parseInt(tokens.nextToken());
				int T = Integer.parseInt(tokens.nextToken());
				if (T == 1)
					score += A;
				else
					works.offerFirst(new Work(A, T - 1));
				break;
			}
		}
		System.out.println(score);
	}
}