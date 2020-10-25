package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class dp_11057 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[][] dp = new long[10][n + 1];
		for (int i = 0; i < dp.length; i++) {
			dp[i][1] = 1;
		}
		for (int i = 2; i <= n; i++) {
			long sum = 0;
			for (int k = 0; k < 10; k++) {
				sum += dp[k][i - 1];
				dp[k][i] = sum%10007;
			}
		}
		long answer = 0;
		for (int i = 0; i < 10; i++) {
			answer += dp[i][n]%10007;
		}
		System.out.println(answer%10007);

	}

}
