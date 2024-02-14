import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Lesson implements Comparable<Lesson> {
		int start;
		int end;

		Lesson(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Lesson o) {
			if (this.start != o.start)
				return Integer.compare(this.start, o.start);
			return Integer.compare(this.end, o.end);
		}
	}

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer tokens;

	private static int N;
	private static ArrayList<Lesson> lessons = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(br.readLine());
			lessons.add(new Lesson(Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken())));
		}
		Collections.sort(lessons);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.offer(lessons.get(0).end);
		for (int i = 1; i < N; i++) {
			if (pq.peek() <= lessons.get(i).start)
				pq.poll();
			pq.offer(lessons.get(i).end);
		}
		System.out.println(pq.size());
	}
}