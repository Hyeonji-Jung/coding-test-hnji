import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer tokens;
	
	private static int switches;
	private static boolean[] on;
	private static int students;

	public static void main(String[] args) throws Exception {
		switches = Integer.parseInt(br.readLine());
		on = new boolean[switches];
		tokens = new StringTokenizer(br.readLine());
		for (int i = 0; i < switches; i++)
			on[i] = Integer.parseInt(tokens.nextToken()) == 1 ? true : false;
		students = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < students; i++) {
			tokens = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(tokens.nextToken());
			int number = Integer.parseInt(tokens.nextToken());
			
			if (gender == 1) {
				for (int j = number - 1; j < switches; j += number)
					on[j] = !on[j];
			} else {
				on[number - 1] = !on[number - 1];
				for (int j = 1; j < switches / 2; j++) {
					int left = number - 1 - j;
					int right = number - 1 + j;
					if (left < 0 || right >= switches || on[left] != on[right])
						break;
					on[left] = !on[left];
					on[right] = !on[right];
				}
			}
		}
		for (int i = 0; i < switches; i++) {
			sb.append(on[i] ? 1 : 0);
			if (i != switches - 1)
				sb.append(" ");
			if ((i + 1) % 20 == 0)
				sb.append("\n");
		}
		System.out.println(sb);
	}
}