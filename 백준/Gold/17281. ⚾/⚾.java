import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer tokens;

	private static int N, score, maxScore;
	private static int[][] game;
	private static int[] players, seq = new int[] { 2, 3, 4, 5, 6, 7, 8, 9 };

	private static boolean np() {
		int i = 7;
		while (i > 0 && seq[i - 1] > seq[i])
			i--;
		if (i == 0)
			return false;
		int j = 7;
		while (seq[i - 1] > seq[j])
			j--;
		int temp = seq[i - 1];
		seq[i - 1] = seq[j];
		seq[j] = temp;
		int k = 7;
		while (i < k) {
			temp = seq[i];
			seq[i++] = seq[k];
			seq[k--] = temp;
		}
		return true;
	}

	private static void setPlayers() {
		players = new int[9];
		for (int i = 0; i < 3; i++)
			players[i] = seq[i];
		players[3] = 1;
		for (int i = 4; i < 9; i++)
			players[i] = seq[i - 1];
	}

	private static int playInning(int inning, int player) {
		boolean[] roo = new boolean[] { false, false, false };
		int out = 0;
		while (true) {
			switch (game[inning][players[player] - 1]) {
			case 1:
				if (roo[2])
					score++;
				roo[2] = roo[1];
				roo[1] = roo[0];
				roo[0] = true;
				break;
			case 2:
				if (roo[2])
					score++;
				if (roo[1])
					score++;
				roo[2] = roo[0];
				roo[1] = true;
				roo[0] = false;
				break;
			case 3:
				if (roo[2])
					score++;
				if (roo[1])
					score++;
				if (roo[0])
					score++;
				roo[2] = true;
				roo[1] = roo[0] = false;
				break;
			case 4:
				score++;
				if (roo[2])
					score++;
				if (roo[1])
					score++;
				if (roo[0])
					score++;
				roo[2] = roo[1] = roo[0] = false;
				break;
			case 0:
				out++;
				break;
			}
			player = (player + 1) % 9;
			if (out == 3)
				return player;
		}
	}

	private static void playGame() {
		setPlayers();
		int player = 0;
		for (int i = 0; i < N; i++)
			player = playInning(i, player);
	}

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		game = new int[N][9];
		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++)
				game[i][j] = Integer.parseInt(tokens.nextToken());
		}
		do {
			score = 0;
			playGame();
			maxScore = Math.max(maxScore, score);
		} while (np());
		System.out.println(maxScore);
	}
}