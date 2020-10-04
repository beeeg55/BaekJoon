package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class do_2579 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] stair = new int[N+1];
		int[] dp = new int[N+1];
		boolean[] seq = new boolean[N+1];
		for (int i = 1; i <= N; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}
		dp[1] = stair[1];
		if(N>1) {
			dp[2] = stair[1]+stair[2];
			seq[2] = true;
		}
		for (int i = 3; i <=N; i++) {
			if(dp[i-2]+stair[i]>=dp[i-1]+stair[i]||seq[i-1]) {
				dp[i] = dp[i-2]+stair[i];
				seq[i] = false;
			}else {
				dp[i] = dp[i-1]+stair[i];
				seq[i] = true;
			}
			if(stair[i-1]+stair[i]+dp[i-3]>dp[i]) {
				dp[i] = stair[i-1]+stair[i]+dp[i-3];
				seq[i] = true;
			}
		}
		System.out.println(dp[N]);
	}

}
