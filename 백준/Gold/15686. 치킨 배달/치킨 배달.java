import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static class Pos {
		int x;
		int y;

		Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

		static int getDist(Pos p1, Pos p2) {
			return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
		}
	}

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer tokens;

	private static int N, M, houseCnt, chickenCnt, minDist = Integer.MAX_VALUE;
	private static ArrayList<Pos> houses = new ArrayList<>(), chickens = new ArrayList<>();
	private static int[][] dists;
	private static int[] selected;

	private static void dfs(int depth, int start) {
		if (depth == M) {
			int cityDist = 0;
			for (int i = 0; i < houseCnt; i++) {
				int currDist = Integer.MAX_VALUE;
				for (int s : selected)
					currDist = Math.min(currDist, dists[s][i]);
				cityDist += currDist;
			}
			minDist = Math.min(minDist, cityDist);
			return;
		}
		for (int i = start; i < chickenCnt; i++) {
			selected[depth] = i;
			dfs(depth + 1, i + 1);
		}
	}

	public static void main(String[] args) throws Exception {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				switch (Integer.parseInt(tokens.nextToken())) {
				case 1:
					houses.add(new Pos(i, j));
					houseCnt++;
					break;
				case 2:
					chickens.add(new Pos(i, j));
					chickenCnt++;
					break;
				}
			}
		}
		dists = new int[chickenCnt][houseCnt];
		for (int i = 0; i < chickenCnt; i++)
			for (int j = 0; j < houseCnt; j++)
				dists[i][j] = Pos.getDist(chickens.get(i), houses.get(j));
		selected = new int[M];
		dfs(0, 0);
		System.out.println(minDist);
	}
}