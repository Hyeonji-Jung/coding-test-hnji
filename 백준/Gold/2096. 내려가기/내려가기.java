import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer tokens;
	
	private static int[][] game;
	private static int[][] maxDp;
	private static int[][] minDp;
	private static int N;
	
	private static int[] prev = {-1, 0, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		game = new int[N][3];
		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				game[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		maxDp = new int[N][3];
		minDp = new int[N][3];
		for (int i = 0; i < 3; i++) {
			maxDp[0][i] = game[0][i];
			minDp[0][i] = game[0][i];
		}
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				maxDp[i][j] = -1;
				minDp[i][j] = Integer.MAX_VALUE;
				for (int k = 0; k < 3; k++) {
					int ny = j + prev[k];
					if (ny >= 0 && ny < 3) {
						maxDp[i][j] = Math.max(maxDp[i][j], game[i][j] + maxDp[i-1][ny]);
						minDp[i][j] = Math.min(minDp[i][j], game[i][j] + minDp[i-1][ny]);
					}
				}
			}
		}
		System.out.printf("%d %d", Math.max(Math.max(maxDp[N-1][0],maxDp[N-1][1]),maxDp[N-1][2]), Math.min(Math.min(minDp[N-1][0], minDp[N-1][1]), minDp[N-1][2]));
	}
}