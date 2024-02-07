import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer tokens;

	private static int N, M, R;
	private static int[][] arr;

	private static void calc1() {
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[N - i - 1][j];
				arr[N - i - 1][j] = temp;
			}
		}
	}

	private static void calc2() {
		for (int j = 0; j < M / 2; j++) {
			for (int i = 0; i < N; i++) {
				int temp = arr[i][j];
				arr[i][j] = arr[i][M - j - 1];
				arr[i][M - j - 1] = temp;
			}
		}
	}

	private static void calc3() {
		int[][] newArr = new int[M][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				newArr[j][N - i - 1] = arr[i][j];
		int temp = N;
		N = M;
		M = temp;
		arr = newArr;
	}

	private static void calc4() {
		int[][] newArr = new int[M][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				newArr[M - j - 1][i] = arr[i][j];
		int temp = N;
		N = M;
		M = temp;
		arr = newArr;
	}

	private static void calc5() {
		int[][] newArr = new int[N][M];
		for (int i = 0; i < N / 2; i++)
			for (int j = 0; j < M / 2; j++)
				newArr[i][j + M / 2] = arr[i][j];
		for (int i = 0; i < N / 2; i++)
			for (int j = M / 2; j < M; j++)
				newArr[i + N / 2][j] = arr[i][j];
		for (int i = N / 2; i < N; i++)
			for (int j = M / 2; j < M; j++)
				newArr[i][j - M / 2] = arr[i][j];
		for (int i = N / 2; i < N; i++)
			for (int j = 0; j < M / 2; j++)
				newArr[i - N / 2][j] = arr[i][j];
		arr = newArr;
	}

	private static void calc6() {
		int[][] newArr = new int[N][M];
		for (int i = 0; i < N / 2; i++)
			for (int j = 0; j < M / 2; j++)
				newArr[i + N / 2][j] = arr[i][j];
		for (int i = 0; i < N / 2; i++)
			for (int j = M / 2; j < M; j++)
				newArr[i][j - M / 2] = arr[i][j];
		for (int i = N / 2; i < N; i++)
			for (int j = M / 2; j < M; j++)
				newArr[i - N / 2][j] = arr[i][j];
		for (int i = N / 2; i < N; i++)
			for (int j = 0; j < M / 2; j++)
				newArr[i][j + M / 2] = arr[i][j];
		arr = newArr;
	}

	public static void main(String[] args) throws Exception {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		R = Integer.parseInt(tokens.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				arr[i][j] = Integer.parseInt(tokens.nextToken());
		}
		tokens = new StringTokenizer(br.readLine());
		for (int r = 0; r < R; r++) {
			switch (tokens.nextToken().charAt(0)) {
			case '1':
				calc1();
				break;
			case '2':
				calc2();
				break;
			case '3':
				calc3();
				break;
			case '4':
				calc4();
				break;
			case '5':
				calc5();
				break;
			case '6':
				calc6();
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++)
				sb.append(arr[i][j]).append(" ");
			sb.append("\n");
		}
		System.out.println(sb);
	}
}