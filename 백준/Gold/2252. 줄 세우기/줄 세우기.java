import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer tokens;

	private static int N, M;
	private static ArrayList<Integer>[] students;
	private static int[] inDegrees;

	public static void main(String[] args) throws Exception {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		students = new ArrayList[N];
		for (int i = 0; i < N; i++)
			students[i] = new ArrayList<>();
		inDegrees = new int[N];
		for (int i = 0; i < M; i++) {
			tokens = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(tokens.nextToken()) - 1;
			int b = Integer.parseInt(tokens.nextToken()) - 1;
			students[a].add(b);
			inDegrees[b]++;
		}
		ArrayDeque<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < N; i++)
			if (inDegrees[i] == 0)
				q.offer(i);
		while (!q.isEmpty()) {
			int node = q.poll();
			sb.append(node + 1 + " ");
			for (int student : students[node])
				if (--inDegrees[student] == 0)
					q.offer(student);
		}
		System.out.println(sb);
	}
}