import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {

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

	static class BC implements Comparable<BC> {
		int num;
		Pos pos;
		int c;
		int p;

		BC(int num, int x, int y, int c, int p) {
			this.num = num;
			this.pos = new Pos(x, y);
			this.c = c;
			this.p = p;
		}

		@Override
		public int compareTo(BC o) {
			return -Integer.compare(this.p, o.p);
		}

		@Override
		public String toString() {
			return "BC" + num + " " + p;
		}
	}

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer tokens;

	private static int T, M, A, charge;
	private static int[][] moves;
	private static int[][] del = { { 0, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };
	private static Pos user1, user2;
	private static BC[] bcs;
	private static ArrayList<BC> able1 = new ArrayList<>(), able2 = new ArrayList<>();

	private static void charge() {
		for (BC bc : bcs) {
			if (Pos.getDist(user1, bc.pos) <= bc.c)
				able1.add(bc);
			if (Pos.getDist(user2, bc.pos) <= bc.c)
				able2.add(bc);
		}
		Collections.sort(able1);
		Collections.sort(able2);
		if (able1.isEmpty() || able2.isEmpty()) {
			charge += !able1.isEmpty() ? able1.get(0).p : 0;
			charge += !able2.isEmpty() ? able2.get(0).p : 0;
		} else {
			int maxCharge = 0;
			for (BC bc1 : able1) {
				for (BC bc2 : able2) {
					int currCharge = bc1.p;
					currCharge += bc1.num == bc2.num ? 0 : bc2.p;
					maxCharge = Math.max(maxCharge, currCharge);
				}
			}
			charge += maxCharge;
		}
		able1.clear();
		able2.clear();
	}

	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			tokens = new StringTokenizer(br.readLine());
			M = Integer.parseInt(tokens.nextToken());
			A = Integer.parseInt(tokens.nextToken());
			moves = new int[2][M + 1];
			for (int i = 0; i < 2; i++) {
				tokens = new StringTokenizer(br.readLine());
				for (int j = 1; j < M + 1; j++)
					moves[i][j] = Integer.parseInt(tokens.nextToken());
			}
			bcs = new BC[A];
			for (int i = 0; i < A; i++) {
				tokens = new StringTokenizer(br.readLine());
				bcs[i] = new BC(i, Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken()),
						Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken()));
			}
			user1 = new Pos(1, 1);
			user2 = new Pos(10, 10);
			charge = 0;
			for (int i = 0; i < M + 1; i++) {
				user1.x += del[moves[0][i]][0];
				user1.y += del[moves[0][i]][1];
				user2.x += del[moves[1][i]][0];
				user2.y += del[moves[1][i]][1];
				charge();
			}
			sb.append("#" + t + " ").append(charge).append("\n");
		}
		System.out.println(sb);
	}
}