import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	static BigInteger a, b;
	static BigInteger[][] A = new BigInteger[][] { { BigInteger.ONE, BigInteger.ONE },
			{ BigInteger.ONE, BigInteger.ZERO } };
	static BigInteger MOD = new BigInteger("1000000000");

	static BigInteger[][] mulMatrix(BigInteger[][] M1, BigInteger[][] M2) {
		BigInteger[][] temp = new BigInteger[][] { { BigInteger.ZERO, BigInteger.ZERO },
				{ BigInteger.ZERO, BigInteger.ZERO } };
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 2; j++)
				for (int k = 0; k < 2; k++)
					temp[i][j] = temp[i][j].add(M1[i][k].multiply(M2[k][j]).mod(MOD));
		return temp;
	}

	static BigInteger[][] powMatrix(BigInteger[][] M, BigInteger n) {
		if (n.equals(BigInteger.ONE))
			return M;
		if (n.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
			BigInteger[][] temp = powMatrix(M, n.divide(BigInteger.valueOf(2)));
			return mulMatrix(temp, temp);
		} else {
			BigInteger[][] temp = powMatrix(M, n.subtract(BigInteger.ONE));
			return mulMatrix(temp, M);
		}
	}

	public static void main(String[] args) throws Exception {
		tokens = new StringTokenizer(br.readLine());
		a = new BigInteger(tokens.nextToken());
		b = new BigInteger(tokens.nextToken());

		BigInteger result = powMatrix(A, b.add(BigInteger.ONE))[0][0].subtract(powMatrix(A, a)[0][0]);
		System.out.println(result.mod(MOD));
	}
}