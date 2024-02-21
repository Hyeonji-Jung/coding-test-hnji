import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static class CCTV {
		int x;
		int y;
		int type;

		CCTV(int x, int y, int type) {
			this.x = x;
			this.y = y;
			this.type = type;
		}
	}

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer tokens;

	private static int N, M, cctvCnt, spaceCnt, minUnseen = Integer.MAX_VALUE;
	private static ArrayList<CCTV> cctvs = new ArrayList<>();
	private static int[] canSeeDirs = new int[] { 1, 2, 2, 3, 4 };
	private static int[] rotations = new int[] { 4, 2, 4, 4, 1 };
	private static int[][][] dirs = new int[][][] { { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } },
			{ { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } },
			{ { -1, 0 }, { 0, 1 }, { 0, 1 }, { 1, 0 }, { 1, 0 }, { 0, -1 }, { 0, -1 }, { -1, 0 } },
			{ { 0, -1 }, { -1, 0 }, { 0, 1 }, { -1, 0 }, { 0, 1 }, { 1, 0, }, { 0, 1 }, { 1, 0, }, { 0, -1 }, { 1, 0, },
					{ 0, -1 }, { -1, 0 } },
			{ { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } } };

	private static void dfs(int depth, int[][] office, int unseen) {
		if (depth == cctvCnt) {
			minUnseen = Math.min(minUnseen, unseen);
			return;
		}
		CCTV cctv = cctvs.get(depth);
		for (int i = 0; i < rotations[cctv.type]; i++) {
			int seenCnt = 0;
			int[][] temp = new int[N][];
			for (int k = 0; k < N; k++)
				temp[k] = office[k].clone();
			for (int j = 0; j < canSeeDirs[cctv.type]; j++) {
				int d = 1;
				while (true) {
					int nx = cctv.x + dirs[cctv.type][i * canSeeDirs[cctv.type] + j][0] * d;
					int ny = cctv.y + dirs[cctv.type][i * canSeeDirs[cctv.type] + j][1] * d;
					if (nx < 0 || nx >= N || ny < 0 || ny >= M || temp[nx][ny] == 6)
						break;
					if (temp[nx][ny] == 0) {
						temp[nx][ny] = -1;
						seenCnt++;
					}
					d++;
				}
			}
			dfs(depth + 1, temp, unseen - seenCnt);
		}
	}

	public static void main(String[] args) throws Exception {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		int[][] office = new int[N][M];
		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				office[i][j] = Integer.parseInt(tokens.nextToken());
				if (office[i][j] == 0)
					spaceCnt++;
				else if (office[i][j] != 0 && office[i][j] != 6) {
					cctvs.add(new CCTV(i, j, office[i][j] - 1));
					cctvCnt++;
				}
			}
		}
		dfs(0, office, spaceCnt);
		System.out.println(minUnseen);
	}
}