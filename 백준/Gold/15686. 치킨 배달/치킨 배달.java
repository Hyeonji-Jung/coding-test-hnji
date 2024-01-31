import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Pair {
	int x;
	int y; 
	
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer tokens;
	
	private static int N, M;
	private static int[][] city;
	
	private static List<Pair> houses = new ArrayList<>();
	private static List<Pair> chickens = new ArrayList<>();
	private static boolean[] alive;
	private static int minDist = Integer.MAX_VALUE;
	
	private static int getDist(Pair house, Pair chicken) {
		return Math.abs(house.x - chicken.x) + Math.abs(house.y - chicken.y);
	}
	
	private static int getChickenDist() {
		int dist = 0;
		for (Pair house : houses) {
			int currMinDist = Integer.MAX_VALUE;
			for (int i = 0; i < chickens.size(); i++)
				if (alive[i])
					currMinDist = Math.min(currMinDist, getDist(house, chickens.get(i)));
			dist += currMinDist;
		}
		return dist;
	}
	
	private static void dfs(int start, int depth) {
		if (depth == M) {
			minDist = Math.min(minDist, getChickenDist());
			return;
		}
		for (int i = start; i < chickens.size(); i++) {
			alive[i] = true;
			dfs(i + 1, depth + 1);
			alive[i] = false;
		}
	}

	public static void main(String[] args) throws Exception {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		city = new int[N][N];
		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				city[i][j] = Integer.parseInt(tokens.nextToken());
				if (city[i][j] == 1)
					houses.add(new Pair(i, j));
				else if (city[i][j] == 2)
					chickens.add(new Pair(i, j));
			}
		}
		alive = new boolean[chickens.size()];
		
		dfs(0, 0);
		System.out.println(minDist);
	}
}