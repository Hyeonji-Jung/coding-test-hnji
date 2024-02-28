import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer tokens;

	private static int N, minDiff = Integer.MAX_VALUE;
	private static int[] populations;
	private static ArrayList<Integer>[] graph;
	private static ArrayList<Integer> area1, area2;
	private static boolean[] whichArea, visited;

	private static boolean isConnect(ArrayList<Integer> area) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		visited = new boolean[N + 1];
		visited[area.get(0)] = true;
		q.offer(area.get(0));
		int visitCnt = 1;
		while (!q.isEmpty()) {
			int curr = q.poll();
			for (int next : graph[curr])
				if (!visited[next] && area.contains(next)) {
					visited[next] = true;
					q.offer(next);
					visitCnt++;
				}
		}
		if (visitCnt == area.size())
			return true;
		return false;
	}

	private static void powerSet(int depth) {
		if (depth > N) {
			area1 = new ArrayList<>();
			area2 = new ArrayList<>();
			for (int i = 1; i <= N; i++) {
				if (whichArea[i])
					area1.add(i);
				else
					area2.add(i);
			}
			if (area1.size() == 0 || area2.size() == 0)
				return;
			if (isConnect(area1) && isConnect(area2)) {
				int diff = 0;
				for (int i = 1; i <= N; i++) {
					if (whichArea[i])
						diff += populations[i];
					else
						diff -= populations[i];
				}
				minDiff = Math.min(minDiff, Math.abs(diff));
			}
			return;
		}
		powerSet(depth + 1);
		whichArea[depth] = true;
		powerSet(depth + 1);
		whichArea[depth] = false;
	}

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		populations = new int[N + 1];
		tokens = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++)
			populations[i] = Integer.parseInt(tokens.nextToken());
		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			graph[i] = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			tokens = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(tokens.nextToken());
			for (int j = 0; j < cnt; j++) {
				int a = Integer.parseInt(tokens.nextToken());
				graph[i].add(a);
				graph[a].add(i);
			}
		}
		whichArea = new boolean[N + 1];
		powerSet(1);
		System.out.println(minDiff == Integer.MAX_VALUE ? -1 : minDiff);
	}
}